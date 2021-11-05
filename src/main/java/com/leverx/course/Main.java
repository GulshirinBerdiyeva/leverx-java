package com.leverx.course;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Anna", 1_111_111),
                new Person("Jane", 5_555_555),
                new Person("John", 7_777_777));

        people.forEach(Person::getData);


        class LocalClass {
            public void print() {
                System.out.println("Message from Local class");
            }
        }
        var local = new LocalClass();
        local.print();
    }
}
