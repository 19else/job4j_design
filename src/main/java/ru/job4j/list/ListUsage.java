package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        List<String> adAll = new ArrayList<>();
        result.add("one");
        result.add("two");
        result.add("three");
        result.add(1, "four");
        adAll.add("nine");
        adAll.add("ten");
        adAll.add("eleven");
        adAll.add("twelve");
        result.addAll(2, adAll);
        Iterator<String> iterator = result.listIterator(2);
        Iterator<String> backward = adAll.listIterator();
        System.out.println("ForEach:");
        for (String n : result) {
            System.out.println("Correct element = " + n);
        }
        System.out.println("Iterator:");
        while (iterator.hasNext()) {
            System.out.println("Correct element = " + iterator.next());
        }
        System.out.println("New Iterator:");
        adAll.set(0, "nine to zero");
        while (backward.hasNext()) {
            System.out.println("Correct El = " + backward.next());
        }
        System.out.println("LowCase to UpperCase:");
        adAll.replaceAll(String::toUpperCase);
        adAll.remove(3);

        for (String el : adAll) {
            System.out.println("Correct el = " + el);
        }
        result.removeIf(s -> s.length() <= 3);
        System.out.println("Word length >= 3:");
        result.add("nine");
        for (String el : result) {
            System.out.println("Correct el = " + el);
        }
        System.out.println("List size is " + result.size());
    }
}

