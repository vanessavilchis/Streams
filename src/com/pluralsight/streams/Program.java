package com.pluralsight.streams;

import com.pluralsight.traditional.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.pluralsight.traditional.Program.loadPeople;

public class Program {
    private static final List<Person> people = loadPeople();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to the people search tool.\n");
        System.out.print("Type a first or last name to search: ");
        String name = scanner.nextLine().trim();

        List<Person> matches = people.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(name) ||
                        person.getLastName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        for (int i = 0; i < matches.size(); i++) {
            System.out.println("Found Person " + (i + 1) + ":");
            System.out.println(matches.get(i));
        }

        int totalAge = people.stream()
                .map(Person::getAge)
                .reduce(0, (sum, age) -> sum + age);

        int averageAge = totalAge / people.size();
        System.out.println("Average Age of all People: " + averageAge);
        int oldest = people.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(-1);

        int youngest = people.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(1000);
    }
}


