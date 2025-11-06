package com.pluralsight.traditional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {
    private static final List<Person> people = loadPeople(); //source
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to the people search tool.\n");
        System.out.print("Type a first or last name to search: ");
        String name = scanner.nextLine().trim();

        List<Person> matches = new ArrayList<>();

        //Transformation 1
        for (Person person: people) {
            if (person.getFirstName().equalsIgnoreCase(name) || person.getLastName().equalsIgnoreCase(name)) {
                matches.add(person);
            }
        }
        // Transformation 2
        for (int i = 0; i < matches.size(); i++) {
            System.out.println("Found Person " + (i + 1) + ":");
            System.out.println(matches.get(i));
        }


        int avgAge = 0;
        int oldest = -1;
        int youngest = 1000;

        for (Person person: people) {
            avgAge += person.getAge(); //transformation 1

            if (person.getAge() > oldest) {
                oldest = person.getAge();
            }

            if (person.getAge() < youngest) {
                youngest = person.getAge();
            }
        }

        //Transformation 2
        System.out.println("Average Age of all People: " + avgAge / people.size());

        System.out.println("Oldest Age of all People: " + oldest);
        System.out.println("Youngest Age of all People: " + youngest);

        scanner.close();
    }

    public static List<Person> loadPeople() {
        return new ArrayList<>(Arrays.asList(
                new Person("Peter", "Parker", 28),
                new Person("Tony", "Stark", 45),
                new Person("Steve", "Rogers", 105),
                new Person("Natasha", "Romanoff", 35),
                new Person("Bruce", "Banner", 42),
                new Person("Thor", "Odinson", 1500),
                new Person("Wanda", "Maximoff", 29),
                new Person("Stephen", "Strange", 44),
                new Person("Carol", "Danvers", 38),
                new Person("Scott", "Lang", 40),
                new Person("Clark", "Kent", 35),
                new Person("Bruce", "Wayne", 38),
                new Person("Diana", "Prince", 3000),
                new Person("Barry", "Allen", 30),
                new Person("Arthur", "Curry", 37),
                new Person("Hal", "Jordan", 34),
                new Person("Oliver", "Queen", 36),
                new Person("Selina", "Kyle", 32),
                new Person("Victor", "Stone", 25),
                new Person("Kara", "Danvers", 24)
        ));
    }
}
