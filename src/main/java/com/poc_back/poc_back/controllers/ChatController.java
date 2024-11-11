package com.poc_back.poc_back.controllers;

import com.poc_back.poc_back.models.Message;
import com.poc_back.poc_back.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final MessageService messageService;

    @Autowired
    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(Message message) {
        // Enregistrer le message en base de données avant de le diffuser
        return messageService.saveMessage(message);
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(Message message) {
        // La logique d'ajout de l'utilisateur pourrait aussi impliquer un enregistrement en base
        return message;
    }
}

