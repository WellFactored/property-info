package com.wellfactored.propertyinfo

import shapeless._

/**
  * Shapeless magic - I have to admit to not fully understanding this, but it is used to fold
  * over an HList of type at compile time to produce a List of `Typeable`s
  */
object FoldTypes {
  implicit def hnilStrings: FoldTypes[HNil] =
    new FoldTypes[HNil] {
      def apply() = List()
    }

  implicit def hconsStrings[H, T <: HList](implicit th: Typeable[H], ft: FoldTypes[T]): FoldTypes[H :: T] =
    new FoldTypes[H :: T] {
      def apply() = th :: ft()
    }
}

trait FoldTypes[L <: HList] {
  def apply(): List[Typeable[_]]
}