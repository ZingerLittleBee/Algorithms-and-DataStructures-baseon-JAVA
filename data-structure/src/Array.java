/**
 * @Author: ye
 * @Date: 2020-12-29 23:51
 * @Description:
 */
public class Array<E> {
    private E[] data;
    private int size;

    // 有参构造函数，传入数组的 capacity 来构造数据
    public Array(int capacity) {
        // java 无法直接 new E[];
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参构造函数，默认 capacity 为10
    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在数组前端添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 在数组末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 向数组的索引位置添加元素
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. Required index >= 0 and index < size");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取索引位置的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    // 设置索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    // 查找数组中是否包含元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的位置，不存在则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除索引为index的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        E ret = get(index);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    // 删除数组中第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除数组中最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 如果元素存在，则删除
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void resize(int newCapacity) {
        E[] newArray = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.addFirst(10);
        System.out.println(array);
//
//        array.add(3, 99);
//        System.out.println(array);

        array.removeFirst();
        System.out.println(array);
//
//        array.removeLast();
//        System.out.println(array);
//
//        array.removeElement(99);
//        System.out.println(array);
//
//        array.remove(1);
//        System.out.println(array);

//        Array<Student> studentArray = new Array<>();
//        studentArray.addLast(new Student("tom", 88));
//        studentArray.addLast(new Student("aimi", 98));
//        studentArray.addLast(new Student("jock", 70));
//        System.out.println(studentArray);
//
//        studentArray.addFirst(new Student("jack", 99));
//        System.out.println(studentArray);
//
//        studentArray.remove(1);
//        System.out.println(studentArray);
//
//        System.out.println(studentArray.find(new Student("aimi", 98)));
    }
}
