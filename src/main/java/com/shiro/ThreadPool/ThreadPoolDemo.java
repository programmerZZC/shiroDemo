package com.shiro.ThreadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                20,0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 30 ; i++) {
            threadPoolExecutor.execute(new MyTask(i));
        }
    }
}

class MyTask implements Runnable{
    int i = 0;
    public MyTask(int i){
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--"+i);
        try {
            Thread.sleep(1000L); //业务逻辑
        }catch (Exception e){

        }
    }

}