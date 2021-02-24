package com.vgernsoft.calc.common;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;

public final class Op {

    private static final Map<String, BinaryOperator<Double>> ops = Map.of("+", (a, b) -> a + b, "-", (a, b) -> a - b,
            "*", (a, b) -> a * b, "/", (a, b) -> a / b);

    public static Set<String> supported() {
        return ops.keySet();
    }

    public static Double exec(final String op, final Double a, final Double b) {
        return Optional.ofNullable(ops.get(op)).orElseThrow(IllegalArgumentException::new).apply(a, b);
    }
}
