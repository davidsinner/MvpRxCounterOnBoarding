package com.globant.counter.android.mvp.view;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.util.bus.RxBus;
import com.globant.counter.android.util.bus.observers.CountButtonUpBusObserver;
import com.globant.counter.android.util.bus.observers.EnterButtonBusObserver;
import com.globant.counter.android.util.bus.observers.ResetButtonObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountView extends ActivityView {

    @BindView(R.id.count_label)
    TextView countLabel;

    @BindView(R.id.et_first_value)
    EditText vFirstValue;

    @BindView(R.id.et_second_value)
    EditText vSecondValue;

    @BindView(R.id.et_operator)
    EditText vOperator;

    @BindView(R.id.btn_enter)
    Button vEnterButton;

    @BindView(R.id.tv_result)
    TextView vResult;

    public CountView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setCount(String count) {
        countLabel.setText(count);
    }

    @OnClick(R.id.count_button)
    public void countButtonPressed() {
        RxBus.post(new CountButtonUpBusObserver.CountButtonUp());
    }

    @OnClick(R.id.reset_button)
    public void resetButtonPressed() {
        RxBus.post(new ResetButtonObserver.ResetButtonPressed());
    }

    @OnClick(R.id.btn_enter)
    public void onEnterButtonClick() {
        RxBus.post(new EnterButtonBusObserver.EnterButtonClick());
    }

    public int getFirstValue() {
        return Integer.valueOf(vFirstValue.getText().toString());
    }

    public int getSecondValue() {
        return Integer.valueOf(vSecondValue.getText().toString());
    }

    public String getOperator() {
        return vOperator.getText().toString();
    }

    public void setResult(int result) {
        vResult.setText(Integer.toString(result));
    }


}
