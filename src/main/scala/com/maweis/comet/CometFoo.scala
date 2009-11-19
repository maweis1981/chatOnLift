package com.maweis.comet

import _root_.net.liftweb.http._
import _root_.net.liftweb.common._
import _root_.net.liftweb.util._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import _root_.scala.xml._

class CometFoo extends CometActor{
	override val defaultPrefix = Full("a")
	var message = "hello!"
	
	def render = bind("b" -> <span>{message} </span>)
	
	override def localSetup = {
		
	}
	
	override def localShutdown = {
		
	}
	
	override def lowPriority : PartialFunction[Any, Unit] = {
		case UpdateMessage(msg) => message = msg; reRender(false)
	}
}

case class UpdateMessage(msg: String)