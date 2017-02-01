package com.letgo.scala_course.domain

case class ChannelName(private val rawChannelName: String) {
  val channelName: String =
    if (rawChannelName.startsWith("#")) rawChannelName
    else s"#$rawChannelName"
}
