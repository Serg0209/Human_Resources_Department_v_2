package students.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import students.facade.ApplicantFacade;
import students.view.ApplicantView;

public class ApplicantController extends AbstractController {

    private ApplicantFacade applicantFacade;

    public void setApplicantFacade(ApplicantFacade applicantFacade) {
        this.applicantFacade = applicantFacade;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        List<ApplicantView> l = applicantFacade.findApplicant();
        Map<String,List<ApplicantView>>  data = new HashMap<String,List<ApplicantView>>();
        data.put("applicantList", l);
        return new ModelAndView("students/applicant", data);
    }
}
