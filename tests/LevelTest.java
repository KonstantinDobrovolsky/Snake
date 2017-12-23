package com.snake.tests;

import com.snake.model.Brick;
import com.snake.model.Bridge;
import com.snake.model.Level;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LevelTest {
    private Level firstLevel, secondLevel;
    private Bridge bridge;

    @BeforeMethod
    public void TestInitialization() {
        firstLevel = new Level();
        secondLevel = new Level();
        bridge = new Bridge(firstLevel, secondLevel);
    }

    @Test
    void BridgeIndex() {
        ArrayList<Bridge> bridges = new ArrayList<>();
        bridges.add(bridge);
        firstLevel.addBridges(bridges);
        secondLevel.addBridges(bridges);

        Assert.assertEquals(firstLevel.indexInBridges(bridge), 0);
        Assert.assertEquals(secondLevel.indexInBridges(bridge), 0);
    }

    @Test
    void BricksContainment() {
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int a = 0; a < 10; a++) for (int b = 0; b < 10; b++) {
            bricks.add(new Brick(a, b));
        }

        firstLevel.addBricks(bricks);
        for (int a = 0; a < 10; a++) for (int b = 0; b < 10; b++) {
            Brick brick = new Brick(a, b);
            Assert.assertTrue(firstLevel.isInBricks(brick));
            Assert.assertFalse(secondLevel.isInBricks(brick));
        }
    }
}
