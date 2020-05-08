package app.engine.utils;

public class Stoper {
    long startTime;

    public Stoper(){
        reset();
    }

    public void start() {
        reset();
    }

    public void reset(){
        this.startTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return (System.currentTimeMillis() - this.startTime);
    }
}
