package com.codingtest

import org.scalatest._
import com.codingtest.codec._

class DirectionSpec extends WordSpec with Matchers {

  "direction" should {

    "parse north" in {
      decode[Direction]("N") shouldBe Valid(North)
    }

    "parse east" in {
      decode[Direction]("E") shouldBe Valid(East)
    }

    "parse south" in {
      decode[Direction]("S") shouldBe Valid(South)
    }

    "parse west" in {
      decode[Direction]("W") shouldBe Valid(West)
    }

    "not parse invalid direction" in {
      decode[Direction]("X") shouldBe an[Invalid]
    }

  }

}
