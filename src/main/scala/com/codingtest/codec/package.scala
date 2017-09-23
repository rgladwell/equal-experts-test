package com.codingtest

import scala.util.{Failure, Success, Try}

package object codec {

  sealed trait Validation[+A] {

    def valid: A

    def filter(p: (A) => Boolean): Validation[A] = this match {
      case Invalid(_) => this
      case Valid(value) if p(value)  => this
      case _ => Invalid(s"filtered invalid by $p")
    }

    final def map[B](f: A => B): Validation[B] = this match {
      case Invalid(e) => Invalid(e)
      case _ => Valid(f(this.valid))
    }

    final def flatMap[B](f: A => Validation[B]): Validation[B] = this match {
      case Invalid(e) => Invalid(e)
      case _ => f(this.valid)
    }

  }

  case class Invalid(error: String) extends Validation[Nothing] {

    override def valid = sys.error(s"invalid: $error")

  }

  case class Valid[A](value: A) extends Validation[A] {

    override def valid = value

  }

  type Decoder[A] = String => Validation[A]

  def decode[A](code: String)(implicit decoder: Decoder[A]): Validation[A] = decoder(code)

  def validate(p: Boolean, error: String): Validation[Any] = if(p) Valid(Unit) else Invalid(error)

  def validate[A](trying: Try[A]): Validation[A] = trying match {
    case Success(value) => Valid(value)
    case Failure(e) => Invalid(e.getMessage)
  }

}
