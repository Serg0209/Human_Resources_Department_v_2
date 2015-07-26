package students.view;

import java.util.HashSet;
import java.util.Set;
import students.entity.Profession;
import students.entity.Subject;

public class ProfessionView {

    private Long professionId;
    private String professionName;
    private Set<SubjectView> subjectList;

    public ProfessionView() {
    }

    public ProfessionView(Profession p) {
        this(p, false);
    }

    public ProfessionView(Profession p, boolean full) {
        this.professionId = p.getProfessionId();
        this.professionName = p.getProfessionName();
        if (full) {
            subjectList = new HashSet<SubjectView>();
            Set<Subject> sList = p.getSubjectList();
            for (Subject s : sList) {
                subjectList.add(new SubjectView(s));
            }
        }
    }

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public Set<SubjectView> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Set<SubjectView> subjectList) {
        this.subjectList = subjectList;
    }
}
