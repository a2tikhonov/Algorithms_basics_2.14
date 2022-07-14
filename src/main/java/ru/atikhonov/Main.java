package ru.atikhonov;

import ru.atikhonov.stringlist.StringList;
import ru.atikhonov.stringlist.StringListImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringList list = new StringListImpl(5);
        list.add(0, "String0");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        list.remove("String0");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        list.add(0, "String000");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        list.add(0, "String0");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        list.remove(0);
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        list.add(0, "String000");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println("list.add(\"String01\") = " + list.add("String01"));
        list.add("String02");
        list.add("String03");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.size() = " + list.size());
        System.out.println("list.indexOf(\"String02\") = " + list.indexOf("String02"));
        list.remove(3);
        list.add("String04");
        list.add(2, "String022");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        System.out.println("list.getArrSize() = " + list.getArrSize());
        list.clear();
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        list.add("String01");
        list.add("String02");
        list.add("String03");
        System.out.println("Arrays.toString(list.toArray()) = " + Arrays.toString(list.toArray()));
        StringList list2 = new StringListImpl(4);
        list2.add("String01");
        list2.add("String02");
        list2.add("String03");
        System.out.println("Arrays.toString(list2.toArray()) = " + Arrays.toString(list2.toArray()));
        System.out.println("list.equals(list2) = " + list.equals(list2));


    }
}