package ru.job4j.it;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class MatrixIt implements Iterator<Integer> {
private final int[][] data;
private int column = 0; //столбец
private int line = 0;  // строка


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
    //  return column < data.length
//         && line < data[column].length;
}

    @Override
    public Integer next() {
    int result;
    result = data[column][line];
    line++;
    return result;

    //        if (!hasNext()) {
//            throw new NoSuchElementException();
//        }
//        int rsl = 0;
//        while (column < data.length) {
//            if (line < data[column].length) {
//                rsl = data[column][line];
//                line++;
//            } else {
//                line = 0;
//                column++;
//            }
//        }
//        return rsl;
    }
}
