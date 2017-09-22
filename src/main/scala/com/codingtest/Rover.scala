package com.codingtest

import scala.annotation.tailrec
import com.codingtest.codec._

case class Rover(plateau: Plateau, initialPosition: Position) {

  def run(directions: String): String = {
    val commands = directions.map{ d: Char => decode[Command](d.toString).valid }
    val finalPosition = recurseCommands(initialPosition, commands)
    finalPosition.toString
  }

  @tailrec
  private def recurseCommands(position: Position, commands: Seq[Command]): Position = commands.toList match {
    case Nil => position
    case command :: tail => recurseCommands(Engine.move(position, command), tail)
  }

}

object Rover {

  implicit val roverDecoder: Decoder[Rover] = { input =>
    val lines = input.split("\n")

    for {
      _ <- validate(lines.size == 2, "not enough lines to parse initial state")
      plateau <- decode[Plateau](lines(0))
      position <- decode[Position](lines(1))
    } yield Rover(plateau, position)

  }

}
