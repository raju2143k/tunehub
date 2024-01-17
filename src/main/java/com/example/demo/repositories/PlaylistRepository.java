package com.example.demo.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
	
	

	
	

}
