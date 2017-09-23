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

    "convert back to string" in {
      position.toString shouldBe "1 2 N"
    }

    "not parse position with too few values" in {
      decode[Position]("1 2") shouldBe an[Invalid]
    }

    "not parse position with too many values" in {
      decode[Position]("1 2 N 1") shouldBe an[Invalid]
    }

    "not parse position non numeric x value" in {
      decode[Position]("X 2 N") shouldBe an[Invalid]
    }

    "not parse position non numeric y value" in {
      decode[Position]("1 Y N") shouldBe an[Invalid]
    }

    "not parse position invalid direcion" in {
      decode[Position]("1 2 3") shouldBe an[Invalid]
    }
  }

}
