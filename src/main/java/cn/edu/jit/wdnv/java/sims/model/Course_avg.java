package cn.edu.jit.wdnv.java.sims.model;


public class Course_avg {

    private String Cno;//课程号
    private String Cname;//课程名称
    private String Cteacher;//执教老师
    private int Ccredit;//学分
    private double avg;//平均分

    public Course_avg(String cno, String cname, String cteacher, int ccredit, double avg) {
        Cno = cno;
        Cname = cname;
        Cteacher = cteacher;
        Ccredit = ccredit;
        this.avg = avg;
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

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
