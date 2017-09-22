package com.codingtest

import com.codingtest.codec._

sealed trait Direction {
  val code: String
  override def toString = code
}

object North extends Direction {
  override val code = "N"
}

object South extends Direction {
  override val code = "S"
}

object East extends Direction {
  override val code = "E"
}

object West extends Direction {
  override val code = "W"
}

object Direction {

  implicit val directionDecoder: Decoder[Direction] = {
    case "N" => Valid(North)
    case "S" => Valid(South)
    case "E" => Valid(East)
    case "W" => Valid(West)
    case direction => Invalid(s"no such direction $direction")
  }

}
