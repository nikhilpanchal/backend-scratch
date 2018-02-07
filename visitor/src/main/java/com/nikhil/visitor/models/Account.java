package com.nikhil.visitor.models;

import com.nikhil.visitor.visitors.Visitor;
import lombok.Builder;

public class Account extends Element {

    @Builder
    public Account(String id) {
        super(id);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }
}
