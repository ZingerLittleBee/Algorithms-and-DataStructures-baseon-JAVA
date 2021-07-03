/**
 * @Author: ye
 * @Date: 2021-01-17 23:03
 * @Description:
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
