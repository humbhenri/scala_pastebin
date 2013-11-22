package scala_pastebin

import java.io.File

case class CommandLineConfig(
  api_dev_key: String = ApiDevKey(),
  api_paste_code: String = "",
  api_paste_name: String = "",
  api_paste_format: String = "java",
  api_paste_expire_date: String = "10M",
  api_option: String = "paste")