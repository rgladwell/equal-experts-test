package com.codingtest

import org.scalatest._
import com.codingtest.codec._

class CommandSpec extends WordSpec with Matchers {

  "command" should {

    "parse left" in {
      decode[Command]("L") shouldBe Valid(TurnLeft)
    }

    "parse right" in {
      decode[Command]("R") shouldBe Valid(TurnRight)
    }

    "parse move" in {
      decode[Command]("M") shouldBe Valid(MoveForward)
    }

    "not parse invalid command" in {
      decode[Command]("X") shouldBe an[Invalid]
    }

  }

}
