package cn.zxl.jucstudy.exercise;

import org.springframework.stereotype.Component;

/*@Aspect
@Component
public class MyAspect {
    // 是否安全？
    private long start = 0L;

    @Before("execution(* *(..))")
    public void before() {
        start = System.nanoTime();
    }

    @After("execution(* *(..))")
    public void after() {
        long end = System.nanoTime();
        System.out.println("cost time:" + (end - start));
    }
}*/

//这存在线程安全问题，需要修改成环绕通知around或者使用ThreadLocal来解决
/*
@Aspect
@Component
public class MyAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before("execution(* *(..))")
    public void before() {
        startTime.set(System.nanoTime());
    }

    @After("execution(* *(..))")
    public void after() {
        long end = System.nanoTime();
        Long start = startTime.get();
        System.out.println("cost time:" + (end - start));
        startTime.remove(); // 避免内存泄漏
    }
}
*/
/*
@Aspect
@Component
public class MyAspect {

    @Around("execution(* *(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed(); // 执行目标方法
        long end = System.nanoTime();
        System.out.println("cost time: " + (end - start));
        return result;
    }
}
*/
