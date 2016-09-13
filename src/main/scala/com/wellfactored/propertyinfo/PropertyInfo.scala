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


trait PropertyInfoGen {
  implicit def generator[T, R <: HList, K0 <: HList, K, KLub, V0 <: HList](implicit
                                                                           lgen: LabelledGeneric.Aux[T, R],
                                                                           keys: Keys.Aux[R, K0],
                                                                           values: Values.Aux[R, V0],
                                                                           fold: FoldTypes[V0],
                                                                           travK: ToTraversable.Aux[K0, List, KLub]): PropertyInfo[T] = {
    new PropertyInfo[T] {
      override def namesAndTypes: List[Property[_]] = {
        val names = keys().toList.asInstanceOf[List[Symbol]].map(_.name)
        val types = fold()
        names.zip(types).map { case (n, t) => Property(n, t) }
      }
    }
  }
}
