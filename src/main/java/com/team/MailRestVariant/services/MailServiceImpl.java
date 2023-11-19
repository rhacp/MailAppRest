package com.team.MailRestVariant.services;

import com.team.MailRestVariant.models.entities.Mail;
import com.team.MailRestVariant.models.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderAddress;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String mailTarget, Mail mail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(senderAddress);
        simpleMailMessage.setSubject(mail.getSubject());
        simpleMailMessage.setText(mail.getMessage());
        simpleMailMessage.setTo(mailTarget);

        javaMailSender.send(simpleMailMessage);
    }

    @Override
    public Mail prepareMail(User user) {
        Mail mail = new Mail();
        mail.setSubject("Welcome " + user.getFirstName() + "!");
        mail.setMessage("You can check your account at: http://localhost:8080/api/users/" + user.getId());

        return mail;
    }
}
