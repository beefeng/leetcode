package com.beefeng.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayInterator<T> implements Iterator {


    private List<List<T>> dataRect;

    private int rowIndex = 0;
    private int columnIndex = 0;

    public ArrayInterator(List<List<T>> rect) {
        this.dataRect = rect;
        Object[] nextIndexs = findNext(0, -1);
        rowIndex = (int) nextIndexs[0];
        columnIndex = (int) nextIndexs[1];
    }


    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(4);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(6);
        row2.add(5);
        row2.add(7);

        List<List<Integer>> dataList = new ArrayList<>();
        dataList.add(row1);
        dataList.add(row2);

        ArrayInterator<Integer> arrayInterator = new ArrayInterator<>(dataList);
        while (arrayInterator.hasNext()) {
            System.out.print(arrayInterator.next() + " ");
        }
        System.out.println("========");



        row1 = new ArrayList<>();

        row2 = new ArrayList<>();
        row1.add(3);
        row1.add(6);
        row1.add(5);
        row1.add(7);

        dataList = new ArrayList<>();
        dataList.add(row1);
        dataList.add(row2);

        arrayInterator = new ArrayInterator<>(dataList);
        while (arrayInterator.hasNext()) {
            System.out.print(arrayInterator.next() + " ");
        }
        System.out.println("========");

        row1 = new ArrayList<>();

        row2 = new ArrayList<>();
        row2.add(4);
        row2.add(6);
        row2.add(5);
        row2.add(7);

        dataList = new ArrayList<>();
        dataList.add(row1);
        dataList.add(row2);

        arrayInterator = new ArrayInterator<>(dataList);
        while (arrayInterator.hasNext()) {
            System.out.print(arrayInterator.next() + " ");
        }
        System.out.println("========");
    }


    private T getItem(int rowIndex, int columnIndex) {
        if (rowIndex < dataRect.size()) {
            List<T> rowList = dataRect.get(rowIndex);
            if (columnIndex < rowList.size()) {
                return rowList.get(columnIndex);
            }
        }
        return null;

    }

    private int[] findNextIndex(int rowIndex, int columnIndex) {
        if (rowIndex < dataRect.size()) {
            List<T> rowList = dataRect.get(rowIndex);
            if (columnIndex < rowList.size() - 1) {
                return new int[]{rowIndex, columnIndex + 1};
            } else if (rowIndex < dataRect.size() - 1) {
                return new int[]{rowIndex + 1, 0};
            }
        }
        return new int[]{-1, -1};
    }

    private Object[] findNext(int rowIndex, int columnIndex) {
        int[] nextIndexs = findNextIndex(rowIndex, columnIndex);
        T nextItem = null;
        while (nextIndexs[0] >= 0 && nextIndexs[1] >= 0 && (nextItem = getItem(nextIndexs[0], nextIndexs[1])) == null) {
            nextIndexs = findNextIndex(nextIndexs[0], nextIndexs[1]);
        }

        if(nextItem != null) {
            return new Object[]{nextIndexs[0], nextIndexs[1], nextItem};
        }
        return new Object[]{-1, -1, null};
    }

    @Override
    public boolean hasNext() {
        return rowIndex >= 0 && columnIndex >= 0 && getItem(rowIndex, columnIndex) != null;
    }

    @Override
    public T next() {
        T result = null;
        if(rowIndex < 0 || columnIndex < 0) {
            return null;
        } else {
            T item = getItem(rowIndex, columnIndex);
            if (item != null) {
                Object[] nextResult = findNext(rowIndex, columnIndex);
                rowIndex = (int) nextResult[0];
                columnIndex = (int) nextResult[1];
                result = item;
            }
        }
        return result;
    }

    @Override
    public void remove() {

    }
}
