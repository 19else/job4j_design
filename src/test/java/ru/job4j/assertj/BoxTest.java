package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isGetVerticesSphere() {
        Box box = new Box(0, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(0);
    }

    @Test
    void isGetVerticesTetrahedron() {
        Box box = new Box(4, 5);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void isExit() {
        Box box = new Box(0, 0);
        boolean result = box.isExit();
        assertThat(result).isFalse();
    }

    @Test
    void isGetAreaCube() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        double result = 6 * (10 * 10);
        assertThat(area).isEqualTo(result);
    }

    @Test
    void isGetAreaSphere() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        double result = 4 * Math.PI * (10 * 10);
        assertThat(area).isEqualTo(result);
    }

    @Test
    void isGetAreaDefault() {
        Box box = new Box(0, 0);
        double area = box.getArea();
        assertThat(area).isEqualTo(0);
    }
}