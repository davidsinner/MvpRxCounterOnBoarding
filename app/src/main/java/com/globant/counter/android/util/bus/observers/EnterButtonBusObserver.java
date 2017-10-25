package com.globant.counter.android.util.bus.observers;

public abstract class EnterButtonBusObserver extends BusObserver<EnterButtonBusObserver.EnterButtonClick> {
    public EnterButtonBusObserver() {
        super(EnterButtonClick.class);
    }

    public static class EnterButtonClick {
    }
}