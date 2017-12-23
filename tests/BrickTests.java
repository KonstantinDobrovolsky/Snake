package com.snake.tests;

import com.snake.model.Brick;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrickTests {
    @BeforeMethod
    public void TestsInitialization() {

    }

    @Test
    void Initialization() {
        Brick brick = new Brick(32, 5-9);
        Assert.assertEquals(brick.getX(), 32);
        Assert.assertEquals(brick.getY(), -4);
    }
}
