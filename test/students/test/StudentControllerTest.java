package students.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import students.web.controller.ApplicantController;
import students.web.controller.ProfessionController;
import students.web.controller.SubjectController;

@ContextConfiguration(locations = {"/StudentExample.xml", "/StudentDatabase.xml", "/StudentController.xml"})
@TransactionConfiguration(transactionManager = "txManager")
public class StudentControllerTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ProfessionController profession;
    @Autowired
    private SubjectController subject;
    @Autowired
    private ApplicantController applicant;

    @Test
    public void professionTest() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.setMethod("GET");
        try {
            profession.handleRequest(req, new MockHttpServletResponse());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void subjectTest() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.setMethod("GET");
        try {
            subject.handleRequest(req, new MockHttpServletResponse());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void applicantTest() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        req.setMethod("GET");
        try {
            applicant.handleRequest(req, new MockHttpServletResponse());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }
}
