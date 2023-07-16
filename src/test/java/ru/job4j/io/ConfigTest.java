package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithSpaces() {
        String path = "./data/pairWithSpaces.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Kirill=Kozin");
    }

    @Test
    void whenPairWithCommentsAndSpaces() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"))
                .isEqualTo("org.postgresql.Driver");
    }

    @Test
    void whenIllegalPair() {
        String path = "./data/IllegalPair.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                config::load);
        assertThat(exception.getMessage()).isEqualTo("Does not contain equal symbols");
    }
}