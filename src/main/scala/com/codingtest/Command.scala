package com.codingtest

import com.codingtest.codec._

sealed trait Command

object TurnLeft extends Command
object TurnRight extends Command
object MoveForward extends Command

object Command {

  implicit val commandDecoder: Decoder[Command] = {
    case "L" => Valid(TurnLeft)
    case "R" => Valid(TurnRight)
    case "M" => Valid(MoveForward)
    case command => Invalid(s"not such command $command")
  }

}
