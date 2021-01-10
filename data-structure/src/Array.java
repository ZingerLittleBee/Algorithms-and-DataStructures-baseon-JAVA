/**
 * @Author: ye
 * @Date: 2020-12-29 23:51
 * @Description:
 */
public class Array {
    private int[] data;
    private int size;

    // 有参构造函数，传入数组的 capacity 来构造数据
    public Array(int capacity) {
        data = new int[capacity];
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
    public void addFirst(int e) {
        add(0, e);
    }

    // 在数组末尾添加元素
    public void addLast(int e) {
        add(size, e);
    }

    // 向数组的索引位置添加元素
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("AddLast failed. Array is fulled");
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("AddLast failed. Required index >= 0 and index < size");
        }

        for (int i = size - 1; i >= index ; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取索引位置的元素
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    // 设置索引位置的元素
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    // 查找数组中是否包含元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的位置，不存在则返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除索引为index的元素，返回删除的元素
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        int ret = get(index);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return ret;
    }

    // 删除数组中第一个元素
    public int removeFirst() {
        return remove(0);
    }

    // 删除数组中最后一个元素
    public int removeLast() {
        return remove(size - 1);
    }

    // 如果元素存在，则删除
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
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
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.addFirst(10);
        System.out.println(array);

        array.add(3, 99);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeElement(99);
        System.out.println(array);

        array.remove(1);
        System.out.println(array);
    }
}