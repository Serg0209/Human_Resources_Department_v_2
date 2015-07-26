package students.facade;

import students.view.ProfessionView;
import java.util.LinkedList;
import java.util.List;
import students.dao.ProfessionDAO;
import students.dao.SubjectDAO;
import students.entity.Profession;
import students.entity.Subject;
import students.view.SubjectView;

public class ProfessionFacade {

    private ProfessionDAO professionDAO;
    private SubjectDAO subjectDAO;

    public void setProfessionDAO(ProfessionDAO professionDAO) {
        this.professionDAO = professionDAO;
    }

    public void setSubjectDAO(SubjectDAO subjectDAO) {
        this.subjectDAO = subjectDAO;
    }

    public Long addProfession(ProfessionView pv) {
        pv.setProfessionId(null);
        Long id = professionDAO.addProfession(createProfessionFromView(pv));
        pv.setProfessionId(id);
        updateSubjectList(pv);
        return id;
    }

    public void updateProfession(ProfessionView pv) {
        professionDAO.updateProfession(createProfessionFromView(pv));
        updateSubjectList(pv);
    }

    private void updateSubjectList(ProfessionView pv) {
        if (pv.getSubjectList() != null) {
            List<Long> sList = new LinkedList<Long>();
            for (SubjectView sv : pv.getSubjectList()) {
                sList.add(sv.getSubjectId());
            }
            updateSubjectList(pv.getProfessionId(), sList);
        }
    }

    public void updateSubjectList(Long professionId, List<Long> sList) {
        Profession p = professionDAO.getProfession(professionId);
        List<Subject> subjList = subjectDAO.findSubjectById(sList);
        professionDAO.updateSubjectList(p, subjList);
    }

    public void deleteProfession(ProfessionView pv) {
        professionDAO.deleteProfession(professionDAO.getProfession(pv.getProfessionId()));
    }

    public ProfessionView getProfession(Long id) {
        return new ProfessionView(professionDAO.getProfession(id), true);
    }

    public List<ProfessionView> findProfession() {
        List<Profession> pList = professionDAO.findProfession();
        List<ProfessionView> pvList = new LinkedList<ProfessionView>();
        for (Profession p : pList) {
            pvList.add(new ProfessionView(p));
        }

        return pvList;
    }

    private Profession createProfessionFromView(ProfessionView pv) {
        Profession p = null;
        if (pv.getProfessionId() != null && pv.getProfessionId() > 0) {
            p = professionDAO.getProfession(pv.getProfessionId());
        } else {
            p = new Profession();
        }
        p.setProfessionName(pv.getProfessionName());

        return p;
    }
}
