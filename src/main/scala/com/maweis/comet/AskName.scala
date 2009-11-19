package com.maweis.comet


import _root_.net.liftweb.http._
import S._
import SHtml._
import _root_.net.liftweb.common._
import _root_.net.liftweb.util._
import _root_.scala.xml._

class AskName extends CometActor {
  def render =
  ajaxForm(<div>What is your username?</div> ++
           text("",name => answer(name.trim)) ++
           <input type="submit" value="Enter"/>)
}

