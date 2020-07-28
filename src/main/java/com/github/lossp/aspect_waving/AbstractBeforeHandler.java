package com.github.lossp.aspect_waving;

import java.lang.reflect.Method;

public abstract class AbstractBeforeHandler extends AbstractHandler {
    public abstract void handleBefore(Object proxy, Method method, Object[] args);
}
