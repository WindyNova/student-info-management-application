package cn.edu.jit.wdnv.java.sims.model;


public class Class {


    private String Clno;//班级编号
    private String Clname;//班级名称
    private String Dno;//所属院系

    public Class(String clno, String clname, String dno) {
        Clno = clno;
        Clname = clname;
        Dno = dno;
    }

    public String getClno() {
        return Clno;
    }

    public void setClno(String clno) {
        Clno = clno;
    }

    public String getClname() {
        return Clname;
    }

    public void setClname(String clname) {
        Clname = clname;
    }

    public String getDno() {
        return Dno;
    }

    public void setDno(String dno) {
        Dno = dno;
    }


}
