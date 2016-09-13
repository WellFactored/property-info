```tut
import com.wellfactored.propertyinfo._, PropertyInfoGen._

case class Foo(a:String, b:Int)

val pi = implicitly[PropertyInfo[Foo]]

pi.namesAndTypes.foreach(p=> println(p.name, p.ty.describe))

```