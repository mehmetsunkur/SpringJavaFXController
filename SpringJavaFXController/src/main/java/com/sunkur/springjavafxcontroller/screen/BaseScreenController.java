/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sunkur.springjavafxcontroller.screen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */

public abstract class BaseScreenController implements Initializable{
    @Autowired
    protected com.sunkur.springjavafxcontroller.screen.ScreensContoller sc;
    
    @FXML
    protected Label screenName;

}
