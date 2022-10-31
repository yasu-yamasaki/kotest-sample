package sample.util

object RockPaperScissors {
    fun play(player: Hand, opponent: Hand): GameResult = when ((player.base - opponent.base + 3) % 3) {
        0 -> GameResult.Draw
        1 -> GameResult.Win
        2 -> GameResult.Lose
        else -> error("not reached.")
    }

    enum class Hand(val base: Int) {
        Rock(0), Paper(1), Scissor(2)
    }

    enum class GameResult {
        Win, Lose, Draw
    }
}