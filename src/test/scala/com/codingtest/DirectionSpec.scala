package com.codingtest

import org.scalatest._

class DirectionSpec extends WordSpec with Matchers {

  "direction" should {

    "parse north" in {
      Direction("N") shouldBe North
    }

    "parse east" in {
      Direction("E") shouldBe East
    }

    "parse south" in {
      Direction("S") shouldBe South
    }

    "parse west" in {
      Direction("W") shouldBe West
    }

    "toString" in {
      Direction.toString(West).toString shouldBe "W"
    }

  }

}
