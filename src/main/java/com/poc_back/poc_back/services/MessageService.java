package com.poc_back.poc_back.services;

import com.poc_back.poc_back.models.Message;
import com.poc_back.poc_back.models.User;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message); // Enregistrer un nouveau message
    List<Message> getMessagesByUser(User user); // Récupérer les messages d'un utilisateur
    List<Message> getAllMessages(); // Récupérer tous les messages
}
