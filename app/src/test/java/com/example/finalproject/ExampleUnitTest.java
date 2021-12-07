package com.example.finalproject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void string_isEqual(){
        String message = "hello";
        assertEquals(true, message.equals("hello") );
    }
    @Test
    public void decision_isTrue(){
        String decision = "notAte";
        assertEquals(true, decision == "notAte"); //wont work if null
    }


}