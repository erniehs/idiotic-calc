package com.vgernsoft.calc.common;

import java.util.StringTokenizer;

import lombok.RequiredArgsConstructor;

interface Node {

    float eval();
}

@RequiredArgsConstructor
class AddOp implements Node {

    private final Node left;

    private final Node right;

    @Override
    public float eval() {
        return left.eval() + right.eval();
    }
}

@RequiredArgsConstructor
class Num implements Node {

    private final float n;

    @Override
    public float eval() {
        return n;
    }
}

public class BinaryOpChop {

    private static final String TOKENS = " /*+-";

    public Node buildTree(final String expr) {
        StringTokenizer exprTokenizer = new StringTokenizer(expr, TOKENS);

        return null;
    }
}
