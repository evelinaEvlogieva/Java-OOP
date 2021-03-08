import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n  ; i++) {
            printSpaces(i, n);
            printSymbols(i);
            System.out.println();
        }

        for (int i = n - 1; i >= 1 ; i--) {
            printSpaces(i, n);
            printSymbols(i);
            System.out.println();
        }

    }

    private static void printSymbols(int i) {
        StringBuilder symbols = new StringBuilder();
        for (int j = 0; j <= i; j++) {
            symbols.append("* ");
        }

        System.out.print(symbols);
    }

    private static void printSpaces(int i, int n) {
        StringBuilder spaces = new StringBuilder();
        for (int j = 0; j < n - i; j++) {
            spaces.append(" ");
        }

        System.out.print(spaces);
    }
}
