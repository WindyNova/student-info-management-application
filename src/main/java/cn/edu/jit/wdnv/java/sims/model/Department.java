package cn.edu.jit.wdnv.java.sims.model;

/**
 * Table: department
 */
public class Department {
    /**
     * Column: Dno
     * Type: CHAR(12)
     */
    private String dno;

    /**
     * Column: Dname
     * Type: CHAR(12)
     */
    private String dname;

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}