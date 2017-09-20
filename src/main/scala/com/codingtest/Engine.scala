package com.codingtest

object Engine {

  def move(position: Position, command: Command): Position = command match {
    case TurnLeft => turnLeft(position)
    case TurnRight => turnRight(position)
    case MoveForward => moveForward(position)
  }

  private def turnLeft(position: Position): Position = position.direction match {
    case North => Position(s"${position.x} ${position.y} W")
    case South => Position(s"${position.x} ${position.y} E")
    case East => Position(s"${position.x} ${position.y} N")
    case West => Position(s"${position.x} ${position.y} S")
  }

  private def turnRight(position: Position): Position =  position.direction match {
    case North => Position(s"${position.x} ${position.y} E")
    case South => Position(s"${position.x} ${position.y} W")
    case East => Position(s"${position.x} ${position.y} S")
    case West => Position(s"${position.x} ${position.y} N")
  }


  private def moveForward(position: Position): Position = position.direction match {
    case North => Position(s"${position.x} ${position.y + 1} ${Direction.toString(position.direction)}")
    case South => Position(s"${position.x} ${position.y - 1} ${Direction.toString(position.direction)}")
    case East => Position(s"${position.x + 1} ${position.y} ${Direction.toString(position.direction)}")
    case West => Position(s"${position.x - 1} ${position.y} ${Direction.toString(position.direction)}")
  }

}
