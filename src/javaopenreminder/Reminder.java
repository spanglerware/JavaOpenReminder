/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaopenreminder;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Scott
 */

//reminder class stores reminder information and operates timers
public class Reminder {    
    private Timer timer;
    private long alarmTime;
    private String reminderName;
    private boolean repeating;
    private int index;
    private ReminderCallbacks reminderCallbacks;
    
    public Reminder() {
        alarmTime = 10;
        timer = new Timer();
        reminderName = "take a break";       
        repeating = false;
    }
    
    //primary constructor
    public Reminder(String name, String frequency, boolean repeating,
            int index, ReminderCallbacks callbacks) {
        reminderName = name;
        alarmTime = Long.parseLong(frequency);
        reminderCallbacks = callbacks;
        this.repeating = repeating;
        this.index = index;
        timer = new Timer();
    }
    
    //timer countdowns selected time and triggers callbacks for updating table
    //and for sounding alarm
    public void startTimer() {
        //send in alarmTime and use for both delay and period
        System.out.println("start time: " + System.currentTimeMillis());
        //timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            long counter = alarmTime;
            public void run() {
                System.out.println("task now run");
                counter--;
                reminderCallbacks.timerCallback(
                        TimeUtil.MillisToTimeString(counter * 1000), index);
                System.out.println("current time: " + System.currentTimeMillis());
                if (counter <= 0) {
                    System.out.println("task done");
                    reminderCallbacks.finishedCallback(
                            TimeUtil.MillisToTimeString(alarmTime * 1000), index);
                    if (repeating) {
                        counter = alarmTime;
                    } else {
                        timer.cancel();
                        timer = new Timer();
                    }
                }
                System.out.println("counter: " + counter);
            }
        }, 1000, 1000);
    }
    
    //cancels timer operation
    public void stopTimer() {
        timer.cancel();
        timer = new Timer();
        System.out.println("timer canceled");
    }
    
    public String getName() {
        return reminderName;
    }
    
    public String getFreq() {
        return String.valueOf(alarmTime);
    }
    
    public boolean getRepeat() {
        return repeating;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public String getTime() {
        return TimeUtil.MillisToTimeString(alarmTime * 1000);
    }
    
}
