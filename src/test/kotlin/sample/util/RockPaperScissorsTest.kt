package sample.util

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class RockPaperScissorsTest : FreeSpec({
    "自分がグーで相手がチョキなら" - {
        val result = RockPaperScissors.play(
            player = RockPaperScissors.Hand.Rock,
            opponent = RockPaperScissors.Hand.Scissor,
        )
        "自分の勝ち" {
            result shouldBe RockPaperScissors.GameResult.Win
        }
    }
    "自分がチョキで相手がチョキなら" - {
        val result = RockPaperScissors.play(
            player = RockPaperScissors.Hand.Scissor,
            opponent = RockPaperScissors.Hand.Scissor,
        )
        "相子" {
            result shouldBe RockPaperScissors.GameResult.Draw
        }
    }
})