package com.ititon.dao.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "emails")
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
//    @Getter
//    @Setter
    private Long id;

    @Column(name = "sender", nullable = false)
//    @Getter
//    @Setter
    private String senderEmail;

    @Column(name = "name")
//    @Getter
//    @Setter
    private String senderName;

    @Column(name = "message", nullable = false)
//    @Getter
//    @Setter
    private String message;

    @Column(name = "status", nullable = false)
//    @Getter
//    @Setter
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Email() {
    }

    public Email(String senderEmail, String senderName, String message, Status status) {
        this.senderEmail = senderEmail;
        this.senderName = senderName;
        this.message = message;
        this.status = status;
    }

    public Email(String senderEmail, String senderName, String message) {
        this.senderEmail = senderEmail;
        this.senderName = senderName;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", senderEmail='" + senderEmail + '\'' +
                ", senderName='" + senderName + '\'' +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
