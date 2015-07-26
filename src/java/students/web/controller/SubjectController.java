package students.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import students.facade.SubjectFacade;
import students.view.SubjectView;

public class SubjectController extends AbstractController {

    private SubjectFacade subjectFacade;

    public void setSubjectFacade(SubjectFacade subjectFacade) {
        this.subjectFacade = subjectFacade;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        List<SubjectView> l = subjectFacade.findSubject();
        Map<String,List<SubjectView>>  data = new HashMap<String,List<SubjectView>>();
        data.put("subjectList", l);
        return new ModelAndView("subject/subject", data);
    }

}
