package com.devconnect.notification.model;

import jakarta.persistence.*;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String receiver;
    private String message;
    private Long timestamp;

    // Constructors
    public Notification() {
    }

    public Notification(String receiver, String message, Long timestamp) {
        this.receiver = receiver;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
