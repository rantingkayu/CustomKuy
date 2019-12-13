package com.example.customkuy.Welcom;

import com.example.customkuy.R;

public enum ModelObject {

    Welcome(R.string.Welcome, R.layout.activity_welcome),
    Welcom1(R.string.Welcome1, R.layout.activity_welcome1),
    Welcome2(R.string.Welcome2, R.layout.activity_welcome2);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}