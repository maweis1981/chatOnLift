package com.maweis.snippet

import _root_.net.liftweb._
import http._
import common._
import actor._
import util._
import Helpers._
import _root_.scala.xml._
import S._
import SHtml._
import js._
import JsCmds._
import JE._
import net.liftweb.http.js.jquery.JqJsCmds._

class HelloWorld {
	def howdy = <span>Welcome to you at {new _root_.java.util.Date}</span>
 	def greeting = <span>当前时间  {new _root_.java.util.Date} </span>

	def pickSomething(xhtml: NodeSeq) : NodeSeq = {
		def processForm(): Unit = {}
		var chosenMethod: Box[ExchangeMethod.Value] = Empty
		var pickMethod: Box[ExchangeMethod.Value] = Empty
		
		val radios = 
			SHtml.radio( ExchangeMethod.elements.toList.map(_.toString),Empty,
			selected =>
			chosenMethod = Box(ExchangeMethod.valueOf(selected)) )
			
		bind("item", xhtml,
			"exchangeMethod" -> SHtml.selectObj[ExchangeMethod.Value](
			              ExchangeMethod.elements.toList.map(v => (v,v.toString)),
			              Empty,
			              selected => chosenMethod = Full(selected) ),
			"pickMethod" -> radios.toForm,
			"submit" -> SHtml.submit("确 认" , processForm))
	}
	
	
	object ExchangeMethod extends Enumeration{
		val op1 = Value("选项一")
		val op2 = Value("选项二")
		val op3 = Value("选项三")
	}
	

}