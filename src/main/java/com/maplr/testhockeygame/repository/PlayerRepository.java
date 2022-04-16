package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository linked to the {@link Player} entity.
 *
 * @author Nicolas Benizri
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
