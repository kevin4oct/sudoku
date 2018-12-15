package com.geren.sudoku.main.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.geren.sudoku.R;
import com.geren.sudoku.bean.SudokuBean;
import com.geren.sudoku.main.presenter.MainPresenter;
import com.geren.sudoku.view.ChessBoard;

public class MainActivity extends AppCompatActivity implements IMainView, Handler.Callback, View.OnClickListener {

    public static final int TIME_START = 0x001;
    public static final int TIME_GOON = 0x002;
    public static final int TIME_STOP = 0x003;
    public static final String TAG = "我是MainActivity";
    Handler mHandler = new Handler(this);

    private MainPresenter mPresenter;
    private Button timeBtn;

    private int time;
    private ChessBoard chessBoard;
    private Button returnBtn;

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
        returnBtn = (Button) findViewById(R.id.btn_return);
        timeBtn = (Button) findViewById(R.id.btn_time);
        chessBoard = (ChessBoard) findViewById(R.id.chessboard);
    }

    private void initListener() {
        returnBtn.setOnClickListener(this);
    }

    private void initData() {
        mPresenter = new MainPresenter(this);
        mPresenter.initData();
        mHandler.sendEmptyMessage(TIME_START);
    }

    @Override
    public void setData(SudokuBean[][] data) {
        Log.e(TAG, "data>>>" + data);
        chessBoard.setData(data);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case TIME_START:
                time += 2;
                timeBtn.setText(time + "(s)");
                mHandler.sendEmptyMessageDelayed(TIME_START, 2000);
                break;
            case TIME_GOON:

                break;
            case TIME_STOP:

                break;
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_return:
                this.finish();
                break;
        }
    }
}
