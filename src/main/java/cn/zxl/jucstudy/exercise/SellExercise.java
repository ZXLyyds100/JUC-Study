package cn.zxl.jucstudy.exercise;

import cn.zxl.jucstudy.Pojo.TicketWindow;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

@Slf4j(topic = "c.SellExercise")
public class SellExercise {
    public static void main(String[] args) {
        //模拟多人买票
        TicketWindow ticketWindow = new TicketWindow(1000);
        List<Integer>amountList= new Vector<>();
        List<Thread>threadList=new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(() -> {
                //每个人随机买1-5张票
                int amount = randomAmount();
                ticketWindow.sell(amount);
                amountList.add(amount);
            }, "Thread-" + i);
            threadList.add(thread);
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                thread.interrupt();
            }
        }
        log.info("余票{}", ticketWindow.getCount());
        log.info("卖出的票{}",amountList.stream().mapToInt(Integer::intValue).sum());

    }
    static Random random = new Random();
    public static int randomAmount() {
        // 生成一个随机数，范围在1到100之间
        return random.nextInt(5) + 1;
    }
}
