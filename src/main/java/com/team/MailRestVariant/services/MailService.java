package com.team.MailRestVariant.services;

import com.team.MailRestVariant.models.entities.Mail;
import com.team.MailRestVariant.models.entities.User;

public interface MailService {

    void sendMail(String mailTarget, Mail mail);

    public Mail prepareMail(User user);
}
