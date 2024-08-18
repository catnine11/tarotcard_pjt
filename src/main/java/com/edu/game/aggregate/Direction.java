package com.edu.game.aggregate;

public enum Direction {
    UPRIGHT("정방향"),
    REVERSED("역방향");

    private final String description;

     Direction(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
         return description;
    }
}
