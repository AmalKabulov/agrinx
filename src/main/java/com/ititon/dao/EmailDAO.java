package com.ititon.dao;

import com.ititon.dao.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDAO extends JpaRepository<Email, Long> {
}
