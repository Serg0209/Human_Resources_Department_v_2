package students.dao;

import java.util.List;
import students.entity.Applicant;
import students.entity.ApplicantResult;

public interface ApplicantResultDAO {

    public Long addApplicantResult(ApplicantResult ar);

    public void updateApplicantResult(ApplicantResult ar);

    public void deleteApplicantResult(ApplicantResult ar);

    public ApplicantResult getApplicantResult(Long applicantResultId);

    public List<ApplicantResult> findApplicantResult(Applicant a);
}
