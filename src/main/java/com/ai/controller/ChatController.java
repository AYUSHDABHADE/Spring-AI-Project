package com.ai.controller;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.entity.Tut;
import com.ai.service.ChatService;

@RestController
public class ChatController {

	private ChatService chatService;
//	private ChatClient client;

//	public ChatController(ChatClient.Builder builder) {
//		  this.client=builder.build();
//	}
	public ChatController(ChatService service) {
		this.chatService = service;
	}

	@GetMapping("/chat")
	public ResponseEntity<String> chat(@RequestParam(value = "q", required = true) String q) {
		System.err.println("Call is comeing in rest api");

		var responce = chatService.chat(q);
		return ResponseEntity.ok(responce);
	}
}
