package students.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseStudentDAO {

    protected HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return template;
    }

    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }
}
