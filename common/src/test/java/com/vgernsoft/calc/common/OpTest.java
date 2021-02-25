package com.vgernsoft.calc.common;

import static com.vgernsoft.calc.common.Op.exec;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.Test;

public class OpTest {

    @Test
    public void allOps() {

        // given, then, when
        assertEquals(Set.of("+", "-", "/" , "*"), Op.supported());
    }

    @Test
    public void nullArgs() {

        // given, when, then
        assertThrows(NullPointerException.class, () -> exec("+", null, null));
    }

    @Test
    public void nullOp() {

        // given, when, then
        assertThrows(NullPointerException.class, () -> exec(null, 1d, 2d));
    }

    @Test
    public void noOp() {

        // given, when, then
        assertThrows(IllegalArgumentException.class, () -> exec("%", 1d, 2d));
    }

    @Test
    public void addOp() {

        // given, when, then
        assertEquals(3d, exec("+", 1d, 2d));
    }

    @Test
    public void subOp() {

        // given, when, then
        assertEquals(-1d, exec("-", 1d, 2d));
    }

    @Test
    public void mulOp() {

        // given, when, then
        assertEquals(2d, exec("*", 1d, 2d));
    }

    @Test
    public void divOp() {

        // given, when, then
        assertEquals(0.5d, exec("/", 1d, 2d));
    }
}
