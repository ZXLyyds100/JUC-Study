package cn.zxl.jucstudy.exercise;


import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.synchronizationToMethodExercise2")
public class synchronizationToMethodExercise2 {
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        new Thread(()->{
            try {
                n1.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{ n2.b(); }).start();
/*        new Thread(()->{ n2.c(); }).start();*/
    }
}
@Slf4j(topic = "c.Number")
class Number2{
    public static synchronized void a() throws InterruptedException {
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
//static方法锁住的是类的Class对象
//非static方法锁住的是对象实例
//所以不会相互影响