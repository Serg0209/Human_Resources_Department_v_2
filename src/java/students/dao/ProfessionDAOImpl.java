package students.dao;

import java.util.List;
import students.entity.Profession;
import students.entity.Subject;

public class ProfessionDAOImpl extends BaseStudentDAO implements ProfessionDAO {

    public Long addProfession(Profession p) {
        return (Long) template.save(p);
    }

    public void updateProfession(Profession p) {
        template.saveOrUpdate(p);
    }

    public void updateSubjectList(Profession p, List<Subject> sList) {
        p.getSubjectList().clear();
        p.getSubjectList().addAll(sList);
    }

    public void deleteProfession(Profession p) {
        template.delete(p);
    }

    public Profession getProfession(Long professionId) {
        return (Profession) template.load(Profession.class, professionId);
    }

    public List<Profession> findProfession() {
        return template.find("FROM Profession ORDER BY professionName");
    }
}
