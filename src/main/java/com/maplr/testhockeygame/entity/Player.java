package com.maplr.testhockeygame.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Player entity.
 *
 * @author Nicolas Benizri
 */
@Entity
public class Player implements Serializable {

    /**
     * Player's number.
     */
    @Id
    private long number;

    /**
     * Player's first name.
     */
    private String name;

    /**
     * Player's name.
     */
    private String lastname;

    /**
     * Player's position.
     */
    private String position;

    public Player() {
        // Default constructor used by Spring Data.
    }

    public Player(long number, String name, String lastname, String position) {
        this.number = number;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return number == player.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Player{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
