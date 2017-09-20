package com.codingtest

case class Position(position: String) {

  private val parsed = position.split(" ")

  val x: Int = parsed(0).toInt
  val y: Int = parsed(1).toInt
  val direction: Direction = Direction(parsed(2))

  override def toString = s"$x $y ${Direction.toString(direction)}"
}
