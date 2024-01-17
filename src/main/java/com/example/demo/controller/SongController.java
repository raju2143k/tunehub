package com.example.demo.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongController {

	@Autowired
	SongService service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		// TODO: process POST request
		
		boolean songStatus = service.songExits(song.getName());
		
		if(songStatus == false)
		{
			service.addSong(song);
			System.out.println("Song added Sucssfully");
		}
		else
		{
			System.out.println("Song already exist");
		}

		
		return "adminHome";
	}
	
	
	@GetMapping("/viewSongs")
	public String viewSongs(Model model) {
		List<Song> songList = service.fetchAllSongs();
		
		model.addAttribute("songs", songList);
		return "displaySongs";
	}
	
	@GetMapping("/playSongs")
	public String playSongs(Model model) {
		
		 boolean premiumUser = false;
		 
		 if (premiumUser == true)
		 {
		List<Song> songList = service.fetchAllSongs();
		
		model.addAttribute("songs", songList);
		return "displaySongs";
		 }
		 else
		 {
			 return "makePayment";
		 }
		 
		
	}

}
