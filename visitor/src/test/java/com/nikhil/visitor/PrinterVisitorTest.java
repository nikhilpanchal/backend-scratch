package com.nikhil.visitor;

import com.nikhil.visitor.models.Account;
import com.nikhil.visitor.models.Composite;
import com.nikhil.visitor.models.Element;
import com.nikhil.visitor.models.Security;
import com.nikhil.visitor.visitors.PrinterVisitor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Arrays;
import java.util.List;

public class PrinterVisitorTest {
    @Spy
    PrinterVisitor vistor = new PrinterVisitor();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_visit_every_element_and_print() {
        // given
        Account account = new Account("account1");
        Composite composite = new Composite("composite1");
        Security security = new Security("security");

        List<Element> elements = Arrays.asList(account, composite, security);

        // when
        for (Element element : elements) {
            element.acceptVisitor(vistor);
        }

        // then
        Mockito.verify(vistor).visit(account);
        Mockito.verify(vistor).visit(composite);
        Mockito.verify(vistor).visit(security);
    }
}
