package Exercise.sort;

import Exercise.lists.IListable;

public class SelectionSort<T> extends SortBase<T>{

    @Override
    public void sort(IListable<T> list, IComparator<T> comparator) {
        int minimum;
        for (int i = 0; i < list.size(); i++) {
            minimum = i;
            for (int e = i + 1; e < list.size(); e++) {
                if (comparator.compare(list.get(e), list.get(minimum)) < 0) { // Absteigend > Aufsteigend <
                    minimum = e;
                }
            }
            swap(list, i, minimum);
        }
    }
}
