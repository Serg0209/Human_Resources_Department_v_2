package students.facade;

import java.util.LinkedList;
import java.util.List;
import students.dao.ApplicantDAO;
import students.dao.ProfessionDAO;
import students.entity.Applicant;
import students.entity.ApplicantResult;
import students.view.ApplicantResultView;
import students.view.ApplicantView;

public class ApplicantFacade {

    private ApplicantDAO applicantDAO;
    private ProfessionDAO professionDAO;
    private ApplicantResultFacade applicantResultFacade;

    public void setApplicantDAO(ApplicantDAO applicantDAO) {
        this.applicantDAO = applicantDAO;
    }

    public void setProfessionDAO(ProfessionDAO professionDAO) {
        this.professionDAO = professionDAO;
    }

    public void setApplicantResultFacade(ApplicantResultFacade applicantResultFacade) {
        this.applicantResultFacade = applicantResultFacade;
    }

    public Long addApplicant(ApplicantView av) {
        av.setApplicantId(null);
        return applicantDAO.addApplicant(createApplicantFromView(av));
    }

    public void updateApplicant(ApplicantView av) {
        applicantDAO.updateApplicant(createApplicantFromView(av));
    }

    public void updateApplicantResult(ApplicantView av) {
        Applicant a = applicantDAO.getApplicant(av.getApplicantId());
        if (av.getApplicantResultList() != null) {
            List<ApplicantResult> arList = new LinkedList<ApplicantResult>();
            for(ApplicantResultView arv : av.getApplicantResultList()) {
                arList.add(applicantResultFacade.createApplicantResultFromView(arv));
            }
            a.setApplicantResultList(arList);
        }
    }

    public void deleteApplicant(ApplicantView av) {
        applicantDAO.deleteApplicant(applicantDAO.getApplicant(av.getApplicantId()));
    }

    public ApplicantView getApplicant(Long id) {
        return new ApplicantView(applicantDAO.getApplicant(id), true);
    }

    public List<ApplicantView> findApplicant() {
        List<ApplicantView> pvList = new LinkedList<ApplicantView>();
        List<Applicant> aList = applicantDAO.findApplicant();
        for (Applicant a : aList) {
            pvList.add(new ApplicantView(a));
        }
        return pvList;
    }

    private Applicant createApplicantFromView(ApplicantView av) {
        Applicant a = null;
        if (av.getApplicantId() != null && av.getApplicantId() > 0) {
            a = applicantDAO.getApplicant(av.getApplicantId());
        } else {
            a = new Applicant();
            a.setApplicantResultList(new LinkedList<ApplicantResult>());
        }
        a.setFirstName(av.getFirstName());
        a.setLastName(av.getLastName());
        a.setMiddleName(av.getMiddleName());
        a.setEntranceYear(av.getEntranceYear());
        a.setProfession(professionDAO.getProfession(av.getProfessionId()));

        return a;
    }
}
