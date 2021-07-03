/**
 * @Author: ye
 * @Date: 2020-12-13 22:55
 * @Description: 线性查找
 */
public class LinearSearch {
    public LinearSearch() {}
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        Integer[] arr = {13, 5, 67, 3, 6, 73, 63, 22};
//        int search = LinearSearch.search(arr, 3);
//        System.out.println(search);

        // 自定义类的线性查找
//        Student[] students = {
//                new Student("zs"),
//                new Student("ls")};
//        Student ls = new Student("ls");
//        int isSearch = LinearSearch.search(students, ls);
//        System.out.println(isSearch);

        // 自定义类的排序
        Student[] students = {
                new Student("zs", 90),
                new Student("ls", 88)};
        Student ls = new Student("ls", 99);
        SelectionSort.sort(students);
        for (Student student : students) {
            System.out.print(student + " ");
        }
    }
}
