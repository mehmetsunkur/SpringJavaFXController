/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sunkur.springjavafxcontroller.screen;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */

public abstract class BaseScreenController implements Initializable, BeanNameAware{
    protected String screenId;
    @Autowired
    protected com.sunkur.springjavafxcontroller.screen.ScreensContoller sc;
    protected Parent root;

    
    @FXML
    protected Label screenName;

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }
    @Override
    public void setBeanName(String name) {
        this.screenId = name;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }
    
    
}
