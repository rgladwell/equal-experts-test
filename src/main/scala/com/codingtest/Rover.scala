package com.codingtest

import scala.annotation.tailrec

case class Rover(plateauString: String, initialPosition: String) {

  private val plateau = Plateau(plateauString)
  private val position = Position(initialPosition)

  def run(directions: String): String = {
    val commands = directions.map{ Command(_) }

    recurseCommands(position, commands).toString
  }

  @tailrec
  private def recurseCommands(position: Position, commands: Seq[Command]): Position = commands.toList match {
    case Nil => position
    case command :: tail => recurseCommands(Engine.move(position, command), tail)
  }

}
