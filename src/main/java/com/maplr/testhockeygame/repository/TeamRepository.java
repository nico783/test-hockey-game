package com.maplr.testhockeygame.repository;

import com.maplr.testhockeygame.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * JPA Repository linked to the {@link Team} entity.
 *
 * @author Nicolas Benizri
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
    /**
     * This method retrieves a {@link Team} according to its year.
     * Unlike the simple findTeamByYear method, this method also retrieves all its players.
     * The advantage is to avoid multiple database queries due to lazy loading when all the players in the team have to be retrieved.
     *
     * @param year which allows for the identification of a team.
     * @return the team and all its members in a single query.
     */
    @Query("FROM Team t JOIN FETCH t.players WHERE t.year = (:year)")
    Optional<Team> findTeamByYearAndFetchPlayers(@Param("year") long year);
}
