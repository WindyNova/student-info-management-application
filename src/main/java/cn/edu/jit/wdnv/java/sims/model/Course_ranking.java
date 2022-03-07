package cn.edu.jit.wdnv.java.sims.model;

public class Course_ranking {

    private String Sno;//学号
    private String Dname;//系名
    private String Clname;//班名
    private String Sname;//学生姓名
    private String Ssex;//学生性别
    private int Sage;//学生年龄
    private Double Grade;//成绩

    public Course_ranking(String sno, String dname, String clname, String sname, String ssex, int sage, Double grade) {
        Sno = sno;
        Dname = dname;
        Clname = clname;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Grade = grade;
    }

    public Course_ranking(String sno, String dname, String clname, String sname, String ssex, int sage, Double grade) {
        Sno = sno;
        Dname = dname;
        Clname = clname;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        this.grade = grade;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getClname() {
        return Clname;
    }

    public void setClname(String clname) {
        Clname = clname;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public Double getGrade() {
        return Grade;
    }

    public void setGrade(Double grade) {
        Grade = grade;
    }
}
