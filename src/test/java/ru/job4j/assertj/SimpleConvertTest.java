package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> array = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(array).filteredOn(e -> e.startsWith("second")).first().isEqualTo("second");
        assertThat(array).filteredOnAssertions(e -> assertThat(e).isLessThanOrEqualTo("four"))
                .contains("four", Index.atIndex(1))
                .hasSize(3)
                .first().isEqualTo("first");
    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
       Set<String> array = simpleConvert.toSet(
               "first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .containsOnly("first", "second", "five", "three", "four")
                .containsAnyOf("nine", "four", "twelve")
                .doesNotContain("zero");
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> array = simpleConvert.toMap(
                "first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .containsValues(1)
                .containsKey("second")
                .doesNotContainValue(5)
                .doesNotContainKey("zero");
    }
}