package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] field = new int[rows][cols];

        int value = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                field[r][c] = value++;
            }
        }

        String input = scanner.nextLine();
        
        long starsSum = 0;
        
        while (!input.equals("Let the Force be with you")) {
            int[] player = Arrays.stream(input.split(" ")).
                    mapToInt(Integer::parseInt).
                    toArray();

            int[] enemy = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int enemyRow = enemy[0];
            int enemyCol = enemy[1];

            while (enemyRow >= 0 && enemyCol >= 0) {
                if (enemyRow < field.length && enemyCol >= 0 && enemyCol < field[0].length) {
                    field[enemyRow][enemyCol] = 0;
                }
                enemyRow--;
                enemyCol--;
            }

            int playerRow = player[0];
            int playerCol = player[1];

            while (playerRow >= 0 && playerCol < field[1].length) {
                if (playerRow >= 0 && playerRow < field.length && playerCol >= 0 && playerCol < field[0].length) {
                    starsSum += field[playerRow][playerCol];
                }

                playerCol++;
                playerRow--;
            }

            input = scanner.nextLine();
        }

        System.out.println(starsSum);


    }

}
