package com.geren.sudoku.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geren.sudoku.bean.SudokuBean;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.YELLOW;

public class ChessBoard extends ViewGroup {

    private Context context;
    private int rowNumber;//行数
    private int xSize, ySize;//屏幕尺寸
    private Paint mPaint;//画笔

    private SudokuBean[][] sudokus;//关卡数据

    public ChessBoard(Context context) {
        this(context, null);
    }

    public ChessBoard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChessBoard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setWillNotDraw(false);//调用onDraw方法
        initData();
    }

    private void initData() {
        rowNumber = 9;
        mPaint = new Paint();
        sudokus = new SudokuBean[][]{};
        for (int i = 0; i < rowNumber * rowNumber; i++) {
            TextView child = new TextView(context);
            child.setText("ceshi");
            child.setBackgroundColor(YELLOW);
            LayoutParams la = new LayoutParams(10, 10);
            addView(child, -1, la);
        }
        requestLayout();
    }

    //初始化行数
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    //初始化关卡信息
    public void setData(SudokuBean[][] sudokuBeans) {
        this.sudokus = sudokuBeans;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int sizeSpec = widthMeasureSpec > heightMeasureSpec ? heightMeasureSpec : widthMeasureSpec;
        super.onMeasure(sizeSpec, sizeSpec);
        Log.e("屏幕尺寸1", "widthMeasureSpec>>>" + widthMeasureSpec + ",heightMeasureSpec>>>" + heightMeasureSpec);

        xSize = getMeasuredWidth();
        ySize = getMeasuredHeight();
        Log.e("屏幕尺寸2", "measuredWidth>>>" + getMeasuredWidth() + ",measuredHeight>>>" + getMeasuredHeight());

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e("摆放", "changed>>>" + changed + ",l>>>" + l + ",t>>>" + t + ",r>>>" + r + ",b>>>" + b);

        int perWithSize = xSize / rowNumber;
        int perHeightSize = ySize / rowNumber;

        for (int y = 0; y < rowNumber; y++) {
            for (int x = 0; x < rowNumber; x++) {

                SudokuBean sudokuBean = sudokus[y][x];
//                Log.e("", "sudokuBean>>>" + sudokuBean.toString());

                int childCount = getChildCount();
                Log.e("", "子元素的数量>>>" + childCount);

//                TextView tv = (TextView) getChildAt(y * rowNumber + x);
//                MarginLayoutParams params = (MarginLayoutParams) tv.getLayoutParams();
//                tv.setHeight(perHeightSize);
//                tv.setWidth(perWithSize);
//                tv.setX(sudokuBean.getX() * perWithSize);
//                tv.setY(sudokuBean.getY() * perHeightSize);
//                tv.setText("" + sudokuBean.getValue());
//                tv.setBackgroundColor(YELLOW);
//                tv.setTextColor(BLACK);
//                LayoutParams params = generateDefaultLayoutParams();
//                params.width = perWithSize;
//                params.height = perHeightSize;

            }
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //背景色
//        canvas.drawColor(GREEN);

        int perWithSize = xSize / rowNumber;
        int perHeightSize = ySize / rowNumber;

        //画网格
        mPaint.setColor(BLUE);
        mPaint.setStrokeWidth(3);

        //画横线
        for (int i = 0; i <= rowNumber; i++) {
            canvas.drawLine(0, perHeightSize * i, xSize, perHeightSize * i, mPaint);
        }
        //画竖线
        for (int i = 0; i <= rowNumber; i++) {
            canvas.drawLine(perWithSize * i, 0, perWithSize * i, ySize, mPaint);
        }
    }
}
