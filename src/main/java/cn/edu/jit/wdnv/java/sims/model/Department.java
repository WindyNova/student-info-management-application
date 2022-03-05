package cn.edu.jit.wdnv.java.sims.model;


public class Department {


    private String Dno;//系编号
    private String Dname;//系名

    public Department(String dno, String dname) {
        Dno = dno;
        Dname = dname;
    }

    public String getDno() {
        return Dno;
    }

    public void setDno(String dno) {
        Dno = dno;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }
}
