package com.strafeup.task3.part3;


import java.util.Objects;

public class WarningLevel {

    public static final WarningLevel LOW = new WarningLevel("low");
    public static final WarningLevel MEDIUM = new WarningLevel("medium");
    public static final WarningLevel HIGH = new WarningLevel("high");
    public static final WarningLevel DEFAULT = new WarningLevel("default");

    private String level;

    public WarningLevel(String level) {
        this.level = level;
    }

    public static WarningLevel valueOf(String value) {
        switch (value.toLowerCase()) {
            case "low":
                return LOW;
            case "medium":
                return MEDIUM;
            case "high":
                return HIGH;
        }
        return DEFAULT;
    }

    public static WarningLevel[] values() {
        return new WarningLevel[]{LOW, MEDIUM, HIGH};
    }

    public static int getIndex(WarningLevel warningLevel) {
        switch (warningLevel.level) {
            case "low":
                return 0;
            case "medium":
                return 1;
            case "high":
                return 2;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarningLevel)) return false;
        WarningLevel that = (WarningLevel) o;
        return Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }

    @Override
    public String toString() {
        return WarningLevel.class.getSimpleName() + "." + level.toUpperCase();
    }
}
