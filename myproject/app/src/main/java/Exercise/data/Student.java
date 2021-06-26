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
            return o1.course.ordinal() - o2.course.ordinal();
        }
    };

    public final static IComparator<Student> MatriculationNumberComparator = new IComparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.matriculationNumber - o2.matriculationNumber;
        }
    };

    public enum Course {
        AI,
        BWL,
        CE,
        FM,
        ID;

        public static String getAllOptionsString() {
            String options = "";
            for (var value : Course.values())
                options += value.name() + "(" + value.ordinal() + ")" + ", ";
            return options.substring(0, options.length() - 2);
        }

        public static boolean isValidNumber(int n) {
            return n >= 0 && n < Course.values().length;
        }
    }

    private String prename;
    private String surname;
    private Course course;
    private int matriculationNumber;

    public Student(String prename, String surname, Course course, int matriculationNumber) {
        this.prename = prename;
        this.surname = surname;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }

    public Student() {
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
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
        return "Student {" +
                "prename='" + prename + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course.name() +
                ", matriculationNumber=" + matriculationNumber +
                '}';
    }
}