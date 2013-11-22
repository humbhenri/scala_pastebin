package scala_pastebin

import scala.reflect.runtime.universe._
import scala.reflect.runtime.currentMirror

/**
 * @author humberto
 * http://stackoverflow.com/questions/12797300/in-scala-how-to-turn-objects-values-into-mapstring-string
 */
object ObjectToMap {
  def apply(obj: AnyRef) = {
    val r = currentMirror.reflect(obj)
    r.symbol.typeSignature.members.toStream
      .collect { case s: TermSymbol if !s.isMethod => r.reflectField(s) }
      .map(r => r.symbol.name.toString.trim -> r.get.toString)
      .toMap
  }
}