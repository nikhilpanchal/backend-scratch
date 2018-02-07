package com.nikhil.visitor.visitors;

import com.nikhil.visitor.calculators.AccountCalculator;
import com.nikhil.visitor.calculators.CompositeCalculator;
import com.nikhil.visitor.models.Account;
import com.nikhil.visitor.models.Composite;
import com.nikhil.visitor.models.Security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrinterVisitor implements Visitor {
    private static Logger logger = LoggerFactory.getLogger(PrinterVisitor.class);

    AccountCalculator accountCalculator = new AccountCalculator();
    CompositeCalculator compositeCalculator = new CompositeCalculator();

    @Override
    public void visit(Account account) {
        logger.info("Account: {}", account);
        accountCalculator.calculate(account);
    }

    @Override
    public void visit(Composite composite) {
        logger.info("Composite: {}", composite);
        compositeCalculator.calculate(composite);
    }

    @Override
    public void visit(Security security) {
        logger.info("Security: {}", security);
    }
}
