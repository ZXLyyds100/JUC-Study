package cn.zxl.jucstudy.exercise;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.synchronizationExercise")
public class synchronizationExercise {

/*    static int counter = 0;
    static final Object room = new Object();//必须是实际存在的对象，是一个对象锁*/
    public static void main(String[] args) throws InterruptedException {
        Room room= new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        },
                "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.decrement();
            }
        },
                "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("{}",room.getCounter());//会发现只能是0了，不再出现正负数
    }

}

class Room{
    private static int counter = 0;
    public  void increment() {
        synchronized (this) {
            counter++;
        }
    }
    public void decrement() {
        synchronized (this) {
            counter--;
        }
    }
    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }
}