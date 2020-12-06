/*package test.java.bgu.spl.mics;

import main.java.bgu.spl.mics.Future;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.*;


public class FutureTest {

    private Future<String> future;

    @BeforeEach
    public void setUp(){
        future = new Future<>();
    }

    @Test
    public void testGet()
    {

        assertFalse(future.isDone());
        future.resolve("the meaning of the universe");

        future.get();
        assertTrue(future.isDone());
        assertEquals(future.get(),"the meaning of the universe");

    }


    @Test
    public void testResolve(){
        String str = "someResult";
        future.resolve(str);
        assertTrue(future.isDone());
        assertTrue(str.equals(future.get()));
    }
    @Test
    public void testIsDone(){
        String str = "guy&Dan";
        assertFalse(future.isDone());
        future.resolve(str);
        assertTrue(future.isDone());
    }

    @Test
    public void testGetWithTimeOut() throws InterruptedException
    {
        assertFalse(future.isDone());
        future.get(3,TimeUnit.SECONDS);
        assertFalse(future.isDone());
        future.resolve("dan");
        assertEquals(future.get(3,TimeUnit.SECONDS),"dan");
    }
}*/
