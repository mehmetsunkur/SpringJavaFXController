/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunkur.springjavafxcontroller.screen;

import com.sunkur.springjavafxcontroller.scope.ScreenScoped;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */
@Service
public class ScreensContoller implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Stage stage;
    private String currentScreenId;
    private Map<String, BaseScreenController> screens = new HashMap<String, BaseScreenController>();

    public void init(Stage stage) {
        this.stage = stage;
        Group root = new Group();
        this.stage.setScene(new Scene(root));

    }

    public void loadScreen(String fxml) {
        BaseScreenController oldScreenController = this.getCurrentController();
        try {

            Class controllerClass = FXMLUtils.getControllerClass(fxml);
            final BaseScreenController fxmlController = (BaseScreenController) applicationContext.getBean(controllerClass);
            if (this.screens.get(fxmlController.getScreenId()) == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
                loader.setControllerFactory(new Callback<Class<?>, Object>() {
                    @Override
                    public Object call(Class<?> aClass) {
                        return fxmlController;
                    }
                });
                Parent root = loader.load();
                fxmlController.setRoot(root);
                this.screens.put(fxmlController.getScreenId(), fxmlController);
            }

            this.currentScreenId = fxmlController.getScreenId();
            swapScreen(getCurrentController().getRoot());
            if (oldScreenController != null) {
                if (oldScreenController.getClass().isAnnotationPresent(ScreenScoped.class)) {
                    this.screens.remove(oldScreenController.getScreenId());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean swapScreen(final Parent root) {
        final Group rootGroup = getScreenRoot();
        final DoubleProperty opacity = rootGroup.opacityProperty();
        if (!isScreenEmpty()) {

            Timeline fade = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                    new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            rootGroup.getChildren().remove(0);

                            rootGroup.getChildren().add(0, root);
                            Timeline fadeIn = new Timeline(
                                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                    new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                            fadeIn.play();
                        }
                    }, new KeyValue(opacity, 0.0)));
            fade.play();
            return true;
        } else {
            opacity.set(0.0);
            rootGroup.getChildren().add(0, root);
            Timeline fadeIn = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                    new KeyFrame(new Duration(1800), new KeyValue(opacity, 1.0)));
            fadeIn.play();
        }

        if (!this.stage.isShowing()) {
            this.stage.show();
        }
        return true;
    }

    private Group getScreenRoot() {
        return (Group) this.stage.getScene().getRoot();
    }

    private boolean isScreenEmpty() {
        return getScreenRoot().getChildren().isEmpty();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public BaseScreenController getCurrentController() {
        return screens.get(getCurrentScreenId());
    }

    public String getCurrentScreenId() {
        return currentScreenId;
    }

    public Map<String, BaseScreenController> getScreens() {
        return screens;
    }

}
