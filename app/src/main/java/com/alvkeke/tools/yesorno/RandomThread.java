package com.alvkeke.tools.yesorno;

import java.util.Date;
import java.util.Random;

public class RandomThread implements Runnable {

    RandomCallback callback;

    RandomThread(RandomCallback callback){
        this.callback = callback;
    }

    @Override
    public void run() {
        for (int i = 0; i<20; i++){
            try {
                Thread.sleep(100);
//                long time = new Date().getTime();
//                if (time%2 == 0){
//                    callback.inter(true);
//                }else {
//                    callback.inter(false);
//                }
                Random r = new Random();
                long time = r.nextInt();
                callback.inter(time%2 == 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            callback.done(new Date().getTime()%2 == 0);
            Random r = new Random();
            long time = r.nextInt();
            callback.done(time%2 == 0);
        }
    }
}
