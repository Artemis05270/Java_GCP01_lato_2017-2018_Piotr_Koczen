package ddsoft.comparators;

import ddsoft.crawler.Student;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
       return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
