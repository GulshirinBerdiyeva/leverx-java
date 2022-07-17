package com.leverx.course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Peter"));
        people.add(new Person("Anna"));

        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person firstPerson, Person secondPerson) {
                return firstPerson.getName().compareTo(secondPerson.getName());
            }
        });

        people.forEach(person -> System.out.println(person.getName()));

        System.out.println("-----------");

        people.add(new Person("Diana"));

        people.sort(Comparator.comparing(Person::getName));

        people.forEach(person -> System.out.println(person.getName()));
    }

}
