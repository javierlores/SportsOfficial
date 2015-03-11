package com.example.tests;

import com.example.ApplicationTestRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import example.example.com.data.MyClass;

@RunWith(ApplicationTestRunner.class)
public class MyAndroidClassTest {
    @Test
    public void testHelloWorld() throws Exception {
        MyClass myClass = new MyClass();

        String text = myClass.getHelloWorld();

        Assert.assertEquals(text, "Hello World");
    }
}
