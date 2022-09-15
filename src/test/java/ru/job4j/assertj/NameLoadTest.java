package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkValidateNoContainValue() {
        NameLoad nameLoad = new NameLoad();
        String[] insert = {"Sergey=", "Krysti", "Gregory", "jeckson"};
        assertThatThrownBy(() -> nameLoad.parse(insert))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("value");
    }

    @Test
    void checkValidateNoContainEqual() {
        NameLoad nameLoad = new NameLoad();
        String[] insert = {"Sergey", "Krysti", "Gregory", "jeckson"};
        assertThatThrownBy(() -> nameLoad.parse(insert))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("\"=\"");
    }

    @Test
    void checkValidateNoContainKey() {
        NameLoad nameLoad = new NameLoad();
        String[] insert = {"=Sergey", "Krysti", "Gregory", "jeckson"};
        assertThatThrownBy(() -> nameLoad.parse(insert))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("a key");
    }
}