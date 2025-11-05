package com.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        List<Person> people = createPeopleList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the People Search Application!");
        System.out.println("All People in the list:");
        displayPeople(people);

        System.out.print("\nEnter a first name to search: ");
        String searchFirstName = scanner.nextLine();
        List<Person> foundByFirstName = searchByFirstName(people, searchFirstName);
        System.out.println("\nPeople with first name '" + searchFirstName + "':");
        displayPeople(foundByFirstName);

        System.out.print("\nEnter a last name to search: ");
        String searchLastName = scanner.nextLine();
        List<Person> foundByLastName = searchByLastName(people, searchLastName);
        System.out.println("\nPeople with last name '" + searchLastName + "':");
        displayPeople(foundByLastName);

        scanner.close();
    }
    private static List<Person> createPeopleList() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", "Smith", 25));
        people.add(new Person("Jane", "Doe", 30));
        people.add(new Person("Bob", "Smith", 45));
        people.add(new Person("Alice", "Johnson", 28));
        people.add(new Person("Charlie", "Brown", 35));
        people.add(new Person("Diana", "Williams", 22));
        people.add(new Person("John", "Davis", 40));
        people.add(new Person("Emily", "Smith", 33));
        people.add(new Person("Greg", "Gory", 38));
        people.add(new Person("Lucie", "Stone", 21));

        return people;
    }
    private static List<Person> searchByFirstName(List<Person> people, String firstName) {
        List<Person> results = new ArrayList<>();
        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                results.add(person);
            }
        }

        return results;
    }
    private static List<Person> searchByLastName(List<Person> people, String lastName) {
        List<Person> results = new ArrayList<>();
        for (Person person : people) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                results.add(person);
            }
        }

        return results;
    }
    private static void displayPeople(List<Person> people) {
        if (people.isEmpty()) {
            System.out.println("  No people found.");
        } else {
            for (Person person : people) {
                System.out.println("  " + person);
            }
        }
    }
}