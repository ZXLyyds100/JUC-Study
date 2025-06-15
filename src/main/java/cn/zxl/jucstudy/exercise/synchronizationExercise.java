package cn.zxl.jucstudy.exercise;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.synchronizationExercise")
public class synchronizationExercise {
    static int counter = 0;
    static final Object room = new Object();//必须是实际存在的对象，是一个对象锁
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room) {
                    counter++;
                }
            }
        },
                "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room) {
                    counter--;
                }
            }
        },
                "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{}",counter);//会发现只能是0了，不再出现正负数
    }

}
