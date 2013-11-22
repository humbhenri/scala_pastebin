package scala_pastebin

import scala.io.Source
import dispatch._
import Defaults._
import java.net.URLEncoder
import java.awt.Toolkit
import java.awt.datatransfer._

object Main extends App with ClipboardOwner {
  override def main(args: Array[String]) {
    val argsParser = CommandArgsParser(args)
    argsParser map { config =>
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