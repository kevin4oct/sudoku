package com.geren.sudoku.main.presenter;

import com.geren.sudoku.bean.SudokuBean;
import com.geren.sudoku.main.view.IMainView;

import java.util.Random;

public class MainPresenter {

    private IMainView mainView;

    private SudokuBean[][] sourceData;//初始数据容器，用于重置
    private SudokuBean[][] data;//当前数据容器

    public MainPresenter(IMainView mainView) {
        this.mainView = mainView;
        sourceData = new SudokuBean[9][9];
        data = new SudokuBean[9][9];
    }

    public void initData() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int id = 9 * x + y;
                int value = getANumber(x, y);
                boolean isShow = new Random().nextBoolean();
                sourceData[x][y] = new SudokuBean(id, x, y, value, isShow, null);
                data[x][y] = new SudokuBean(id, x, y, value, isShow, null);
            }
        }
        mainView.setData(data);
    }

    public int getANumber(int x, int y) {
        int result = 0;
        while (true) {
            int random = new Random().nextInt(9) + 1;
            // TODO: 2018/12/5

            //
            if (true) {
                return result;
            }
        }
    }


}
