package com.codingtest

import com.codingtest.codec._

sealed trait Command

object TurnLeft extends Command
object TurnRight extends Command
object MoveForward extends Command

object Command {

  implicit val commandDecoder: Decoder[Command] = { command =>
    command match {
      case "L" => Valid(TurnLeft)
      case "R" => Valid(TurnRight)
      case "M" => Valid(MoveForward)
      case _ => Invalid(s"not such command $command")
    }
  }

}
