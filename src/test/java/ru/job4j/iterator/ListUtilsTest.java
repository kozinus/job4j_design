package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveByEven() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.removeIf(input, x -> x % 2 == 0);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenReplaceByLessThan3() {
        ListUtils.addAfter(input, 0, 2);
        ListUtils.replaceIf(input, x -> x < 3, 0);
        assertThat(input).hasSize(3).containsSequence(0, 0, 3);
    }

    @Test
    void whenRemoveAllOfList() {
        input.addAll(2, List.of(9, 11, 12, 33, 100, 2, 7, 3, 1, 1));
        ListUtils.removeAll(input, List.of(100, 2, 7, 12));
        assertThat(input).hasSize(8).containsSequence(1, 3, 9, 11, 33, 3, 1, 1);
    }
}