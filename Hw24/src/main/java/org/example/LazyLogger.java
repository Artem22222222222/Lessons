package org.example;

public class LazyLogger {
    private static LazyLogger lazyLogger;
    public static LazyLogger getInstance(){
        if (lazyLogger == null){
            lazyLogger = new LazyLogger();
            return lazyLogger;
        } else {
            return lazyLogger;
        }
    }
}

