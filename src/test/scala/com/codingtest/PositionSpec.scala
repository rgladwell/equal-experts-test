package com.codingtest

import org.scalatest._
import com.codingtest.codec._

class PositionSpec  extends WordSpec with Matchers {

  "position" should {

    val position = decode[Position]("1 2 N").valid

    "parse x position" in {
      position.x shouldBe 1
    }

    "parse y position" in {
      position.y shouldBe 2
    }

    "parse direction" in {
      position.direction shouldBe North
    }

    "toString" in {
      position.toString shouldBe "1 2 N"
    }

  }

}
