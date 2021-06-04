package Exercise.data;

import Exercise.sort.IComparator;

public class Student {

    public final static IComparator<Student> PrenameComparator = new IComparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.prename == null && o2.prename == null) {
                return 0;
            } else if (o1.prename == null) {
                return 1;
            } else if (o2.prename == null) {
                return -1;
            }
            return o1.prename.compareTo(o2.prename);
        }
    };

    public final static IComparator<Student> SurnameComparator = new IComparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.surname == null && o2.surname == null) {
                return 0;
            } else if (o1.surname == null) {
                return 1;
            } else if (o2.surname == null) {
                return -1;
            }
            return o1.surname.compareTo(o2.surname);
        }
    };

    public final static IComparator<Student> CourseComparator = new IComparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.course - o2.course;
        }
    };

    public final static IComparator<Student> MatriculationNumberComparator = new IComparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.matriculationNumber - o2.matriculationNumber;
        }
    };

    private String prename;
    private String surname;
    private int course;
    private int matriculationNumber;

    public Student(String prename, String surname, int course, int matriculationNumber) {
        this.prename = prename;
        this.surname = surname;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "prename='" + prename + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                ", matriculationNumber=" + matriculationNumber +
                '}';
    }
}
