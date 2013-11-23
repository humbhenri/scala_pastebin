package scala_pastebin

import java.io.File
import java.util.Date

object CommandArgsParser {
  def apply(args: Array[String]) = {
    val parser = new scopt.OptionParser[CommandLineConfig]("scala_pastebin") {
      head("scala_pastebin")

      opt[String]('k', "api_dev_key") action { (value, config) =>
        config.copy(api_dev_key = value)
      } text ("API Dev Key")

      opt[String]('f', "api_paste_format") action { (value, config) =>
        config.copy(api_paste_format = value)
      } text ("Programming language, e.g. 'php'")

      opt[String]('c', "api_paste_code") action { (value, config) =>
        config.copy(api_paste_code = value)
      } text ("Text to paste")

      opt[String]('n', "api_paste_name") action { (value, config) =>
        config.copy(api_paste_name = value)
      } text ("Pastebin title")

      opt[String]('e', "api_paste_expire_date") action { (value, config) =>
        config.copy(api_paste_expire_date = value)
      } text ("\nN = Never" +
        "\n10M = 10 Minutes" +
        "\n1H = 1 Hour" +
        "\n1D = 1 Day" +
        "\n1M = 1 Month ")

      opt[String]('o', "api_option") action { (value, config) =>
        config.copy(api_option = value)
      } text ("option")

      opt[String]('i', "file") action { (value, config) =>
        config.copy(file = value)
      } text ("file to upload")

      help("help") text ("prints this usage text")

      override def showUsageOnError = true

    }
    parser.parse(args, CommandLineConfig())
  }
}
