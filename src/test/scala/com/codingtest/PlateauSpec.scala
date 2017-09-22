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

  }

}
