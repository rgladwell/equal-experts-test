package com.codingtest

object Engine {

  def move(position: Position, command: Command): Position = command match {
    case TurnLeft => turnLeft(position)
    case TurnRight => turnRight(position)
    case MoveForward => moveForward(position)
  }

  private def turnLeft(position: Position): Position = position.direction match {
    case North => position.copy(direction = West)
    case South => position.copy(direction = East)
    case East => position.copy(direction = North)
    case West => position.copy(direction = South)
  }

  private def turnRight(position: Position): Position =  position.direction match {
    case North => position.copy(direction = East)
    case South => position.copy(direction = West)
    case East => position.copy(direction = South)
    case West => position.copy(direction = North)
  }

  private def moveForward(position: Position): Position = position.direction match {
    case North => position.copy(y = position.y + 1)
    case South => position.copy(y = position.y - 1)
    case East => position.copy(x = position.x + 1)
    case West => position.copy(x = position.x - 1)
  }

}
