package com.github.lossp.aspect_waving;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public abstract class AbstractHandler implements InvocationHandler, Serializable {
    private AbstractQueuedSynchronizer a;

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return this.target;
    }
}
