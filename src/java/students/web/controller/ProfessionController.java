package students.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import students.facade.ProfessionFacade;
import students.view.ProfessionView;

public class ProfessionController extends AbstractController {

    private ProfessionFacade professionFacade;

    public void setProfessionFacade(ProfessionFacade professionFacade) {
        this.professionFacade = professionFacade;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
        List<ProfessionView> l = professionFacade.findProfession();
        Map<String,List<ProfessionView>>  data = new HashMap<String,List<ProfessionView>>();
        data.put("professionList", l);
        return new ModelAndView("students/profession", data);
    }

}
