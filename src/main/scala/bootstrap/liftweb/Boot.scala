package bootstrap.liftweb

import _root_.net.liftweb._
import util._
import http._
import provider._
import sitemap._
import sitemap.Loc._

import Helpers._

/**
  * A class that's instantiated early and run.  It allows the application
  * to modify lift's environment
  */
class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages("com.maweis")

    // Build SiteMap
    val entries = Menu(Loc("Home", List("index"), "在线聊天")) :: 
					Menu(Loc("Test", List("components"), "控件列表" )) :: Nil


    LiftRules.setSiteMap(SiteMap(entries:_*))

// liftweb 1.0-> 1.1
    LiftRules.early.append{ _.setCharacterEncoding("UTF-8")}
	
  }
}

