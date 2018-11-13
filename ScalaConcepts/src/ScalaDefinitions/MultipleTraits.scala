package ScalaDefinitions

import scala.collection.mutable.ListBuffer
import scala.reflect.io.Streamable.Bytes
import scala.reflect.io.Streamable.Bytes

// traits does not have constructors, this is how scala solves diamond problems
trait Base{
  def func: String
}

trait print1 extends Base{
  override def func = "print1"
}
trait print2 extends Base{
  override def func = "print2"
}

class extendtratitsA extends print1 with print2{  
  override def func = "StrinA "+super.func
}

class extendtratitsB extends print2 with print1{
  override def func = "string B "+super.func
}

object MultipleTraits extends App with print1 with print2{
   
  println("calling traits")
  
  println("extends print 1 with print 2 "+(new extendtratitsA).func)
  println("extends print 2 with print 1 "+(new extendtratitsB).func)
}