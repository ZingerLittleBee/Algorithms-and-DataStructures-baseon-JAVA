/**
 * @Author: ye
 * @Date: 2020-12-13 22:55
 * @Description:
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
        Integer[] arr = {13, 5, 67, 3, 6, 73, 63, 22};
        int search = LinearSearch.search(arr, 3);
        System.out.println(search);
    }

}
