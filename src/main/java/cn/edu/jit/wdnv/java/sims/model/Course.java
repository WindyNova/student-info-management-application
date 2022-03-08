package cn.edu.jit.wdnv.java.sims.model;

public class Course {
    private String cno;

    private String cname;

    private String cteacher;

    private Short ccredit;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCteacher() {
        return cteacher;
    }

    public void setCteacher(String cteacher) {
        this.cteacher = cteacher;
    }

    public Short getCcredit() {
        return ccredit;
    }

    public void setCcredit(Short ccredit) {
        this.ccredit = ccredit;
    }
}