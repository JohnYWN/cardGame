package com.john.game;

/**
 * Created by baixiaobo on 16/11/16.
 */
public class Card {
    private String color;
    private String point;

    public Card(String color, String point) {
        this.color = color;
        this.point = point;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!color.equals(card.color)) return false;
        return point.equals(card.point);

    }

}
