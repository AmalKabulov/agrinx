package com.ititon.service_impl;

import com.ititon.dao.EmailDAO;
import com.ititon.dao.entity.Email;
import com.ititon.dao.entity.Status;
import com.ititon.service_api.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmailSenderServiceImpl implements EmailSenderService {

    private EmailDAO emailDAO;

    private JavaMailSender mailSender;

    private MessageGenerator messageGenerator;
    @Autowired
    public EmailSenderServiceImpl(EmailDAO emailDAO, JavaMailSender mailSender, MessageGenerator messageGenerator) {
        this.emailDAO = emailDAO;
        this.mailSender = mailSender;
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void send(final Email email) {
        Objects.requireNonNull(email);
        Email saved = emailDAO.save(email);
        mailSender.send(messageGenerator.generateMessage(email));
        saved.setStatus(Status.PROCESSED);
        emailDAO.save(saved);
    }


}
