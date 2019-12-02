package com.wellfactored.propertyinfo

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class PropertyInfoGenTest extends AnyWordSpecLike with Matchers with PropertyInfoGen {

  "generator" should {
    "create an instance of PropertyInfo for a case class" in {
      case class Foo(a: String, b: Int)
      implicitly[PropertyInfo[Foo]].namesAndTypes.map(p => (p.name, p.ty.describe)) shouldBe List(("a", "String"), ("b", "Int"))
    }

    "handle options" in {
      case class Foo(a: String, b: Option[String])
      implicitly[PropertyInfo[Foo]].namesAndTypes.map(p => (p.name, p.ty.describe)) shouldBe List(("a", "String"), ("b", "Option[String]"))
    }
  }

}
