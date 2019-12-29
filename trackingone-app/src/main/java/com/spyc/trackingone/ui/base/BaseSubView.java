package com.spyc.trackingone.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by Jorge Namitle on 18/03/2018.
 */

public abstract class BaseSubView extends ViewGroup implements SubMvpView {

    private MvpViewContract parentMvpViewContract;

    public BaseSubView(Context context){super(context);}

    public BaseSubView(Context context, AttributeSet attrs){super(context, attrs);}

    public BaseSubView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public BaseSubView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void attachParentMvpView(MvpViewContract mvpView) {
        parentMvpViewContract = mvpView;
    }

    @Override
    public void showLoading() {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.hideLoading();
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.onError(message);
        }
    }

    @Override
    public void showMessage(String message) {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.showMessage(resId);
        }
    }

    @Override
    public void hideKeyboard() {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.hideKeyboard();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (parentMvpViewContract != null) {
            return parentMvpViewContract.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (parentMvpViewContract != null) {
            parentMvpViewContract.openActivityOnTokenExpire();
        }
    }

    protected abstract void bindViewsAndSetOnClickListeners();

    protected abstract void setUp();


}
