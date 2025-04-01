package com.appleWarehouse;

import org.junit.Assert;
import org.junit.Test;

public class AppleWarehouseTest {

    @Test
    public void checkTotalWeightByColorGreen() {
        AppleWarehouse appleWarehouse = new AppleWarehouse();
        int total = appleWarehouse.findTApplesByColor("green");
        Assert.assertEquals(340, total);
    }

    @Test
    public void checkTotalWeightByColorRed() {
        AppleWarehouse appleWarehouse = new AppleWarehouse();
        int total = appleWarehouse.findTApplesByColor("red");
        Assert.assertEquals(460, total);
    }
}
