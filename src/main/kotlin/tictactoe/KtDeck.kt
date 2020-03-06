package tictactoe

class KtDeck {
    private val cells: Array<String> = arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", " ")

    fun putSign(sign: String) {
        println("Enter cell number from 1 to 9")
        var position = getPlayerChoice()
        while (cells[position] != " ") {
            println("This cell is already taken")
            position = getPlayerChoice()
        }
        cells[position] = sign
    }

    private fun isCellsMatches(cells: Array<String>): Boolean {
        val allCellsIsBlank = cells.all { it.isBlank() }
        return !allCellsIsBlank && (cells[0] == cells[1] && cells[1] == cells[2])
    }

    fun isWinnerAppeared(): Boolean {
        return when {
            isCellsMatches(arrayOf(cells[0], cells[1], cells[2])) -> true
            isCellsMatches(arrayOf(cells[3], cells[4], cells[5])) -> true
            isCellsMatches(arrayOf(cells[6], cells[7], cells[8])) -> true
            isCellsMatches(arrayOf(cells[0], cells[3], cells[6])) -> true
            isCellsMatches(arrayOf(cells[1], cells[4], cells[7])) -> true
            isCellsMatches(arrayOf(cells[2], cells[5], cells[8])) -> true
            isCellsMatches(arrayOf(cells[0], cells[4], cells[8])) -> true
            isCellsMatches(arrayOf(cells[2], cells[4], cells[6])) -> true
            else -> false
        }
    }

    fun printDeck() {
       printDeck(cells)
    }
}