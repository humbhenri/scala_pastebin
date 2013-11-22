package scala_pastebin

class ObjectToMapTest extends UnitSpec {

  it should "convert an object to a map from field name to a field value" in {
    case class Test(field1: Int, field2: String)
    val test = Test(1, "abacaxi")
    val map = ObjectToMap(test)
    map("field1") should be("1")
    map("field2") should be("abacaxi")
  }
}