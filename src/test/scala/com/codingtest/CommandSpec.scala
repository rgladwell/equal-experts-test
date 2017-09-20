package com.codingtest

import org.scalatest._

class CommandSpec extends WordSpec with Matchers {

  "command" should {

    "parse left" in {
      Command('L') shouldBe TurnLeft
    }

    "parse right" in {
      Command('R') shouldBe TurnRight
    }

    "parse move" in {
      Command('M') shouldBe MoveForward
    }

  }

}
