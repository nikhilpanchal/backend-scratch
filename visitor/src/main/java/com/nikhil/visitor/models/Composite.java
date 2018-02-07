package com.nikhil.visitor.models;

import com.nikhil.visitor.visitors.Visitor;

public class Composite extends Element {

    public Composite(String id) {
        super(id);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}
