package students.test;

import javax.naming.NamingException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

/**
 *
 * @author ASaburov
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    students.test.StudentFacadeTest.class,
    students.test.StudentControllerTest.class
})
public class StudentSuit {

    @BeforeClass
    public static void setUpClass() throws Exception {
        try {
            SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
            DriverManagerDataSource ds = new DriverManagerDataSource("jdbc:mysql://localhost:3306/db_applicant", "root", "root");
            ds.setDriverClassName("com.mysql.jdbc.Driver");
            builder.bind("java:comp/env/studentDS", ds);
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
            Assert.fail();
        } catch (NamingException ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }
}