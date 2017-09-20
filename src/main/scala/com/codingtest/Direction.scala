package com.codingtest

sealed trait Direction

object North extends Direction
object South extends Direction
object East extends Direction
object West extends Direction

object Direction {

  def apply(direction: String): Direction = direction match {
    case "N" => North
    case "S" => South
    case "E" => East
    case "W" => West
    case _ => sys.error(s"no such direction $direction")
  }

  def toString(direction: Direction): String = direction match {
    case North => "N"
    case South => "S"
    case East => "E"
    case West => "W"
  }
}
