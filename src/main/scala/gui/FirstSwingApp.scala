package com.company
package gui
import scala.swing._

object FirstSwingApp extends SimpleSwingApplication {

  override def top: Frame = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }
}
