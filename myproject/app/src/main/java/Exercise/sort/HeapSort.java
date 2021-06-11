package Exercise.sort;

import Exercise.lists.IListable;

public class HeapSort<T> extends SortBase<T> {

    @Override
    public void sort(IListable<T> list, IComparator<T> comparator) {
        int n = list.size();

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i, comparator);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            swap(list, 0, i);

            // call max heapify on the reduced heap
            heapify(list, i, 0, comparator);
        }
    }

    private void heapify(IListable<T> list, int n, int i, IComparator<T> comparator) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && comparator.compare(list.get(l), list.get(largest)) > 0)
            largest = l;

        // If right child is larger than largest so far
        if (r < n &&  comparator.compare(list.get(r), list.get(largest)) > 0)
            largest = r;

        if (largest != i) {
            swap(list, i, largest);
            heapify(list, n, largest, comparator);
        }
    }
}
