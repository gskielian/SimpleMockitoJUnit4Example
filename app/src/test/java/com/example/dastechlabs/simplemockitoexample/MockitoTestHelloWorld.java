package com.example.dastechlabs.simplemockitoexample;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by dastechlabs on 5/5/17.
 */

public class MockitoTestHelloWorld {

    // our non mock objects (note the critical newline between this and above)
    CompositeClass compositeClass;

    /**
     * you can create a list of all mock objects to be init using the @Mock annotaton
     *
     * we can then use `initMocks(this)` to initialize all mock objects
     * instead of spending one line of code per new mock object
     */
    @Mock
    HelloWorldMockito helloWorldMockito;


    /**
     * @Before allows us to set up values/behaviors/objects needed for test
     * use this to better organize the test code
     */
    @Before
    public void createObjects() {
        // init mocks and define mock behavior
        initMocks(this); // initializes all mock objects from @Mock
        when(helloWorldMockito.getFirstWord()).thenReturn("Hello");
        when(helloWorldMockito.getSecondWord()).thenReturn("World");

        // construct object which uses above mock object
        compositeClass = new CompositeClass(helloWorldMockito);
    }

    /**
     * @Test allows us to define tests
     */
    @Test
    public void testGreeting() {
        System.out.println(compositeClass.greet());
        assertEquals(compositeClass.greet(), "Hello World");
    }
}
