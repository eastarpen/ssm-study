package com.eastarpen.demo03;

public class HelloSpring {
    private String who;

    public HelloSpring(){}
    public HelloSpring(String who) {
        this.who = who;
    }

    public void sayHello() {
        if(who == null || who.equals("")) {
            who = "Spring";
        }
        System.out.println("Hello, "+who+"!");
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWho() {
        return who;
    }
}
