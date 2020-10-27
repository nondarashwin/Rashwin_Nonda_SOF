package service

import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

fun main(args: Array<String>) {
    Transport.send(plainMail("Yes"))
}

fun plainMail(note:String): MimeMessage {
    val tos = arrayListOf("rashwinnonda@gmail.com") //Multiple recipients
    val from = "rashwinnonda@outlook.com" //Sender email

    val properties = System.getProperties()

    with (properties) {
        put("mail.smtp.host", "smtp-mail.outlook.com.") //Configure smtp host
        put("mail.smtp.port", "587") //Configure port
        put("mail.smtp.starttls.enable", "true") //Enable TLS
        put("mail.smtp.auth", "true") //Enable authentication
    }

    val auth = object: Authenticator() {
        override fun getPasswordAuthentication() =
                PasswordAuthentication(from, "SHIVAJI30121997") //Credentials of the sender email
    }

    val session = Session.getDefaultInstance(properties, auth)

    val message = MimeMessage(session)

    with (message) {
        setFrom(InternetAddress(from))
        for (to in tos) {
            addRecipient(Message.RecipientType.TO, InternetAddress(to))
            subject = "stock update" //Email subject
            setContent("<html><body> $note</body></html>", "text/html; charset=utf-8") //Sending html message, you may change to send text here.
        }
    }

    return message
}
fun plainMail(note:String,mailId:String): MimeMessage {
    val tos = arrayListOf(mailId) //Multiple recipients
    val from = "rashwinnonda@outlook.com" //Sender email

    val properties = System.getProperties()

    with (properties) {
        put("mail.smtp.host", "smtp-mail.outlook.com.") //Configure smtp host
        put("mail.smtp.port", "587") //Configure port
        put("mail.smtp.starttls.enable", "true") //Enable TLS
        put("mail.smtp.auth", "true") //Enable authentication
    }

    val auth = object: Authenticator() {
        override fun getPasswordAuthentication() =
                PasswordAuthentication(from, "SHIVAJI30121997") //Credentials of the sender email
    }

    val session = Session.getDefaultInstance(properties, auth)

    val message = MimeMessage(session)

    with (message) {
        setFrom(InternetAddress(from))
        for (to in tos) {
            addRecipient(Message.RecipientType.TO, InternetAddress(to))
            subject = "Receipt" //Email subject
            setContent("<html><body> $note</body></html>", "text/html; charset=utf-8") //Sending html message, you may change to send text here.
        }
    }

    return message
}