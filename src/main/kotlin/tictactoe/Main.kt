package tictactoe

fun main(args: Array<String>) {
    println("Do you have autism? y/N")
    val isAutism = readLine().toString().toLowerCase()

    if (isAutism == "y") {
        JavaGame().startGame()
    } else {
        KtGame().startGame()
    }
}