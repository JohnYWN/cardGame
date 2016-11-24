package com.john.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baixiaobo on 16/11/16.
 */
public class Player {
    private int id;
    private String name;
    private List<Card> handCards = new ArrayList<Card>();

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return id == player.id || (name != null ? name.equals(player.name) : player.name == null);
        //return name != null ? name.equals(player.name) : player.name == null;

    }

}
