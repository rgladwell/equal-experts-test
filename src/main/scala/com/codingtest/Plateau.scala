package com.codingtest

import com.codingtest.codec._
import scala.util.Try

case class Plateau(maxNorth: Int, maxEast: Int)

object Plateau {

  implicit val plateauDecoder: Decoder[Plateau] = { plateau =>
    val sizes = plateau.split(" ")

    for {
      _ <- validate(sizes.size == 2, "not enough values to parse plateau")

      maxNorth <- validate(Try{ sizes(0).toInt } )
      maxEast <- validate(Try{ sizes(1).toInt } )

    } yield Plateau(maxNorth, maxEast)

  }

}
