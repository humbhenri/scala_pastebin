import java.io.File
import scala.io.Source
import scala_pastebin.CommandArgsParser
import scala_pastebin.CommandLineConfig
import dispatch._, Defaults._

object repl {
 val q = url("http://api.hostip.info/country.php")//> q  : dispatch.Req = Req(<function1>)
 val res = Http(q OK as.String)                   //> SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
                                                  //| SLF4J: Defaulting to no-operation (NOP) logger implementation
                                                  //| SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further de
                                                  //| tails.
                                                  //| res  : dispatch.Future[String] = scala.concurrent.impl.Promise$DefaultPromis
                                                  //| e@1a2fefd
 res()                                            //> res0: String = BR                           
}