package com.nikhil.visitor.visitors;

import com.nikhil.visitor.models.Account;
import com.nikhil.visitor.models.Composite;
import com.nikhil.visitor.models.Security;

public interface Visitor {

    public void visit(Account account);

    public void visit(Composite composite);

    public void visit(Security security);
}
