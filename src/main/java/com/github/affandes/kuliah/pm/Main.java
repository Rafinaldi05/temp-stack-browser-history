package com.github.affandes.kuliah.pm;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
        private LinkedList<String> history;

    public Main() {
        history = new LinkedList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            System.out.println("Browser History (newest to oldest):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println(history.get(i));
            }
        }
    }

    public void browse(String url) {
        history.add(url);
        System.out.println("Visited: " + url);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("No previous websites to go back to.");
        } else {
            String lastVisited = history.removeLast();
            System.out.println("Went back from: " + lastVisited);
        }
    }

    public static void main(String[] args) {
        Main browser = new Main();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Browse website");
            System.out.println("2. View history");
            System.out.println("3. Back");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter website URL: ");
                    String url = sc.nextLine();
                    browser.browse(url);
                    break;
                case 2:
                    browser.view();
                    break;
                case 3:
                    browser.back();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}



   
