package tictactoe;

public class JavaGame {
    private static String signX = "X";
    private static String signO = "O";
    private ConsoleUtils console = new ConsoleUtils();

    private JavaPlayer firstPlayer = new JavaPlayer(console.getPlayerName("first"), signX);
    private JavaPlayer secondPlayer = new JavaPlayer(console.getPlayerName("second"), signO);
    private JavaDeck deck = new JavaDeck(console);

    private JavaPlayer currentTurnPlayer;
    private int step = 1;
    private boolean gameEnded = false;

    public void startGame() {
        while(!gameEnded) {
            gameTurn();
            step++;
        }
    }

    private void gameTurn() {
        currentTurnPlayer = step % 2 == 0 ? secondPlayer : firstPlayer;
        console.playerTurns(currentTurnPlayer.name);
        deck.printDeck();
        deck.putSign(currentTurnPlayer.sign);
        if (deck.isWinnerAppeared()) {
            gameEnded = true;
            deck.printDeck();
            console.announceGameResult(currentTurnPlayer.name);
        } else if (step == 9) {
            gameEnded = true;
            deck.printDeck();
            console.announceGameResult("Draw");
        }
    }
}
