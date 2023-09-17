package ru.job4j.patterns.fabric.factorybasic;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker watchMaker = getMakerByType("Rome");
        Watch digitalWatch = watchMaker.createWatch();
        digitalWatch.showTime();
    }

    public static WatchMaker getMakerByType(String maker) {

        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        }

        throw new IllegalArgumentException("cannot make watches with maker " + maker);
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("VV-XXI");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {

    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
