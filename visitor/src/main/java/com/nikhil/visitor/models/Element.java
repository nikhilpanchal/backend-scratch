package com.nikhil.visitor.models;

import com.nikhil.visitor.visitors.Visitor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Element {
    private final String id;

    abstract public void acceptVisitor(Visitor visitor);
}
