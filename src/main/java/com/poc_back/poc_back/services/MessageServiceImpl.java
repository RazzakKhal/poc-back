package com.poc_back.poc_back.services;

import com.poc_back.poc_back.models.Message;
import com.poc_back.poc_back.models.User;
import com.poc_back.poc_back.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message saveMessage(Message message) {
        // Logique supplémentaire avant d'enregistrer le message, si nécessaire
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessagesByUser(User user) {
        // On pourrait ajouter de la logique métier pour filtrer les messages si besoin
        return messageRepository.findBySenderOrReceiver(user, user);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
