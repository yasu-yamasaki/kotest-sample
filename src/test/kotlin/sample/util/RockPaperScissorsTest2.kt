package sample.util

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class RockPaperScissorsTest2 : FreeSpec({
    "自分がグーで" - {
        val player = RockPaperScissors.Hand.Rock
        "相手がグーなら" - {
            val result = RockPaperScissors.play(
                player = player,
                opponent = RockPaperScissors.Hand.Rock,
            )
            "相子" {
                result shouldBe RockPaperScissors.GameResult.Draw
            }
        }
        "相手がチョキなら" - {
            val result = RockPaperScissors.play(
                player = player,
                opponent = RockPaperScissors.Hand.Scissor,
            )
            "自分の勝ち" {
                result shouldBe RockPaperScissors.GameResult.Win
            }
        }
        "相手がパーなら" - {
            val result = RockPaperScissors.play(
                player = player,
                opponent = RockPaperScissors.Hand.Paper,
            )
            "自分の負け" {
                result shouldBe RockPaperScissors.GameResult.Lose
            }
        }
    }
})