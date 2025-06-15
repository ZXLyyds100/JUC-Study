package cn.zxl.jucstudy.exercise;

import cn.zxl.jucstudy.Pojo.ThreadUnsafe;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j(topic = "c.localVariableThreadSecurityExercise")
public class localVariableThreadSecurityExercise {
    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;
    public static void main(String[] args) {
        ThreadUnsafe test = new ThreadUnsafe();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                test.method1(LOOP_NUMBER);
            },
                    "Thread" + i).start();
        }

    }

}
