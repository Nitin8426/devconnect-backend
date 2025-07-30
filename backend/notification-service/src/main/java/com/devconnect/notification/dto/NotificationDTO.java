package com.devconnect.notification.dto;

public class NotificationDTO {
    private String receiver;
    private String message;

    // Constructors
    public NotificationDTO() {
    }

    public NotificationDTO(String receiver, String message) {
        this.receiver = receiver;
        this.message = message;
    }

    // Getters
    public String getReceiver() {
        return receiver;
    }

    public String getMessage() {
        return message;
    }

    // Setters
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
