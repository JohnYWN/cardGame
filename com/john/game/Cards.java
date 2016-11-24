package com.john.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by baixiaobo on 16/11/16.
 */
public class Cards {
    private List<Card> cards = new ArrayList<Card>();

    public Cards() {
        System.out.println("~~~~~创建扑克牌~~~~~");
        String[] colors = {"黑桃", "红桃", "梅花", "方片"};
        String[] poiont = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < poiont.length; j++) {
                Card card = new Card(colors[i], poiont[j]);
                cards.add(card);
            }
        }
        System.out.println("~~~~~创建扑克牌成功~~~~~");
    }

    public void shuffleCards() {
        System.out.println("~~~~~开始洗牌~~~~~");
        Collections.shuffle(cards);
        System.out.println("~~~~~洗牌结束~~~~~");
    }

    public void showCards() {
        System.out.println("~~~~~当前的扑克牌为~~~~~");
        for (int i = 0; i < cards.size(); i++) {
            System.out.println("[花色:" + cards.get(i).getColor() + ",点数:" + cards.get(i).getPoint() + "]");
        }
    }

    public List<Card> getCards() {
        return cards;
    }


}
