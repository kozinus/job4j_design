package ru.job4j.generic;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRolenameIsSheriff() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Sheriff");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Citizen"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsSheriff() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        store.add(new Role("1", "Mafia"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Sheriff");
    }

    @Test
    void whenReplaceThenRolenameIsMafia() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        store.replace("1", new Role("1", "Mafia"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Mafia");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        store.replace("10", new Role("10", "Mafia"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Sheriff");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRolenameIsSheriff() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Sheriff");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        boolean result = store.replace("1", new Role("1", "Mafia"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        boolean result = store.replace("10", new Role("10", "Mafia"));
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        boolean result = store.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Sheriff"));
        boolean result = store.delete("2");
        assertThat(result).isFalse();
    }
}