package ru.job4j.it;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MatrixItTest {

    private Iterator<Integer> it;

    @BeforeEach
    public void setUp() {
    it = new MatrixIt(new int[][]{{1}});
    }

    @Test
    public void when4El() {
            assertThat(it.next()).isEqualTo(1);
    }

    @Test
    public void whenFirstEmptyThenNext() {
        it = new MatrixIt(new int[][] {
                {}, {1}
        });

        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    public void whenFirstEmptyThenHashNext() {
        it = new MatrixIt(new int[][] {
                {}, {1}
        });
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    public void whenRowHasDiffSize() {
        it = new MatrixIt(new int[][] {
                {1}, {2, 3}
        });
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
    }

    @Test
    public void whenFewEmpty() {
        it = new MatrixIt(new int[][] {
                {1}, {}, {}, {}, {2}
        });
        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
    }

    @Test
    public void whenEmpty() {
        it = new MatrixIt(new int[][] {
                {}
        });
        assertThat(it.hasNext()).isFalse();
    }

    @Test
    public void whenEmptyThenNext() {
        it = new MatrixIt(new int[][] {
                {}
        });
        assertThatThrownBy(it::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void whenMultiHashNext() {
        it = new MatrixIt(new int[][] {
                {}, {1}
        });
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    public void whenNoElements() {
        it = new MatrixIt(new int[][] {{}, {}, {}});
        assertThat(it.hasNext()).isFalse();
    }
}
