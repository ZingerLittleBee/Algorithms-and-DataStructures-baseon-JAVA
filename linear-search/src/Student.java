/**
 * @Author: ye
 * @Date: 2020-12-13 23:04
 * @Description:
 */
public class Student implements Comparable<Student>{
    private String name;
    private Integer score;

    Student(String name, Integer score) {
        this.name = name;
        this.score = score;
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

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
