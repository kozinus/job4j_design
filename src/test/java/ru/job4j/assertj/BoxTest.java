package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .startsWithIgnoringCase("s");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(3, 10);
        String name = box.whatsThis();
        assertThat(name).startsWithIgnoringCase("unknown")
                .endsWith("object");
    }

    @Test
    void areaOfTetra() {
        Box box = new Box(4, 4);
        Double result = box.getArea();
        assertThat(result).isCloseTo(28d, Percentage.withPercentage(1.05d))
                .isCloseTo(28d, withPrecision(0.3d));
    }

    @Test
    void areaOfCube() {
        Box box = new Box(8, 4);
        Double result = box.getArea();
        assertThat(result).isGreaterThan(90d)
                .isLessThan(100d);
    }

    @Test
    void cubeVertex() {
        Box box = new Box(8, 2);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8)
                .isEven();
    }

    @Test
    void tetraVertex() {
        Box box = new Box(4, 2);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotEqualTo(8)
                .isEven()
                .isBetween(0, 8);
    }

    @Test
    void cubeIsExist() {
        Box box = new Box(4, 2);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isNotEqualTo(false);
    }

    @Test
    void sphereIsNotExist() {
        Box box = new Box(0, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isNotEqualTo(true);
    }
}