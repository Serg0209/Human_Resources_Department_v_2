package students.dao;

import java.util.List;
import students.entity.Applicant;
import students.entity.ApplicantResult;

public class ApplicantResultDAOImpl extends BaseStudentDAO implements ApplicantResultDAO {

    public Long addApplicantResult(ApplicantResult ar) {
        return (Long)template.save(ar);
    }

    public void updateApplicantResult(ApplicantResult ar) {
        template.saveOrUpdate(ar);
    }

    public void deleteApplicantResult(ApplicantResult ar) {
        template.delete(ar);
    }

    public ApplicantResult getApplicantResult(Long applicantResultId) {
        return (ApplicantResult) template.load(ApplicantResult.class, applicantResultId);
    }

    public List<ApplicantResult> findApplicantResult(Applicant a) {
        return template.findByNamedParam("FROM ApplicantResult a WHERE a.applicant=:applicant " +
                "ORDER BY subject.subjectName", "applicant", a);
    }

}
