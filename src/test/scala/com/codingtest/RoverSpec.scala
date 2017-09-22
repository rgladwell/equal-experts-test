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

  }

}
