package cn.edu.jit.wdnv.java.sims.model;

/**
 * Table: student
 */
public class Student {
    /**
     * Column: Sno
     * Type: CHAR(12)
     */
    private String sno;

    /**
     * Column: Sname
     * Type: CHAR(8)
     */
    private String sname;

    /**
     * Column: Ssex
     * Type: CHAR(2)
     */
    private String ssex;

    /**
     * Column: Sage
     * Type: SMALLINT
     */
    private Short sage;

    /**
     * Column: Clno
     * Type: CHAR(12)
     */
    private String clno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Short getSage() {
        return sage;
    }

    public void setSage(Short sage) {
        this.sage = sage;
    }

    public String getClno() {
        return clno;
    }

    public void setClno(String clno) {
        this.clno = clno;
    }
}