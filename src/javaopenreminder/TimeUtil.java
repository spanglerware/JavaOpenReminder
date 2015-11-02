/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaopenreminder;

/**
 *
 * @author Scott
 */

//TimeUtil used for formatting time data
public class TimeUtil {
    
    public static String MillisToTimeString(long millis) {
        int hours, minutes, seconds;
        float timeValue = millis / 3600000.0f;
        hours = (int) Math.floor(timeValue);
        minutes = (int) Math.floor((timeValue - hours) * 60);
        seconds = (int) Math.round((timeValue - hours - (minutes / 60.0f)) * 3600);
        if (seconds >= 60) {
            seconds -= 60;
            minutes += 1;
        }
        if (minutes >= 60) {
            minutes -= 60;
            hours += 1;
        }

        String formattedFreq = "";
        if (hours != 0) { formattedFreq = String.valueOf(hours) + ":"; }
        formattedFreq += String.format("%02d:%02d", minutes, seconds);

        return formattedFreq;
    }    
}
