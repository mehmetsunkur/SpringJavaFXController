package com.sunkur.springjavafxcontroller;

import com.sunkur.springjavafxcontroller.config.AppContextConfig;
import com.sunkur.springjavafxcontroller.screen.ScreensContoller;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
        ScreensContoller bean = context.getBean(ScreensContoller.class);
        bean.init(stage);
        
        bean.loadScreen("/fxml/Screen1.fxml");
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
