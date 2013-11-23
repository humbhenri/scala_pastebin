package scala_pastebin

import java.awt.Toolkit
import java.awt.datatransfer._
import dispatch._
import dispatch.Defaults._
import scala.io.Source

object Main extends App with ClipboardOwner {
  override def main(args: Array[String]) {
    val argsParser = CommandArgsParser(args)
    argsParser map { config =>
      if (!config.file.isEmpty) {
        config.api_paste_code = Source fromFile (config.file) mkString
      }
      if (!config.api_paste_code.isEmpty) {
        val request = url("http://pastebin.com/api/api_post.php").POST << ObjectToMap(config)
        val response = Http(request OK as.String)
        val responseText: String = response()
        copyToClipboard(responseText)
        println(s"Response: $responseText was copied to your clipboard :)")
      }
    }
  }

  override def lostOwnership(clipboard: Clipboard, contents: Transferable): Unit = ()

  def copyToClipboard(text: String) = {
    val clipboard = Toolkit.getDefaultToolkit.getSystemClipboard
    val stringSelection = new StringSelection(text)
    clipboard.setContents(stringSelection, this)
  }
}