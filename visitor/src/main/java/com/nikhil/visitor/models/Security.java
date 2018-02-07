package com.nikhil.visitor.models;

import com.nikhil.visitor.visitors.Visitor;

public class Security extends Element {

    public Security(String id) {
        super(id);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}
