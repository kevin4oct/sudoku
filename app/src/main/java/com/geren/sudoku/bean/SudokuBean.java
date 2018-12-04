package com.geren.sudoku.bean;

import java.util.List;

public class SudokuBean {

    private int id;
    private int x;
    private int y;
    private int value;
    private boolean isShow;
    private List<Integer> noteList;

    public SudokuBean(int id, int x, int y, int value, boolean isShow, List<Integer> noteList) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.value = value;
        this.isShow = isShow;
        this.noteList = noteList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public List<Integer> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Integer> noteList) {
        this.noteList = noteList;
    }

    @Override
    public String toString() {
        return "SudokuBean{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", value=" + value +
                ", isShow=" + isShow +
                ", noteList=" + noteList +
                '}';
    }
}
