package com.example.guanli.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
@Component
public class LogUtil {
    private BlockingDeque<String> blockingDeque= new LinkedBlockingDeque<>();
    private LogThread logThread;
    private String filePath = "C:\\Users\\c\\project\\log.txt";

    public LogUtil(){
        logThread = new LogThread();
        System.out.println("LogUtil"+"  "+logThread.getName());
        logThread.start();
    }
    public void info(String log){
        blockingDeque.offer(log);
        System.out.println("info"+"  "+Thread.currentThread().getName());
    }

    class LogThread extends Thread{
        @Override
        public void run(){
            while (true){
                String log= blockingDeque.poll();
                if (log!=null){
                    try {
                        System.out.println("当前sleep线程"+Thread.currentThread().getName());
                        Thread.sleep(5000);
                    }catch (Exception e){
                        System.out.println("sleep false");
                    }
                    System.out.println(Thread.currentThread().getName()+"  "+"正在write");
                    FileUtil.writeText(filePath,log,true);
                }
            }
        }
    }
}
