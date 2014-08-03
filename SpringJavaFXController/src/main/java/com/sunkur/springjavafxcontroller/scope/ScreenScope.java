/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunkur.springjavafxcontroller.scope;

import com.sunkur.springjavafxcontroller.screen.BaseScreenController;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *
 * @author Mehmet Sunkur <mehmetsunkur@gmail.com>
 */

public class ScreenScope implements Scope {
    private static final Map<String, BaseScreenController> screens = Collections.synchronizedMap(new HashMap<String, BaseScreenController>());
    
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
     if (!screens.containsKey(name)) {
            screens.put(name, (BaseScreenController)objectFactory.getObject());
        }
        return screens.get(name);
    }

    @Override
    public Object remove(String name) {
        return screens.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // Unsupported feature
    }

    @Override
    public Object resolveContextualObject(String key) {
        // Unsupported feature
        return null;
    }

    @Override
    public String getConversationId() {
        // Unsupported feature
        return null;
    }

}
