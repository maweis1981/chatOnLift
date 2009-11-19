package com.maweis.comet


import net.liftweb._
import http._
import common._
import actor._
import util._
import Helpers._
import scala.xml.{NodeSeq, Text}
import textile.TextileParser
import java.util.Date

/**
 * A chat server.  It gets messages and returns them
 */

object ChatServer extends LiftActor with ListenerManager {
  private var chats: List[ChatLine] = List(ChatLine("System", Text("Welcome"), now))

  override def lowPriority = {
    case ChatServerMsg(user, msg) if msg.length > 0 =>
      chats ::= ChatLine(user, toHtml(msg), timeNow)
      chats = chats.take(200)
      updateListeners()

    case _ =>
  }

  def createUpdate = ChatServerUpdate(chats.take(15))

  /**
   * Convert an incoming string into XHTML using Textile Markup
   *
   * @param msg the incoming string
   *
   * @return textile markup for the incoming string
   */
  def toHtml(msg: String): NodeSeq = TextileParser.paraFixer(TextileParser.toHtml(msg, Empty))

}

case class ChatLine(user: String, msg: NodeSeq, when: Date)
case class ChatServerMsg(user: String, msg: String)
case class ChatServerUpdate(msgs: List[ChatLine])