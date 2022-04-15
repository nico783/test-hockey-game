package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
