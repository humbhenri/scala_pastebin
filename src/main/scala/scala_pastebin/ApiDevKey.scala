package scala_pastebin

import scala.io.Source
import java.io.File

object ApiDevKey {
  val file = "pastebin_api_key"
  val homeDir = System.getProperty("user.home")
  def apply() = Source.fromFile(new File(homeDir, file)).mkString
}