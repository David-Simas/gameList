package com.david.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.david.gamelist.entities.GameList;

public interface GameListRepository extends JpaRepository <GameList, Long> {

}