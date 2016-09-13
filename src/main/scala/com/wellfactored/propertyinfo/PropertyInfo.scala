package com.wellfactored.propertyinfo

import shapeless._
import shapeless.ops.hlist.ToTraversable
import shapeless.ops.record.{Keys, Values}


case class Property[T](name: String, ty: Typeable[T])

/**
  * A Type Class that abstracts information about the properties of a type. For
  * a case class these properties would be its members.
  */
trait PropertyInfo[T] {
  def namesAndTypes: List[Property[_]]
}

/**
  * A generic builder of `PropertyInfo `instances for types that are record-like enough
  * that Shapeless can generate a `LabelledGeneric` for them.
  *
  * Extend this trait or import `PropertyInfoGen._` (from the object defined below)
  * to get bring implicit generator into scope.
  *
  */
trait PropertyInfoGen {
  /**
    * This implicit function will gather all the evidence types that are needed to be
    * able to generate an instance of `PropertyInfo[T]`.
    *
    * @tparam T The type in our program that we want to work with
    * @param lgen A `LabelledGeneric` for the type `T`. Shapeless generates this for us
    * @tparam R The Shapeless representation of `T`. `lgen` can translate between `T` and `R`. Because
    *           we're using a `LabelledGeneric`, `R` will be a record type, mapping from the name of
    *           a property to it's type.
    * @tparam K An HList of the types of the keys in the `LabelledGeneric` record type
    * @param keys the collection of keys in `R`
    * @tparam V An HList of the types of the values in the `LabelledGeneric` record type
    * @param values An HList of the values in `R`
    * @param fold   An instance of a type class that lets us fold over the types in `V`
    * @param travK  Evidence that we can convert the `HList` of keys (`K`) to an ordinary `List` of scala `Symbol`s
    * @return An instance of the `PropertyInfo` type class for the type `T`
    */
  implicit def generator[T, R <: HList, K <: HList, V <: HList](implicit
                                                                lgen: LabelledGeneric.Aux[T, R],
                                                                keys: Keys.Aux[R, K],
                                                                values: Values.Aux[R, V],
                                                                fold: FoldTypes[V],
                                                                travK: ToTraversable.Aux[K, List, Symbol]): PropertyInfo[T] = {
    new PropertyInfo[T] {
      override def namesAndTypes: List[Property[_]] = {
        val names = keys().toList.map(_.name)
        val types = fold()
        names.zip(types).map { case (n, t) => Property(n, t) }
      }
    }
  }
}

/**
  * A convenience object to provide a way to import the implicit generator in cases
  * where you don't want to extend the trait.
  */
object PropertyInfoGen extends PropertyInfoGen
