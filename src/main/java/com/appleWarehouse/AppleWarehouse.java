package com.appleWarehouse;

import java.util.ArrayList;
import java.util.List;

public class AppleWarehouse {
    private List<Apple> apples = getAllApples();

    private List<Apple> getAllApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red", 100));
        apples.add(new Apple("red", 160));
        apples.add(new Apple("red", 200));
        apples.add(new Apple("green", 200));
        apples.add(new Apple("green", 90));
        apples.add(new Apple("green", 50));
        apples.add(new Apple("yellow", 50));
        apples.add(new Apple("yellow", 170));
        return apples;
    }

    public Integer findGreenApples() {
        return apples.stream().filter(obj -> obj.getColor().equals("green")).mapToInt(Apple::getWeight).sum();
    }
}

