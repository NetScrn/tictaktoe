package tictactoe

// +-----------+
// |   |   |   |
// |---+---+---|
// |   |   |   |
// |---+---+---|
// |   |   |   |
// +-----------+
fun printDeck(cells: Array<String>) {
    println("+-----------+")
    println("| ${cells[0]} | ${cells[1]} | ${cells[2]} |")
    println("|---+---+---|")
    println("| ${cells[3]} | ${cells[4]} | ${cells[5]} |")
    println("|---+---+---|")
    println("| ${cells[6]} | ${cells[7]} | ${cells[8]} |")
    println("+-----------+")

}

fun getPlayerName(playerNumber: String): String {
    println("Enter $playerNumber player name")
    while (true) {
        val playerName = readLine()
        if (!playerName.isNullOrBlank() && playerName.length >= 2) {
            return playerName
        }
        println("Name too short")
    }
}

fun getPlayerChoice(): Int {
    var playerChoice = readLine().toString()
    while (playerChoice.isBlank() || !Regex("^[1-9]$").matches(playerChoice)) {
        println("Invalid input")
        playerChoice = readLine().toString()
    }
    return playerChoice.toInt() - 1
}

fun announceGameResult(result: String) = if (result == "Draw") println("Draw!") else println("$result win!")