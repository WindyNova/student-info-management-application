package cn.edu.jit.wdnv.java.sims.model;

/**
 * Table: sc
 */
public class SC {
    /**
     * Column: Sno
     * Type: CHAR(12)
     */
    private String sno;

    /**
     * Column: Cno
     * Type: CHAR(12)
     */
    private String cno;

    /**
     * Column: Grade
     * Type: SMALLINT
     */
    private Short grade;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }
}