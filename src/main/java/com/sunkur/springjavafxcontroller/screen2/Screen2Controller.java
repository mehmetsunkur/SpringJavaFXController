/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sunkur.springjavafxcontroller.screen2;

import com.sunkur.springjavafxcontroller.screen.BaseScreenController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */
@Component
public class Screen2Controller extends BaseScreenController implements Initializable{
    
        @FXML
    private void handleScreen1ButtonAction(ActionEvent event) {
        this.sc.loadScreen("/fxml/Screen1.fxml");
    }
       @FXML
    private void handleScreen3ButtonAction(ActionEvent event) {
        this.sc.loadScreen("/fxml/Screen3.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.screenName.setText("Screen2");
    }
    
}
