package com.john.game;

import java.util.Comparator;

/**
 * Created by baixiaobo on 16/11/16.
 */
public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        String[] colors = {"黑桃", "红桃", "梅花", "方片"};
        String[] poiont = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int valueOfC1 = 0;
        int valueOfC2 = 0;
        for (int i = 0; i < poiont.length; i++) {
            if (o1.getPoint().equals(poiont[i])) valueOfC1 += i * 10;
            if (o2.getPoint().equals(poiont[i])) valueOfC2 += i * 10;
        }
        for (int i = 0; i < colors.length; i++) {
            if (o1.getColor().equals(colors[i])) valueOfC1 += i;
            if (o2.getColor().equals(colors[i])) valueOfC2 += i;
        }

        if (valueOfC1 > valueOfC2) return -1;
        if (valueOfC1 < valueOfC2) return 1;

        return 0;
    }
}
