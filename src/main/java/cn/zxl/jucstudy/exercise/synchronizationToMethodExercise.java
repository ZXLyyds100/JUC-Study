package cn.zxl.jucstudy.exercise;


import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.synchronizationToMethodExercise")
public class synchronizationToMethodExercise {
    public static void main(String[] args) {
        Number n1 = new Number();
        new Thread(()->{
            try {
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{ n1.b(); }).start();
        new Thread(()->{ n1.c(); }).start();
    }
}
@Slf4j(topic = "c.Number")
class Number{
    public synchronized void a() throws InterruptedException {
        sleep(1);
        log.info("1");
    }
    public synchronized void b() {
        log.info("2");
    }
    public void c() {
        log.info("3");
    }
}
//312 321 231
//因为1一定比3后执行，所以3和2的顺序不确定