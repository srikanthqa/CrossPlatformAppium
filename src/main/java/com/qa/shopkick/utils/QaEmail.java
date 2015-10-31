package com.qa.shopkick.utils;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.log4j.Logger;

/**
 * Created by mmadhusoodan on 10/26/15.
 */
public class QaEmail {
    private static Logger log = Logger.getLogger(QaEmail.class);

    public void sendEmail(String fromEmail, String senderName, String toEmail, String toName, String subject, String body) throws Exception {

        try {
            MultiPartEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            //465
            email.setSSL(true);
            email.setSmtpPort(465);
            email.setAuthentication("mmadhusoodan@shopkick.com", "SKrox2015!");
            email.setFrom(fromEmail, senderName);
            email.addTo(toEmail, toName);
            email.setSubject(subject);
            email.setMsg(body);
            email.send();
            log.info("Sent message successfully....sendEmailAttachment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmailAttachment(String fromEmail, String senderName, String toEmail, String toName, String subject, String body, String reportPath) throws Exception {

        try {
            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();

            attachment.setPath(reportPath);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setName("CrossPlatform Appium" + reportPath);

            // Create the email message
            MultiPartEmail email = new HtmlEmail();
            email.setHostName("smtp.corp.shopkick.com");

            email.setFrom(fromEmail, senderName);
            email.addTo(toEmail, toName);

            email.setSubject(subject);

            email.setMsg(body);
            // add the attachment
            email.attach(attachment);

            // send the email
            email.send();
            log.info("Sent message successfully....sendEmailAttachment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
