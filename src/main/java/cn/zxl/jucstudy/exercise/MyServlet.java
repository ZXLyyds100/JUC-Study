package cn.zxl.jucstudy.exercise;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyServlet extends HttpServlet {
    // 是否安全？
    // 并不安全，因为Servlet的service方法是多线程调用的，
    // 如果多个线程同时访问这个Servlet实例的doGet方法，
    // 那么这个map就会被多个线程同时访问和修改，导致数据不一致。
    // 为了保证线程安全，应该将map声明为线程安全的类型，
    // 或者在访问和修改map时使用同步机制来保证线程安全。
    Map<String,Object> map = new HashMap<>();
    // 是否安全？
    // 属于不可变对象，线程安全。
    String S1 = "...";
    // 是否安全？
    final String S2 = "...";
    // 是否安全？
    Date D1 = new Date();
    // 是否安全？
    final Date D2 = new Date();
    //不安全，因为Date是可变对象，属性可改
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }
    }
