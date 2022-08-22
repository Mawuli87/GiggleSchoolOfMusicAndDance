package com.messieyawo.gigglemusicpiano.fragments.constants

import java.util.regex.Matcher
import java.util.regex.Pattern


object Constants {

   private const val EMAIL_PATTERN =
      "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
   private val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
   private var matcher: Matcher? = null

   const  val REGIURL = "http://192.168.43.219/projects/phpMysql/"
  const val  LOGINURL = "http://192.168.43.219/projects/phpMysql/"

   //validate email
   fun validateEmail(email: String?): Boolean {
      matcher = email?.let { pattern.matcher(it) }
      return matcher!!.matches()
   }
   //validating password

   fun validatePassword(password: String): Boolean {
      return password.length > 5
   }



}