package ru.job4j.it;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class BackwardArrayItTest {

    @Test
    public void whenMultiCellhasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.hasNext()).isTrue();
        assertThat(it.hasNext()).isTrue();
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{1, 2, 3}
        );
        assertThat(it.next()).isEqualTo(3);
        assertThat(it.next()).isEqualTo(2);
        assertThat(it.next()).isEqualTo(1);
    }

    @Test
    public void whenNextEmpty() throws NoSuchElementException {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{}
        );
        Throwable thrown = catchThrowable(it::next);
        assertThat(thrown).isInstanceOf(NoSuchElementException.class);
    }
}