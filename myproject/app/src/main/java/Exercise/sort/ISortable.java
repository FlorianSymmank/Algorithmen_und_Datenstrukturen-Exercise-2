package Exercise.sort;

import Exercise.lists.IListable;

public interface ISortable<T> {
    void sort(IListable<T> list, IComparator<T> comparator);
}