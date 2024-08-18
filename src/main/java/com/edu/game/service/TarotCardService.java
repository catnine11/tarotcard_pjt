package com.edu.game.service;

import com.edu.game.aggregate.CardName;
import com.edu.game.aggregate.Direction;
import com.edu.game.aggregate.TarotCard;
import com.edu.game.repository.TarotCardRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TarotCardService {

    private final TarotCardRepository cardRepository;
    private final List<TarotCard> cards;
    private final Random random;

    public TarotCardService() {
        cardRepository = new TarotCardRepository();
        cards = new ArrayList<>(cardRepository.getAllCards());
        this.random = new Random();
    }

    public TarotCard getRandomCard(int index) {
        Collections.shuffle(cards);
        if(index >= 0 && index < cards.size()) {
            return cards.get(index);
        } else {
            throw new IllegalArgumentException("등록된 카드의 개수가 " + (index + 1) + "보다 작습니다.");
        }
    }

    public Direction getRandomDirection() {
        return random.nextBoolean() ? Direction.UPRIGHT : Direction.REVERSED;
    }

    public String getCardMeaning(CardName cardName, Direction direction, String keyword) {
        for(TarotCard card : cards) {
            if(card.getName().equals(cardName)) {
                return card.getMeaning(direction, keyword);
            }
        }

        return "해당 카드가 없습니다.";
    }

    public void saveResultToFile(String fileName, CardName name, Direction direction, String keyword) {
        String meaning = getCardMeaning(name, direction, keyword);
        cardRepository.saveResultToFile(fileName, name, direction, keyword, meaning);
    }
}
