package com.codingtest

case class Plateau(plateau: String) {

  private val sizes = plateau.split(" ")

  val maxNorth: Int = sizes(0).toInt
  val maxEast: Int = sizes(1).toInt

}
