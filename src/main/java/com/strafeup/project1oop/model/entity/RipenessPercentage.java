package com.strafeup.project1oop.model.entity;

public enum RipenessPercentage {
    UNRIPE(50), RIPE(100), OVERRIPE(150);

    private int percentage;

    RipenessPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

}
