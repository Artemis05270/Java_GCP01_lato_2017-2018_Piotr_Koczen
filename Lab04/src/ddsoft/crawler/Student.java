package ddsoft.crawler;

public class Student
{

    private Double mark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (mark != null ? !mark.equals(student.mark) : student.mark != null) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        return age != null ? age.equals(student.age) : student.age == null;
    }

    @Override
    public int hashCode() {
        int result = mark != null ? mark.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    private String firstName;
    private String lastName;
    private Integer age;

    public Student(double mark, String firstName, String lastName, int age) {
        this.mark = new Double(mark);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = new Integer(age);
    }

    public Double getMark()
    {
        return this.mark;
    }

    public void setMark( double mark )
    {
        this.mark = new Double(mark);
    }
    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public Integer getAge()
    {
        return this.age;
    }

    public void setAge( int age )
    {
        this.age = new Integer(age);
    }



    @Override
    public String toString() {
        return  mark +
                " " + firstName  +
                " " + lastName +
                " " + age ;
    }
}

