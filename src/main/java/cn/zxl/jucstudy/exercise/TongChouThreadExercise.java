package cn.zxl.jucstudy.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.TongChouThreadExercise")
public class TongChouThreadExercise {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.info("清洗水壶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("烧开水");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"laowang");
        Thread t2 = new Thread(() -> {
            log.info("洗茶壶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("洗茶杯");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("拿茶叶");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("泡茶");
        }, "laoli");
        t1.start();
        t2.start();
    }

}
