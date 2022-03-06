package cn.edu.jit.wdnv.java.sims.model;


public class Course_fail_rate{

    private String Cno;//课程号
    private String Cname;//课程名称
    //private String Cteacher;//执教老师
    //private int Ccredit;//学分
    private double fail_rate;//不及格率

    public Course_fail_rate(String cno, String cname, double fail_rate) {
        Cno = cno;
        Cname = cname;
        this.fail_rate = fail_rate;
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

    public double getFail_rate() {
        return fail_rate;
    }

    public void setFail_rate(double fail_rate) {
        this.fail_rate = fail_rate;
    }

}
