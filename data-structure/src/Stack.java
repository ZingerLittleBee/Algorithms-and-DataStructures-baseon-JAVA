/**
 * @Author: ye
 * @Date: 2021-01-17 15:47
 * @Description:
 */

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
