package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenUsernameIsPetr() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        Role result = role.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenAddAndFindThenUserIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        Role result = role.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsPetr() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.add(new Role("1", "Maxim"));
        Role result = role.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenReplaceThenUsernameIsMaxim() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.replace("1", new Role("1", "Maxim"));
        Role result = role.findById("1");
        assertThat(result.getUsername()).isEqualTo("Maxim");
    }

    @Test
    void whenNoReplaceUserThenNoChangeUsername() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.replace("10", new Role("10", "Maxim"));
        Role result = role.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.delete("1");
        Role result = role.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteUserThenUsernameIsPetr() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        role.delete("10");
        Role result = role.findById("1");
        assertThat(result.getUsername()).isEqualTo("Petr");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        boolean rsl = role.replace("1", new Role("1", "Maxim"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        boolean rsl = role.replace("10", new Role("10", "Maxim"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        boolean rsl = role.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore role = new RoleStore();
        role.add(new Role("1", "Petr"));
        boolean rsl = role.delete("2");
        assertThat(rsl).isFalse();
    }
}