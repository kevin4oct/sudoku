package com.geren.sudoku.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;

public class ChessBoard extends ViewGroup {

    int rowNumber = 9;//行数

    public ChessBoard(Context context) {
        this(context,null);
    }

    public ChessBoard(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ChessBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
