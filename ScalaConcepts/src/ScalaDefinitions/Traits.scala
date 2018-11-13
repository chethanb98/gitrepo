package ScalaDefinitions


trait Equal{
  def isEqual(x:Any): Boolean
  def isNotEqual(x:Any): Boolean = !isEqual(x)
}

//a class can have multiple tratis, unless class trait cannot be instantiated
class Traits(xc:Int, yc:Int) extends Equal {
  var x:Int = xc
  var y:Int = yc
  
  def isEqual(obj:Any) = {obj.isInstanceOf[Traits]  && x == y}
}

object Demo extends App{
    val p1 = new Traits(2,3)
    val p2 = new Traits(3,3)
    
    println(p1.isEqual(p1))
    println(p1.isNotEqual(p1))
    println(p2.isNotEqual(p2))
}

