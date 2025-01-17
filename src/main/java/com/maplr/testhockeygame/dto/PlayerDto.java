package com.maplr.testhockeygame.dto;

import java.io.Serializable;

/**
 * Representation of a {@link Player} to the user.
 * In contrast to the object model, the notion of captain is included in this representation of the player.
 *
 * @author Nicolas Benizri
 */
public class PlayerDto implements Serializable {
    private long number;
    private String name;
    private String lastName;
    private String position;
    private Boolean isCaptain;

    public PlayerDto(long number, String name, String lastName, String position, Boolean isCaptain) {
        this.number = number;
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.isCaptain = isCaptain;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getIsCaptain() {
        return isCaptain;
    }

    public void setIsCaptain(Boolean captain) {
        isCaptain = captain;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", isCaptain=" + isCaptain +
                '}';
    }
}
