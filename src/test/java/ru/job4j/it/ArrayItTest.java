package ru.job4j.it;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

public class ArrayItTest {

    @Test
    void whenMultiCallHasNextThenTrue() {
        ArrayIt it = new ArrayIt(
                 new int[]{1, 2, 3}
        );
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    void whenReadSequence() {
        ArrayIt it = new ArrayIt(
                new int[]{1, 2, 3}
        );

        assertThat(it.next()).isEqualTo(1);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(3);
    }

    @Test
    public void whenNextFromEmpty() throws NoSuchElementException {
        ArrayIt it = new ArrayIt(
                new int[]{}
        );
        Throwable thrown = catchThrowable(it::next);
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }
}