/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sunkur.springjavafxcontroller.config;

import com.sunkur.springjavafxcontroller.scope.ScreenScope;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */
@Configuration
@ComponentScan("com.sunkur.springjavafxcontroller")
public class AppContextConfig {
    @Bean
    public CustomScopeConfigurer getCustomScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        final Map<String, Object> scopeMap = new HashMap<>();
        scopeMap.put("screen", screenScope());
        configurer.setScopes(scopeMap);
        return configurer;
    }
    @Bean
    public ScreenScope screenScope(){
        return new ScreenScope();
    }
    
}
