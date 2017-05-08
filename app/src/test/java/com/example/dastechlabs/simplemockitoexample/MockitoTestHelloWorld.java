package com.example.dastechlabs.simplemockitoexample;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by dastechlabs on 5/5/17.
 */

public class MockitoTestHelloWorld {


    /**
     * same function as initMocks
     * allows construction of all mock objects automatically
     */
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * you can create a list of all mock objects to be init using the @Mock annotation
     *
     * we can then use `initMocks(this)` to initialize all mock objects
     * (or the Mockito Rule above)
     * instead of spending one line of code per new mock object
     */
    @Mock HelloWorldMockito helloWorldMockito;

    /**
     * inject mocks takes mock objects and uses them as constructors to the listed below
     */
    @InjectMocks CompositeClass compositeClass;

    /**
     * @Before allows us to set up values/behaviors/objects needed for test
     * use this to better organize the test code
     */
    @Before
    public void createObjects() {
        // define mock behavior
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
