package com.maplr.testhockeygame.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Team entity.
 *
 * @author Nicolas Benizri
 */
@Entity
public class Team implements Serializable {

    /**
     * Technical identifier.
     */
    @Id
    private long id;

    /**
     * Team coach.
     */
    private String coach;

    /**
     * Team year.
     */
    private long year;

    /**
     * All the players in the team.
     * A team consists of several players, and a player can be linked to several teams of different years.
     */
    @ManyToMany
    @JoinTable(name = "team_player",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_number"))
    private Set<Player> players;

    /**
     * The team captain.
     */
    @OneToOne
    @JoinColumn(name="captain_number")
    private Player captain;

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

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Player getCaptain() {
        return captain;
    }

    public void setCaptain(Player captain) {
        this.captain = captain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", coach='" + coach + '\'' +
                ", year=" + year +
                ", players=" + players +
                ", captain=" + captain +
                '}';
    }
}
