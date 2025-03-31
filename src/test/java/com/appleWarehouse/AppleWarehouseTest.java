package com.appleWarehouse;

import org.junit.Assert;
import org.junit.Test;

public class AppleWarehouseTest {

    @Test
    public void checkGreenApples() {
        AppleWarehouse appleWarehouse = new AppleWarehouse();
        int total = appleWarehouse.findGreenApples();
        Assert.assertEquals(340, total);
    }
}
