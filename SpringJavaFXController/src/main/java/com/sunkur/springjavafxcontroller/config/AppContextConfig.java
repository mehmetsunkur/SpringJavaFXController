/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sunkur.springjavafxcontroller.config;

import com.sunkur.springjavafxcontroller.screen.ScreensContoller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */
@Configuration
@Import(ScreensContoller.class)
@ComponentScan("com.sunkur.springjavafxcontroller")
public class AppContextConfig {
    
}
