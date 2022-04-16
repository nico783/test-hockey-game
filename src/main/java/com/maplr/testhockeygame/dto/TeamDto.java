package com.maplr.testhockeygame.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Representation of a {@link Team} to the user.
 *
 * @author Nicolas Benizri
 */
public class TeamDto implements Serializable {
    private long id;
    private String coach;
    private long year;
    private List<PlayerDto> players;

    public TeamDto(long id, String coach, long year, List<PlayerDto> players) {
        this.id = id;
        this.coach = coach;
        this.year = year;
        this.players = players;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public List<PlayerDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDto> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "id=" + id +
                ", coach='" + coach + '\'' +
                ", year=" + year +
                ", players=" + players +
                '}';
    }
}
