package com.zyg.puzzles.exception;

public class Car {
    private static Class engineClass = ... ;
    private Engine engine = newEngine();
    private static Engine newEngine() {
        try {
            return (Engine) engineClass.newInstance();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e) {
            throw new AssertionError(e);
        }
    }
    public Car() { }
}
