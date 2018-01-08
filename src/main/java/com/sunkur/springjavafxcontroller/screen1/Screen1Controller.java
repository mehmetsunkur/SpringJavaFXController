/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sunkur.springjavafxcontroller.screen1;

import com.sunkur.springjavafxcontroller.screen.BaseScreenController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */
@Component
public class Screen1Controller extends BaseScreenController implements Initializable{
    @FXML
    private TextField textField;
    
    @FXML
    private void handleScreen2ButtonAction(ActionEvent event) {
        //this.text = textField.getText();
        this.sc.loadScreen("/fxml/Screen2.fxml");
    }
       @FXML
    private void handleScreen3ButtonAction(ActionEvent event) {
        //this.text = textField.getText();
        this.sc.loadScreen("/fxml/Screen3.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.screenName.setText("Screen1");
    }   
}
