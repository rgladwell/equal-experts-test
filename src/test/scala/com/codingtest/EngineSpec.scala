package com.codingtest

import org.scalatest._

class EngineSpec extends WordSpec with Matchers {

  "engine" should {

    "turn left" in {
      Engine.move(Position(0, 0, North), TurnLeft) shouldBe Position(0, 0, West)
    }

    "turn right" in {
      Engine.move(Position(0, 0, North), TurnRight) shouldBe Position(0, 0, East)
    }

    "move forward north" in {
      Engine.move(Position(0, 0, North), MoveForward) shouldBe Position(0, 1, North)
    }

    "move forward south" in {
      Engine.move(Position(1, 1, South), MoveForward) shouldBe Position(1, 0, South)
    }

    "move forward west" in {
      Engine.move(Position(1, 1, West), MoveForward) shouldBe Position(0, 1, West)
    }

    "move forward east" in {
      Engine.move(Position(1, 1, East), MoveForward) shouldBe Position(2, 1, East)
    }

  }

}
