package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.app.domain.Event;
import com.example.app.mapper.EventMapper;

import lombok.RequiredArgsConstructor;
/*お客様が観る画面*/
@Controller
@RequiredArgsConstructor
public class EventController {
	
	private final EventMapper mapper;
	
		
	@GetMapping("/event")
	 public String getEvents(Model model) {
        Event event = mapper.find();
        model.addAttribute("event", event);
        return "event"; 
	}
	
}
