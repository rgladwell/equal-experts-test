package com.codingtest

import org.scalatest._

class PlateauSpec extends WordSpec with Matchers {

  "plateau" should {

    "parse max north" in {
      Plateau("5 4").maxNorth shouldBe 5
    }

    "parse max east" in {
      Plateau("5 4").maxEast shouldBe 4
    }

  }

}
