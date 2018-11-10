/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package time;

/**
 *
 * @author NCC
 */
public class Time {
    int hour;
    int minute;
    int second;
    
    void setHour(int hour){
        this.hour=hour;
    }
    void setMinute(int minute){
        this.minute=minute;
    }
    void setSecond(int second){
        this.second=second;
    }
    int getHour(){
        return(this.hour);
    }
    int getMinute(){
        return(this.minute);
    }
    int getSecond(){
        return(this.second);
    }
}