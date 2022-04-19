package com.technews.repository;


// A study interface
// interface tells everything that implements it
// that it needs a run and jump method
public interface Movement {
    public void run();
    public void jump();
}

class Dog implements Movement {
    public void run() {
        System.out.println("This dog can run a long time");
    }
    public void jump() {
        System.out.println("This dog can't jump very high");
    }
}

class Cat implements Movement {
    public void run() {
        System.out.println("This cat can run very fast");
    }
    public void jump() {
        System.out.println("This cat can jump very high");
    }
}
