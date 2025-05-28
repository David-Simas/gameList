package com.david.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.gamelist.entities.Game;

public interface GameRepository extends JpaRepository <Game, Long> {

}
