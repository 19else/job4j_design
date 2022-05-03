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
    private int line = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (line > data[line].length) {
            column++;
        }
        return column < data.length
                && line < data[column].length;
    }

    @Override
    public Integer next() {
        int result;
        result = data[column][line];
        line++;
        return result;
    }
}
