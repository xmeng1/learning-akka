package com.akkademy

import akka.actor.Actor
import akka.event.Logging

class ParsingActor extends Actor{
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case ParseHtmlArticle(key, html) =>
      log.info("ParsingActor key {} and html {} ", key, html.substring(1,100))
      sender() ! ArticleBody(key, de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(html))
    case x =>
      println("unknown message " + x.getClass)
  }
}
