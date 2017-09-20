package com.codingtest

import org.scalatest._

class EngineSpec extends WordSpec with Matchers {

  "engine" should {

    "turn left" in {
      Engine.move(Position("0 0 N"), TurnLeft) shouldBe Position("0 0 W")
    }

    "turn right" in {
      Engine.move(Position("0 0 N"), TurnRight) shouldBe Position("0 0 E")
    }

    "move forward north" in {
      Engine.move(Position("0 0 N"), MoveForward) shouldBe Position("0 1 N")
    }

    "move forward south" in {
      Engine.move(Position("1 1 S"), MoveForward) shouldBe Position("1 0 S")
    }

    "move forward west" in {
      Engine.move(Position("1 1 W"), MoveForward) shouldBe Position("0 1 W")
    }

    "move forward east" in {
      Engine.move(Position("1 1 E"), MoveForward) shouldBe Position("2 1 E")
    }

  }

}
