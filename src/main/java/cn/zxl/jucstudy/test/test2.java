package cn.zxl.jucstudy.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.Test2")
public class test2 {
    public static void main(String[] args) {
        FutureTask<String>stringFutureTask=new FutureTask<>(() -> {;
            log.info("t1 start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("t1 end");
            return "hello";
        });
        Thread thread=new Thread(stringFutureTask,"t1");
        thread.start();
        try {
            String s = stringFutureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
            Thread.currentThread().interrupt(); // Restore the interrupted status
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
