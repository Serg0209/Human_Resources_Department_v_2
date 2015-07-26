package students.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profession")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profession_id")
    private Long professionId;
    @Column(name = "profession_name")
    private String professionName;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "SPECIALITY_SUBJECT",
    joinColumns = @JoinColumn(name = "PROFESSION_ID"),
    inverseJoinColumns = @JoinColumn(name = "SUBJECT_ID"))
    private Set<Subject> subjectList = new HashSet<Subject>();

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

    public Set<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Set<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
