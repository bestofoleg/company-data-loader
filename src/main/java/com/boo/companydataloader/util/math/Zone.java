package com.boo.companydataloader.util.math;

public enum Zone {
    RED(0f),
    GREY(1.1f),
    GREEN(2.6f);

    private float value;

    Zone(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
