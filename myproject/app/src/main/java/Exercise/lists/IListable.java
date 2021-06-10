package Exercise.lists;

import java.util.function.Predicate;

public interface IListable<T> {
    void add(T data);
    void add(int index, T data);
    void addFirst(T data);
    void addLast(T data);
    T get(int index);
    void set (int index, T data);
    void remove(int index);
    void clear();
    int size();
    boolean isEmpty();
    IListable<T> filter(Predicate<T> predicate);
}
