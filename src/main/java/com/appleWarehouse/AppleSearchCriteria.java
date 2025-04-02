package com.appleWarehouse;

@FunctionalInterface
public interface AppleSearchCriteria {
    boolean test (Apple apple);
}
