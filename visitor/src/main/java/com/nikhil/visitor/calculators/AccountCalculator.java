package com.nikhil.visitor.calculators;

import com.nikhil.visitor.models.Account;
import com.nikhil.visitor.models.Element;

public class AccountCalculator implements Calculator {

    @Override
    public void calculate(Element element) {
        Account account = (Account)element;
    }
}
