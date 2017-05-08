package com.example.dastechlabs.simplemockitoexample;

/**
 * Created by dastechlabs on 5/7/17.
 */

/**
 * suppose you are testing a class which requires other objects in order to test behavior
 *
 * to decouple your tests of its dependencies from itself, we:
 *
 * 1. create an interface for its dependencies (or use dependency injection)
 * 2. create a mock object for its dependencies in our test class
 * 3. define behaviors and let it roll  B)
 *
 * For this class, its dependency is an object that implements "HelloWorldMockito",
 *
 * See MockitoTestHelloWorld (under src/test/java),
 * where we:
 * 1. create a mock object
 * 2. define what it's method calls return
 * 3. run our unit test of CompositeClass : )
 */
public class CompositeClass {
    HelloWorldMockito helloWorldMockito;

    public CompositeClass(HelloWorldMockito helloWorldMockito) {
        this.helloWorldMockito = helloWorldMockito;
    }

    public String greet() {
        return helloWorldMockito.getFirstWord() + " " + helloWorldMockito.getSecondWord();
    }
}
