package tictactoe

class KtGame {
    companion object {
        const val signX = "X"
        const val signO = "O"
    }

    private val firstPlayer = KtPlayer(getPlayerName("first"), signX)
    private val secondPlayer = KtPlayer(getPlayerName("second"), signO)
    private val deck: KtDeck = KtDeck()

    private lateinit var currentTurnPlayer: KtPlayer
    private var step = 1
    private var gameEnded = false

    fun startGame() {
        while (!gameEnded) {
            gameTurn()
            step++
        }
    }

    private fun gameTurn() {
        currentTurnPlayer = if (step % 2 == 0) secondPlayer else firstPlayer
        println("${currentTurnPlayer.name}'s turn")
        deck.printDeck()
        deck.putSign(currentTurnPlayer.sign)
        if (deck.isWinnerAppeared()) {
            gameEnded = true
            deck.printDeck()
            announceGameResult(currentTurnPlayer.name)
        } else if (step == 9) {
            gameEnded = true
            deck.printDeck()
            announceGameResult("Draw")
        }
    }
}