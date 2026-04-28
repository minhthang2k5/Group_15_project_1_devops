package com.yas.order.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ConstantsTest {

    @Test
    void testConstantsPrivateConstructors() throws Exception {
        testPrivateConstructor(Constants.class);
        testPrivateConstructor(Constants.ErrorCode.class);
        testPrivateConstructor(Constants.MessageCode.class);
        testPrivateConstructor(Constants.Column.class);
        
        assertEquals("ORDER_NOT_FOUND", Constants.ErrorCode.ORDER_NOT_FOUND);
    }
    
    private void testPrivateConstructor(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        assertTrue(java.lang.reflect.Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            // Can be ignored
        }
    }
}
