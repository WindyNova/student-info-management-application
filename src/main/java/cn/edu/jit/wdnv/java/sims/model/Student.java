package cn.edu.jit.wdnv.java.sims.model;

public class Student  {

    private String Sno;//学号
    private String Sname;//姓名
    private String Ssex;//性别
    private int Sage;//年龄
    private String Clno;//所在班级号

    public Student(String sno, String sname, String ssex, int sage, String clno) {
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Clno = clno;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
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

    public String getClno() {
        return Clno;
    }

    public void setClno(String clno) {
        this.Clno = clno;
    }


}
