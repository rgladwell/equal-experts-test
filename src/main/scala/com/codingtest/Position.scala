package com.codingtest

import com.codingtest.codec._
import scala.util.Try

case class Position(x: Int, y: Int, direction: Direction) {
  override def toString = s"$x $y $direction"
}

object Position {

  implicit val positionDecode: Decoder[Position] = { position =>
    val parsed = position.split(" ")

    for {
      _ <- validate(parsed.size == 3, "not enough values to parse position")

      x <- validate(Try{ parsed(0).toInt })
      y <- validate(Try{ parsed(1).toInt })

      direction <- decode[Direction](parsed(2))
    } yield Position(x, y, direction)

  }

}
