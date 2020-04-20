package edu.umb.cs680.hw03;

enum StudentStatus{
    INSTATE, OUTSTATE, INTL
}

public class Student {
    private float tuition;
    private String name;
    private int i20num;
    private String usAddr;
    private int yrsInState;
    private String foreignAddr;
    private StudentStatus status;

    public Student(String name, String usAddr, int yrsInState, int i20num, String foreignAddr, StudentStatus status){
        this.name = name;
        this.usAddr = usAddr;
        this.foreignAddr = foreignAddr;
        this.i20num = i20num;
        this.yrsInState = yrsInState;
        this.status = status;
    }

    public static Student createInStateStudent(String name, String usAddr){
        return new Student(name,usAddr,0,0,null, StudentStatus.INSTATE);
    }

    public static Student createOutStateStudent(String name, String usAddr, int yrsInState){
        return new Student(name, usAddr, yrsInState, 0, null, StudentStatus.OUTSTATE);
    }

    public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr){
        return new Student(name, usAddr, 0, i20num, foreignAddr, StudentStatus.INTL);
    }

    public float getTuition(){
        return this.tuition;
    }

    public String getName(){
        return this.name;
    }

    public StudentStatus getStatus(){
        return this.status;
    }

    public int getI20num(){ return this.i20num; }

    public int getYrsInState() { return this.yrsInState; }

    public String getUsAddr() { return this.usAddr; }

    public String getForeignAddr() {return this.foreignAddr; }
}
