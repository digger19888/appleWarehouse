package com.appleWarehouse;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AppleWarehouseTest {
    private final AppleWarehouse appleWarehouse = new AppleWarehouse();

    @Test
    public void checkTotalWeightByColorGreen() {
        int totalGreen = appleWarehouse.findTApplesByColor("green");
        Assert.assertEquals(340, totalGreen);
    }

    @Test
    public void checkTotalWeightByColorRed() {
        int totalRed = appleWarehouse.findTApplesByColor("red");
        Assert.assertEquals(460, totalRed);
    }

    @Test
    public void shouldFindApplesHavierThan() {
        List<Apple> applesHavierThan150 = appleWarehouse.findTApplesByWeight(150);
        Assert.assertEquals(4, applesHavierThan150.size());
    }
}
