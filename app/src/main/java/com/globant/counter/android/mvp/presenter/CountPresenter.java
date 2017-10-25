package com.globant.counter.android.mvp.presenter;

import android.app.Activity;

import com.globant.counter.android.mvp.model.CalculatorModel;
import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.view.CountView;
import com.globant.counter.android.util.bus.RxBus;
import com.globant.counter.android.util.bus.observers.CountButtonUpBusObserver;
import com.globant.counter.android.util.bus.observers.EnterButtonBusObserver;
import com.globant.counter.android.util.bus.observers.ResetButtonObserver;

public class CountPresenter {

    private CountModel model;
    private CalculatorModel calculatorModel;
    private CountView view;

    public CountPresenter(CountModel model, CalculatorModel calculatorModel, CountView view) {
        this.model = model;
        this.calculatorModel = calculatorModel;
        this.view = view;
    }

    public void onCountButtonPressed() {
        model.inc();
        view.setCount(String.valueOf(model.getCount()));
    }

    public void onResetButtonPressed() {
        model.reset();
        view.setCount(String.valueOf(model.getCount()));
    }

    public void onEnterButtonClick() {
        int result = calculatorModel.calculateResult(view.getFirstValue(), view.getSecondValue(), view.getOperator());
        view.setResult(result);
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }

        RxBus.subscribe(activity, new CountButtonUpBusObserver() {
            @Override
            public void onEvent(CountButtonUpBusObserver.CountButtonUp value) {
                onCountButtonPressed();
            }
        });

        RxBus.subscribe(activity, new ResetButtonObserver() {
            @Override
            public void onEvent(ResetButtonPressed value) {
                onResetButtonPressed();
            }
        });

        RxBus.subscribe(activity, new EnterButtonBusObserver() {
            @Override
            public void onEvent(EnterButtonBusObserver.EnterButtonClick value) {
                onEnterButtonClick();
            }
        });


    }

    public void unregister() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.clear(activity);
    }
}
