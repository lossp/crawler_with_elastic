package com.github.lossp.aspect_waving;

import java.lang.reflect.Method;

public abstract class AbstractAfterHandler extends AbstractHandler {
    public abstract void handleAfter(Object proxy, Method method, Object[] args);
//    public Object invoke(Object proxy, Method method, Object[] args) {
//        Object result = method.invoke(getTarget(), args);
//    }
}
