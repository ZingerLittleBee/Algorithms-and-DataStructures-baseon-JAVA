import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @Author: ye
 * @Date: 2020-12-20 00:10
 * @Description:
 */
public class SortingHelper {

    private SortingHelper() {}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        try {
            Class<?> sortClass = Class.forName(sortName);
            /*
                getMethod(String name, Class[] params): 获得类的特定方法,name参数指定方法的名字,params参数指定方法的参数类型
             */
            Method sortMethod = sortClass.getMethod("sort", Comparable[].class);
            /*
                invoke(对象的实例即在哪个实例上调用该方法, 方法的参数)
                如果获取到的Method表示一个静态方法，调用静态方法时，由于无需指定实例对象，所以invoke方法传入的第一个参数永远为null
             */
            sortMethod.invoke(null, new Object[]{arr});
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            if (!SortingHelper.isSorted(arr)) {
                throw new RuntimeException(sortName + " failed");
            }
            System.out.printf("%s, n = %d : %f s", sortName, arr.length, BigDecimal.valueOf(time));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Error in SortingHelper.sortTest!");
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 57, 76, 345, 77, 67, 8, 5, 65, 756};
        sortTest("SelectionSort", arr);
    }
}
