package com.john.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by baixiaobo on 16/11/16.
 */
public class PlayDemo {
    //创建玩家
    //要对玩家ID的异常处理，要求用户只能输入整数ID，并且玩家的ID和名字不能相同，否则需要重新输入
    public Player setPlayer(Player player) {
        int id = 0;
        String name = "";
        Scanner console = new Scanner(System.in);
        boolean ready = true;
        Player anPlay = new Player(id, name);

        do {
            try {
                System.out.println("输入ID：");
                id = console.nextInt();
                System.out.println("输入姓名：");
                name = console.next();
                anPlay.setName(name);
                anPlay.setId(id);
                if (anPlay.equals(player)) {
                    throw new PlayException("请不要输入相同的ID或者姓名");
                }
                ready = true;
            } catch (PlayException e) {
                System.out.println(e.getMessage());
                ready = false;
                console.nextLine();
            } catch (Exception e) {
                System.out.println("请输入整数类型的ID！");
                ready = false;
                console.nextLine();
            }
        } while (ready == false);
        return anPlay;
    }

    public static void main(String[] args) {
        //测试简易扑克牌程序
        PlayDemo game = new PlayDemo();
        //（1）创建一副牌
        Cards cards = new Cards();
        //（2）展示新的扑克牌
        cards.showCards();
        //（3）洗牌
        cards.shuffleCards();
        //（4）创建玩家
        System.out.println("--------------创建两个（or多个）玩家就可以开始游戏啦！-------------");
        List<Player> p = new ArrayList<Player>();
        for (int i = 0; i < 2; i++) {
            System.out.println("请输入第" + (i + 1) + "位玩家的ID和姓名:");
            Player temp = null;
            if (i == 1) {
                temp = p.get(i - 1);
            }
            p.add(game.setPlayer(temp));
        }
        for (int i = 0; i < p.size(); i++) {
            System.out.println("欢迎玩家：" + p.get(i).getName());
        }
        //（5）扑克牌比大小游戏开始啦~
        int count = 0;
        System.out.println("------------------开始发牌---------------------");
        //设定每人分别拿两张（or多张）
        for (int i = 0; i < 2; i++) {
            //玩家轮流拿牌
            for (int j = 0; j < p.size(); j++) {
                System.out.println(">玩家" + p.get(j).getName() + "拿牌");
                List<Card> playCard = new ArrayList<Card>();
                playCard.add(cards.getCards().get(count));
                p.get(j).setHandCards(playCard);
                count++;
            }
        }
        System.out.println("------------------发牌结束！--------------------");
        System.out.println("------------------开始游戏 ---------------------");
        for (int i = 0; i < p.size(); i++) {
            System.out.print("玩家" + p.get(i).getName() + "的手牌为：[ ");
            for (int j = 0; j < p.get(i).getHandCards().size(); j++) {
                Card cur = p.get(i).getHandCards().get(j);
                System.out.print(cur.getColor() + cur.getPoint() + " ");
            }
            System.out.println(" ]");
        }

        //排序得到每个玩家最大的手牌（排序规则自定义）
        for (int i = 0; i < p.size(); i++) {
            Collections.sort(p.get(i).getHandCards(), new CardComparator());
        }
        List<Card> maxCard = new ArrayList<Card>();
        for (int i = 0; i < p.size(); i++) {
            Card maxCur = p.get(i).getHandCards().get(0);
            System.out.println("玩家" + p.get(i).getName() + "最大的手牌为：" + maxCur.getColor() + maxCur.getPoint());
            maxCard.add(maxCur);
        }

        //得到最后的胜者
        List<Card> temp = new ArrayList<Card>();
        temp.addAll(maxCard);
        Collections.sort(temp, new CardComparator());
        for (int i = 0; i < p.size(); i++) {
            if (maxCard.get(i).equals(temp.get(0))) System.out.println("恭喜玩家：" + p.get(i).getName() + "获胜！");
        }

    }
}
