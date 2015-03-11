package com.example;

import org.junit.Assert;
import org.junit.Test;

public class MyClassTest {
    @Test
    public void testHelloWorld() throws Exception {
        MyClass myClass = new MyClass();

        String text = myClass.getHelloWorld();

        Assert.assertEquals(text, "Hello World");
    }
}
