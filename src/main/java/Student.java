public class Student {
    //Create attributes for the student class.
    private String name;
    private String address;
    private double GPA;

    //Constructor
    public Student(String name, String address, double GPA){
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    //Getters
    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    public String getAddress() {
        return address;
    }

    //Setter for GPA to validate
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    //Override the toString method to print student details.
    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}
