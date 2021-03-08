package cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rankInput = scanner.nextLine();
        String suitInput = scanner.nextLine();

        CardRank rank = CardRank.valueOf(rankInput);
        CardSuit suit = CardSuit.valueOf(suitInput);


        Card card = new Card(rank, suit);

        System.out.println(card.toString());


    }
}
