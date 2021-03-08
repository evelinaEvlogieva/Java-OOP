package enter_numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int start;
        int end;

        try {
            start = Integer.parseInt(scanner.nextLine());
            end = Integer.parseInt(scanner.nextLine());
            printNumbers(start, end);
        } catch (NumberFormatException ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            System.out.println();
            System.out.println("Please enter Start number and End number again:");
        }


    }

    public static void printNumbers(int start, int end) {

        if (start < 1 || end > 100) {
            throw new NumberFormatException("Numbers must be inrange [1...100]");
        } else if (start > end) {
            throw new NumberFormatException("Start must be lower than End");
        } else {
            for (int i = start; i <= end; i++) {
                System.out.println(i);

            }
        }


    }
}
