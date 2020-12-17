/**
 * @Author: ye
 * @Date: 2020-12-13 23:04
 * @Description:
 */
public class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Student temp = (Student) obj;
        return name.toLowerCase().equals(temp.name.toLowerCase());
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("zs"),
                new Student("ls")};
        Student ls = new Student("ls");
        int isSearch = LinearSearch.search(students, ls);
        System.out.println(isSearch);
    }
}
