package cn.edu.jit.wdnv.java.sims.model;


public class Course_fail_rate{

    private String Cno;//课程号
    private String Cname;//课程名称
    private String Cteacher;//执教老师
    private int Ccredit;//学分
    private double failRate;//不及格率

    public Course_fail_rate(String cno, String cname, String cteacher, int ccredit, double failRate) {
        Cno = cno;
        Cname = cname;
        Cteacher = cteacher;
        Ccredit = ccredit;
        this.failRate = failRate;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCteacher() {
        return Cteacher;
    }

    public void setCteacher(String cteacher) {
        Cteacher = cteacher;
    }

    public int getCcredit() {
        return Ccredit;
    }

    public void setCcredit(int ccredit) {
        Ccredit = ccredit;
    }

    public double getFailRate() {
        return failRate;
    }

    public void setFailRate(double failRate) {
        this.failRate = failRate;
    }
}
