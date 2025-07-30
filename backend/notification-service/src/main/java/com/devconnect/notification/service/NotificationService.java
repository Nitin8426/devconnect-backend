package com.devconnect.notification.service;

import com.devconnect.notification.dto.NotificationDTO;
import com.devconnect.notification.model.Notification;
import com.devconnect.notification.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository repository;

    public void sendNotification(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setReceiver(dto.getReceiver());
        notification.setMessage(dto.getMessage());
        notification.setTimestamp(System.currentTimeMillis());
        repository.save(notification);
    }
}
