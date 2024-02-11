public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Artem", 1, 14);
        Student student2 = new Student("Masha", 2, 15);
        Student student3 = new Student("Igor", 3, 45);
        Student student4 = new Student("Sasha", 4, 60);
        Student student5 = new Student("Dasha", 5, 13);

        Grade grade1 = new Grade(student1,"math",12.0);
        Grade grade2 = new Grade(student1,"math",15.0);
        Grade grade3 = new Grade(student1,"math",9.5);
        Grade grade4 = new Grade(student2,"math",10.0);
        Grade grade5 = new Grade(student2,"math",5.0);

        StudentManager studentManager = new StudentManager();
        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
        studentManager.addStudent(student3);
        studentManager.addStudent(student4);
        studentManager.addStudent(student5);
        studentManager.addGrade(grade1);
        studentManager.addGrade(grade2);
        studentManager.addGrade(grade3);
        studentManager.addGrade(grade4);
        studentManager.addGrade(grade5);

        System.out.println(studentManager.getAverageGrad(1));
        System.out.println(studentManager.getAverageGrad(2));
        studentManager.getAverageGrad(3);
        studentManager.getAverageGrad(12);
    }
}