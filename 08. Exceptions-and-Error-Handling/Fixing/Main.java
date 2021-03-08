package Fixing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] weekdays = new String[5];

        weekdays[0] = "M";
        weekdays[1] = "T";
        weekdays[2] = "W";
        weekdays[3] = "Th";
        weekdays[4] = "F";

        try {
            for (int i = 0; i <= weekdays.length; i++) {
                if (i >= weekdays.length) {
                    throw new ArrayIndexOutOfBoundsException("Index is out of range");
                } else {
                    System.out.println(weekdays[i]);
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}