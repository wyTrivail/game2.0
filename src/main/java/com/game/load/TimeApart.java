package com.game.load;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class TimeApart extends Observable{
    private int Time;



    public int getTime() {
        return Time;
    }

    public void setTime(int time) {
        Time = time;
    }

    public TimeApart(){
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Time++;
                if(Time==24)
                    Time=0;
                disPlayTime(Time);
            }
        },0,5000);// 设定指定的时间time,此处为2000毫秒
    }

    private void disPlayTime(int Time) {

        if ( Time==0||Time==8||Time==16) {

            this.setChanged();

            this.notifyObservers();
        }
        System.out.println("当前时间是:"+Time);
    }

}
