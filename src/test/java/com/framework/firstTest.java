package com.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class firstTest {
    @Test
    void firstTest(){
        System.out.println("running");
        int result = division (10,2);
        Assertions.assertEquals(5, result);
    }

    static int division (int a, int b){
        return a / b;
    }
}
