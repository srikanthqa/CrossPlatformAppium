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
            email.setSSL(true);
            email.setSmtpPort(465);
            email.setAuthentication(QaProperties.getReporterEmail(), QaProperties.getReporterPassword());
            email.setFrom(fromEmail, senderName);
            email.addTo(toEmail, toName);
            email.setSubject(subject);
            email.setMsg(body);
            email.send();
            log.info("Sent message successfully....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean sendEmailAttachment(String fromEmail, String senderName, String toEmail, String toName, String subject, String body, String reportPath) throws Exception {
        try {
            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(reportPath);
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setName("CrossPlatform Appium: " + reportPath);
            log.info("Report Path : " + reportPath);
            // Create the email message and send it ...
            MultiPartEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com");
            email.setSSL(true);
            email.setSmtpPort(465);
            email.setAuthentication(QaProperties.getReporterEmail(), QaProperties.getReporterPassword());
            email.setFrom(fromEmail, senderName);
            email.addTo(toEmail, toName);
            email.setSubject(subject);
            email.setMsg(body);
            email.attach(attachment);
            email.send();
            log.info("Sent message successfully....");
            log.info("SendEmailAttachment Complete");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}