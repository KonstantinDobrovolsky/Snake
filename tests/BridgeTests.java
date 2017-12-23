package com.snake.tests;

import com.snake.model.Bridge;
import com.snake.model.Level;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BridgeTests {
    private Level firstLevel, secondLevel;
    private Bridge bridge;

    @BeforeMethod
    public void TestInitialization() {
        firstLevel = new Level();
        secondLevel = new Level();
        bridge = new Bridge(firstLevel, secondLevel);
    }

    @Test
    void MapTest() {
        Assert.assertEquals(bridge.Map(firstLevel), secondLevel);
        Assert.assertEquals(bridge.Map(secondLevel), firstLevel);
        Assert.assertNull(bridge.Map(new Level()));
    }
}
