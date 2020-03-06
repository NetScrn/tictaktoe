package tictactoe;

class JavaDeck {
    private String[] cells  = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    private ConsoleUtils console;

    JavaDeck(ConsoleUtils console) {
        this.console = console;
    }

    void printDeck() {
        this.console.printDeck(this.cells);
    }

    private boolean isCellsMatches(String cell1, String cell2, String cell3) {
        boolean allCellsIsBlank = cell1.isBlank() && cell2.isBlank() && cell3.isBlank();
        return !allCellsIsBlank && (cell1.equals(cell2) && cell2.equals(cell3));
    }

    boolean isWinnerAppeared() {
        if (isCellsMatches(cells[0], cells[1], cells[2])) {
            return true;
        } else if (isCellsMatches(cells[3], cells[4], cells[5])) {
            return true;
        } else if (isCellsMatches(cells[6], cells[7], cells[8])) {
            return true;
        } else if (isCellsMatches(cells[0], cells[3], cells[6])) {
            return true;
        } else if (isCellsMatches(cells[1], cells[4], cells[7])) {
            return true;
        } else if (isCellsMatches(cells[2], cells[5], cells[8])) {
            return true;
        } else if (isCellsMatches(cells[0], cells[4], cells[8])) {
            return true;
        } else return isCellsMatches(cells[2], cells[4], cells[6]);
    }

    void putSign(String sign) {
        console.enterCell();
        int position = this.console.getSignPosition();
        while (cells[position] != " ") {
            console.cellAlreadyTaken();
            position = this.console.getSignPosition();
        }
        cells[position] = sign;
    }
}
