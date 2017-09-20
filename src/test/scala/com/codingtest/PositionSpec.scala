package com.codingtest

import org.scalatest._

class PositionSpec  extends WordSpec with Matchers {

  "position" should {

    "parse x position" in {
      Position("1 2 N").x shouldBe 1
    }

    "parse y position" in {
      Position("1 2 N").y shouldBe 2
    }

    "parse direction" in {
      Position("1 2 N").direction shouldBe North
    }

    "toString" in {
      Position("1 2 N").toString shouldBe "1 2 N"
    }


  }

}
