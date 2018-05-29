package com.ititon.service_api;

import com.ititon.dao.entity.Email;

import java.util.List;

public interface EmailSenderService {
    void send(final Email email);
}
