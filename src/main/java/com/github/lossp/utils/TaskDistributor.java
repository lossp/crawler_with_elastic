package com.github.lossp.utils;

import java.util.ArrayList;
import java.util.List;

public class TaskDistributor {

    public static List<List<Integer>> setNumberIntoIntervalList(int number, int threadNumber) {
        List<List<Integer>> intervalList = new ArrayList<>();
        int mod = number % threadNumber;
        int average = (number - mod) / threadNumber;
        List<List<Integer>> interval = new ArrayList<>();
        for (int i = 0; i < threadNumber; i++) {
            ArrayList<Integer> lists = new ArrayList<>();
            lists.add(i * average + 1);
            lists.add((i + 1) * average);
            interval.add(lists);
        }
        // if mode not equals to 0
        if (mod != 0) {
            ArrayList<Integer> end = new ArrayList<>();
            end.add(threadNumber * average + 1);
            end.add(threadNumber * average + mod);
            interval.add(end);
        }
        intervalList = interval;
        System.out.println(interval);
        return intervalList;
    }

    public static void main(String[] args) {
        // two kinds of situation
        // 1.[[a,b]]
        // 2.[[a,a]] which means there being only one element, which is a
        TaskDistributor.setNumberIntoIntervalList(107, 5);
        TaskDistributor.setNumberIntoIntervalList(100, 5);
        TaskDistributor.setNumberIntoIntervalList(101, 5);
    }
}
