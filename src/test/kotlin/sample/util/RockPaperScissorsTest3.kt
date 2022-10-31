package sample.util

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class RockPaperScissorsTest3 : FreeSpec({
    listOf(
        Triple(
            RockPaperScissors.Hand.Rock,
            RockPaperScissors.Hand.Rock,
            RockPaperScissors.GameResult.Draw,
        ),
        Triple(
            RockPaperScissors.Hand.Rock,
            RockPaperScissors.Hand.Scissor,
            RockPaperScissors.GameResult.Win,
        ),
        Triple(
            RockPaperScissors.Hand.Rock,
            RockPaperScissors.Hand.Paper,
            RockPaperScissors.GameResult.Lose,
        ),
    ).forEach { input ->
        "自分が${input.first}で相手が${input.second}なら" - {
            val result = RockPaperScissors.play(
                player = input.first,
                opponent = input.second,
            )
            "自分の${input.third}" {
                result shouldBe input.third
            }
        }
    }
})