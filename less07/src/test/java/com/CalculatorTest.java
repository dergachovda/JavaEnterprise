package com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class CalculatorTest {

    @BeforeClass
    public static void init() {
        System.out.println("before class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void spy_test() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> spy = spy(list);
        doReturn(-7).when(spy).get(0);
        Integer firstInteger = spy.get(0);
        Assert.assertTrue(firstInteger == -7);
    }

    @Test
    public void sum_check() {
        Calculator calculator = mock(Calculator.class);
        when(calculator.getNumber1()).thenReturn(12);
        when(calculator.getNumber2()).thenReturn(18);
        when(calculator.add()).thenReturn(30);

        Assert.assertEquals(calculator.getNumber1(), 12);
        Assert.assertEquals(calculator.getNumber2(), 18);

        int sum = calculator.add();
        Assert.assertEquals(sum, 30);
//        verify(calculator, times(1)).add();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @After
    public void after() {
        System.out.println("after");
    }

}
