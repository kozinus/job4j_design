package ru.job4j.assertj;

import java.util.*;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

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
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).contains("second")
                .containsOnly("first", "second", "three", "four", "five")
                .endsWith("three", "four", "five")
                .doesNotContainNull()
                .hasSizeGreaterThanOrEqualTo(5);
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).containsOnlyOnce("second")
                .containsAnyOf("first", "four", "five")
                .doesNotContainNull()
                .hasSizeGreaterThanOrEqualTo(5);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> set = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(set).hasSize(5)
                .containsValues(1, 3, 2)
                .containsKeys("first", "five");
    }
}