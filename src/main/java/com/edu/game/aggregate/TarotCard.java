package com.edu.game.aggregate;

public class TarotCard extends Card {

    private CardName cardName;
    private Direction direction;

    public TarotCard(CardName cardName, Direction direction) {
        this.cardName = cardName;
        this.direction = direction;
    }

    @Override
    public String getMeaning() {
        return "";
    }
}
