package com.nikhil.visitor.calculators;

import com.nikhil.visitor.models.Composite;
import com.nikhil.visitor.models.Element;

public class CompositeCalculator implements Calculator {

    @Override
    public void calculate(Element element) {
        Composite composite = (Composite)element;
    }
}
