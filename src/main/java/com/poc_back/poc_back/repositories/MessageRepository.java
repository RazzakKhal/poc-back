package com.poc_back.poc_back.repositories;

import com.poc_back.poc_back.models.Message;
import com.poc_back.poc_back.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderOrReceiver(User sender, User receiver);

}
