package com.geren.sudoku.main.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.geren.sudoku.R;
import com.geren.sudoku.bean.SudokuBean;
import com.geren.sudoku.main.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    public static final String TAG = "我是MainActivity";

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initView() {

    }

    private void initListener() {

    }

    private void initData() {
        mPresenter = new MainPresenter(this);
        mPresenter.initData();
    }

    @Override
    public void setData(SudokuBean[][] data) {
        Log.e(TAG, "data>>>" + data);
    }
}
