package com.codingtest

import org.scalatest.{WordSpec}
import org.scalatest.Matchers

class RoverSpec extends WordSpec with Matchers {

  "rover" should {

    "move first rover" in {
      Rover("5 5", "1 2 N").run("LMLMLMLMM") shouldBe "1 3 N"
    }

    "move second rover" in {
      Rover("5 5", "3 3 E").run("MMRMMRMRRM") shouldBe "5 1 E"
    }

  }

}
