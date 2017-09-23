package com.codingtest

import org.scalatest._
import com.codingtest.codec._

class PlateauSpec extends WordSpec with Matchers {

  "plateau" should {

    val plateau = decode[Plateau]("5 4").valid

    "parse max north" in {
      plateau.maxNorth shouldBe 5
    }

    "parse max east" in {
      plateau.maxEast shouldBe 4
    }

    "not parse plateau with too few parameters" in {
      decode[Plateau]("5") shouldBe an[Invalid]
    }

    "not parse plateau with too many parameters" in {
      decode[Plateau]("5 4 1") shouldBe an[Invalid]
    }

    "not parse plateau with non numeric north value" in {
      decode[Plateau]("X 5") shouldBe an[Invalid]
    }

    "not parse plateau with non numeric east value" in {
      decode[Plateau]("5 X") shouldBe an[Invalid]
    }

  }

}
