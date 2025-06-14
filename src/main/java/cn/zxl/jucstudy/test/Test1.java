package cn.zxl.jucstudy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        Thread t1=new Thread("on your mark") {
            @Override
            public void run() {
                log.info("t1 start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("t1 end");
            }
        };
        t1.start();
        log.info("t1 is alive: {}", t1.isAlive());
    }
    Thread t2=new Thread(()->{
        log.info("t2 start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("t2 end");
    }, "t2");
}
