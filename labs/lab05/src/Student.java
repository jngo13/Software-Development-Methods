
public class Student extends Person {

    private String campusAddress;
    private double gpa;
    
    public Student() {
        super();
        gpa = 0.0;
        campusAddress = "";
    }
    
    public Student(String n, String ha, String ca, double gp) {
        super(n,ha);
        gpa = gp;
        campusAddress = ca;
    }
}
