package com.codingtest

sealed trait Command

object TurnLeft extends Command
object TurnRight extends Command
object MoveForward extends Command

object Command {

  def apply(command: Char): Command = command match {
    case 'L' => TurnLeft
    case 'R' => TurnRight
    case 'M' => MoveForward
    case _ => sys.error(s"not such command $command")
  }

}
