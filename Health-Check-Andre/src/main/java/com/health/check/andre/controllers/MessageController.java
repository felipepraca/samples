package com.health.check.andre.controllers;

import com.health.check.andre.model.Message;
import com.health.check.andre.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public List<Message> getMessage(){
        return messageService.getMessages();

    }

    @PostMapping("/message")
    public void saveMessage(@RequestBody Message message){
         messageService.setMessage(message);
    }



}
