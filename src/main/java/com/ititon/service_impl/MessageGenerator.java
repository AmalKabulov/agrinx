package com.ititon.service_impl;

import com.ititon.dao.entity.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MessageGenerator {
    private static final String THEME = "ABOUT AGRIN-X";

    public SimpleMailMessage generateMessage(final Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getSenderEmail());
        message.setSubject(THEME);
        message.setText(createText(email.getSenderName()));
        return message;
    }


    private String createText(final String senderName) {
        StringBuilder message = new StringBuilder("Dear ");
        if (senderName == null) {
            message.append("Friend");
        } else {
            message.append(senderName);
        }

        return message.append(", thank you for showing interest in our product! \n")
                .append("At the moment the site is working in test mode. \n")
                .append("Our managers will contact you! Thank you for understanding.\n").append("\n")
                .append("Best regards, \n").append("team of AGRIN-X.").toString();

    }
}
