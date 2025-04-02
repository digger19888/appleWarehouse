package com.appleWarehouse;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AppleWarehouseTest {
    private final AppleWarehouse appleWarehouse = new AppleWarehouse();
    private final AppleWarehouse.GreenAppleSearchCriteria criteria = new AppleWarehouse.GreenAppleSearchCriteria();
    private final AppleWarehouse.RedAppleSearchCriteria criteriaRed = new AppleWarehouse.RedAppleSearchCriteria();
    private AppleWarehouse.LightAppleSearchCriteria criteriaLight = new AppleWarehouse.LightAppleSearchCriteria();
    private AppleWarehouse.HeavyAppleSearchCriteria criteriaHeavy = new AppleWarehouse.HeavyAppleSearchCriteria();

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

    @Test
    public void shouldSucceedGreen() {
        Apple apple = new Apple("green", 200);
        Assert.assertTrue(criteria.test(apple));
    }

    @Test
    public void shouldFailGreen() {
        Apple apple = new Apple("red", 200);
        Assert.assertFalse(criteria.test(apple));
    }

    @Test
    public void shouldSucceedRed() {
        Apple apple = new Apple("red", 200);
        Assert.assertTrue(criteriaRed.test(apple));
    }

    @Test
    public void shouldFailRed() {
        Apple apple = new Apple("green", 200);
        Assert.assertFalse(criteriaRed.test(apple));
    }

    @Test
    public void shouldSucceedLight() {
        Apple apple = new Apple("red", 100);
        Assert.assertTrue(criteriaLight.test(apple));
    }

    @Test
    public void shouldFailLight() {
        Apple apple = new Apple("red", 200);
        Assert.assertFalse(criteriaLight.test(apple));
    }

    @Test
    public void shouldSucceedHeavy() {
        Apple apple = new Apple("red", 200);
        Assert.assertTrue(criteriaHeavy.test(apple));
    }

    @Test
    public void shouldFail() {
        Apple apple = new Apple("red", 100);
        Assert.assertFalse(criteriaHeavy.test(apple));
    }

    @Test
    public void shouldFindApplesUsingSearchCriteria() {
        List<Apple> greenApples = appleWarehouse.findApples(new AppleWarehouse.GreenAppleSearchCriteria());
        Assert.assertEquals(3, greenApples.size());
        List<Apple> redApples = appleWarehouse.findApples(new AppleWarehouse.RedAppleSearchCriteria());
        Assert.assertEquals(3, redApples.size());
        List<Apple> heavyApples = appleWarehouse.findApples(new AppleWarehouse.HeavyAppleSearchCriteria());
        Assert.assertEquals(4, heavyApples.size());
        List<Apple> lightApples = appleWarehouse.findApples(new AppleWarehouse.LightAppleSearchCriteria());
        Assert.assertEquals(4, lightApples.size());
        List<Apple> heavyAndGreenApples = appleWarehouse.findApples(new AppleWarehouse.HeavyAndGreenAppleSearchCriteria());
        Assert.assertEquals(1, heavyAndGreenApples.size());


    }
}
