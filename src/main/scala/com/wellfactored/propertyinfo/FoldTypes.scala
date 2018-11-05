package com.wellfactored.propertyinfo

import shapeless._

/**
  * Shapeless magic - I have to admit to not fully understanding this, but it is used to fold
  * over an HList of types at compile time to produce a List of `Typeable`s
  */
object FoldTypes {
  implicit def hnilTypeables: FoldTypes[HNil] =
    new FoldTypes[HNil] {
      def apply() = List()
    }

  implicit def hconsTypeables[T, H <: HList](implicit th: Typeable[T], ft: FoldTypes[H]): FoldTypes[T :: H] =
    new FoldTypes[T :: H] {
      def apply(): List[Typeable[_]] = th :: ft()
    }
}

trait FoldTypes[H <: HList] {
  def apply(): List[Typeable[_]]
}