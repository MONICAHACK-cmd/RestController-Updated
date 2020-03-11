package com.hackathon.service.impl;

import com.google.gson.Gson;
import com.hackathon.model.SendEmailInput;
import com.hackathon.service.SendMailService;
import com.hackathon.util.RequestKeys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
@Component
public class SendEmail implements SendMailService {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Override
    public String sendEmailToUser(String contentTable, String outputfilePath) throws Exception {
        String status = RequestKeys.BLANK;
        String[] users = {"Nagamani.Banda@searshc.com", "MDM_Offshore@searshc.com", "Nitish.Michael@searshc.com"};


        System.setProperty("java.net.preferIPv4Stack", "true");

        try {
            MimeMessage mail = mailSender.createMimeMessage();
            //Configure Users from a file

            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(users);
            helper.setFrom(RequestKeys.SEND_MAIL_FROM);
            helper.setSubject(RequestKeys.SEND_MAIL_SUBJECT);
            helper.setText(RequestKeys.SEND_MAIL_CONTENT + "<br><br>" + contentTable + "<br><br>" +
                    RequestKeys.MESSAGE + "<br>" + "<b>" + outputfilePath + "</b><br><br>" + RequestKeys.LOGMESSAGE + "<br><b>" + RequestKeys.LOGPATH + "</b>", true);
            mailSender.send(mail);
            status = RequestKeys.SUCCESS;
            log.info("Message Sending Status..." + status);
            return status;
        } catch (Exception e) {
            status = RequestKeys.FAILED;
            log.error("Message Sending Status..." + status);
            StringWriter stack = new StringWriter();
            e.printStackTrace(new PrintWriter(stack));
            log.error("Caught exception : " + stack.toString());
            return status;
        }

    }


    @Override
    public String sendEmailToUser(String jsonInput) throws Exception {
        String status = RequestKeys.BLANK;

        try {
            final Gson initialGson = new Gson();
            // Constructing object SendEmailInput from json Input
            final SendEmailInput requestObj = initialGson.fromJson(jsonInput, SendEmailInput.class);
            final String[] sendTo = requestObj.getTo();
            final String sendFrom = requestObj.getFrom();
            final String subject = requestObj.getSubject();
            final String content = requestObj.getContent();
            final String[] cc = requestObj.getCc();

            System.setProperty("java.net.preferIPv4Stack", "true");

            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(sendTo);
            helper.setFrom(sendFrom);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(content + "<br><br>", true);

            mailSender.send(mail);
            status = RequestKeys.SUCCESS;
            log.info("Message Sending Status..." + status);
        } catch (Exception e) {
            status = RequestKeys.FAILED;
            log.error("Message Sending Status..." + status);
            StringWriter stack = new StringWriter();
            e.printStackTrace(new PrintWriter(stack));
            log.error("Caught exception : " + stack.toString());
        }
        return status;
    }

}