public class StudentManager {
    private final int size_students = 10;
    private final int size_grades = 100;
    int len_students;
    int len_grades;
    Student[] students = new Student[size_students];
    Grade[] grades = new Grade[size_grades];
    public void addStudent(Student student){
        if (len_students < size_students) {
            students[len_students] = student;
            len_students++;
        }else {
            System.out.println("error, too many students");
        }
    }
    public void addGrade(Grade grade){
        if (len_grades < size_grades) {
            grades[len_grades] = grade;
            len_grades++;
        }else {
            System.out.println("error, too many grades");
        }
    }
    public double getAverageGrad (int id) {
        boolean studentFound = false;
        for (int i = 0; i < len_students; i++) {
            if (students[i].id == id) {
                studentFound = true;
                break;
            }
        }
        if (studentFound) {
            double sum = 0;
            int count = 0;
            for (int i = 0; i < len_grades; i++) {
                if (grades[i].student.id == id) {
                    sum += grades[i].grade;
                    count++;
                }
            }
            if (count == 0){
                System.out.println("error, student doesn`t have grades");
                return -1;
            }
            return (double) sum / count;
        }
        System.out.println("error, student is not found");
        return -1;
    }
}
