package ru.job4j.it;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    /**
     * стобец
     */
    private int column = 0;
    /**
     * строка
     */
    private int row = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length) {
            if (column > data[row].length && row < data.length) {
                row++;
            }
        }
        return row < data.length
                && column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
            return data[row][column++];
        }
}
