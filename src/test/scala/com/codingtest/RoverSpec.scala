package com.codingtest

import org.scalatest._
import com.codingtest.codec._

class RoverSpec extends WordSpec with Matchers {

  "rover" should {

    "move first rover" in {
      decode[Rover]("5 5\n1 2 N").valid.run("LMLMLMLMM") shouldBe "1 3 N"
    }

    "move second rover" in {
      decode[Rover]("5 5\n3 3 E").valid.run("MMRMMRMRRM") shouldBe "5 1 E"
    }

    "not parse input with too few lines" in {
      decode[Rover]("5 5") shouldBe an[Invalid]
    }

    "not parse input with too many lines" in {
      decode[Rover]("5 5\n3 3 E\n3 3 E") shouldBe an[Invalid]
    }

    "not parse invalid plateau" in {
      decode[Rover]("5 % %\n3 3 E") shouldBe an[Invalid]
    }

    "not parse invalid initial position" in {
      decode[Rover]("5 5\nX X E") shouldBe an[Invalid]
    }

  }

}
