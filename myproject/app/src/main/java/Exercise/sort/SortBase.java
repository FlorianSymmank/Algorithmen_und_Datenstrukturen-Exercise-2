package Exercise.sort;

import Exercise.lists.IListable;

import java.util.List;

public abstract class SortBase<T> implements ISortable<T>{
    protected void swap(IListable<T> list, int i, int j) {
        T memorizedObject = list.get(i);
        list.set(i, list.get(j));
        list.set(j, memorizedObject);
    }
}
