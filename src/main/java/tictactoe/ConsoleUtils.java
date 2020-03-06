package tictactoe;

import java.util.Scanner;
import java.util.regex.Pattern;

class ConsoleUtils {
    private Scanner scanner = new Scanner(System.in);

    String getPlayerName(String playerNumber) {
        System.out.println(String.format("Enter %s player name", playerNumber));
        String inputName;
        while (true) {
            inputName = scanner.nextLine();
            if (!inputName.isBlank() && inputName.length() >= 2) {
                return inputName;
            }
            System.out.println("Name too short");
        }
    }

    void playerTurns(String name) {
        System.out.println(String.format("%s's turn", name));
    }

    void enterCell() {
        System.out.println("Enter cell number from 1 to 9");
    }

    void cellAlreadyTaken() {
        System.out.println("This cell is already taken");
    }

    void printDeck(String[] cells) {
        System.out.println("+-----------+");
        System.out.println(String.format("| %s | %s | %s |", cells[0], cells[1], cells[2]));
        System.out.println("|---+---+---|");
        System.out.println(String.format("| %s | %s | %s |", cells[3], cells[4], cells[5]));
        System.out.println("|---+---+---|");
        System.out.println(String.format("| %s | %s | %s |", cells[6], cells[7], cells[8]));
        System.out.println("+-----------+");
    }

    int getSignPosition() {
        String playerChioce = scanner.nextLine();
        while (playerChioce.isBlank() || !Pattern.matches("^[1-9]$", playerChioce)) {
            System.out.println("Invalid input");
            playerChioce = scanner.nextLine();
        }
        return Integer.parseInt(playerChioce) - 1;
    }

    void announceGameResult(String result) {
        if (result.equals("Draw")) {
            System.out.println("Draw!");
        } else {
            System.out.println(String.format("%s win!", result));
        }
    }
}
