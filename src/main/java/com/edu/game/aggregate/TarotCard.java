package com.edu.game.aggregate;

import java.util.Map;

public class TarotCard extends Card {

    private CardName name;
//    private Direction direction;  // 방향을 고정하지 않고 동적으로 생성하기 위해 지워줌
    //하위 클래스에서 상속받을 수 없기때문에 불변성 유지 가능
    //방향에 따른 키워드의 의미
    private final Map<Direction, Map<String, String>> meanings;

    public TarotCard(CardName name, Map<Direction, Map<String, String>> meanings) {
        this.name = name;
        this.meanings = meanings;
    }

    public CardName getName() {
        return name;
    }

//    }

    @Override
    public String getMeaning(Direction direction, String keyword) {
        Map<String, String> meaningForDirection = meanings.get(direction);
        if (meaningForDirection != null) {
            return meaningForDirection.getOrDefault(keyword, "해당 키워드에 대한 의미가 없습니다.");
        }
        return "해당 방향에 대한 의미가 없습니다.";
    }



}
