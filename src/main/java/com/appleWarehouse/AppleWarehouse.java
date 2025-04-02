package com.appleWarehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Integer findTApplesByColor(String color) {
        return apples.stream().filter(obj -> obj.getColor().equals(color)).mapToInt(Apple::getWeight).sum();
    }

    public List<Apple> findTApplesByWeight(int weight) {
        return apples.stream().filter(obj -> obj.getWeight() > weight).collect(Collectors.toList());
    }


    public List<Apple> findApples(AppleSearchCriteria searchCriteria) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : apples) {
            if(searchCriteria.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    static class GreenAppleSearchCriteria implements AppleSearchCriteria {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    static class RedAppleSearchCriteria implements AppleSearchCriteria {
        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor());
        }
    }

    static class LightAppleSearchCriteria implements AppleSearchCriteria {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() < 150;
        }
    }

    static class HeavyAppleSearchCriteria implements AppleSearchCriteria {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }
    static class HeavyAndGreenAppleSearchCriteria implements AppleSearchCriteria {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150 && "green".equals(apple.getColor());
        }
    }
}

