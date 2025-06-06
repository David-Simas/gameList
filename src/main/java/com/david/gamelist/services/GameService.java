package com.david.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.gamelist.dto.GameDTO;
import com.david.gamelist.dto.GameMinDTO;
import com.david.gamelist.entities.Game;
import com.david.gamelist.projections.GameMinProjection;
import com.david.gamelist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;		
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listID) {
		List<GameMinProjection> result = gameRepository.searchByList(listID);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;		
	}

}	