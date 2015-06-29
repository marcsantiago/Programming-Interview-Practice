# -*- coding: utf-8 -*-
class SortingAlgorithms(object):
    def __init__(self, array):
        self.array = array

    def bubble_sort(self):
        # Bubble Sort Information:
        # Bubble Sort works by swapping two adjacent numbers, in this case lowest to highest
        # worst-case and average complexity both О(n2), where n is the number of elements in the list
        # bubble sort is not a practical sorting algorithm when n is large."""
        length_of_array = len(self.array)
        for i in xrange(length_of_array - 1, 0, -1):  # the length of the passed array - 1, counting down until 0
            for j in xrange(i):  # pass through the list as many times as the list is long
                # if the first indexed value is lower than the second index value swap,
                # change > to < for ascending order
                if self.array[j] > self.array[j + 1]:
                    swap = self.array[j]
                    self.array[j] = self.array[j + 1]
                    self.array[j + 1] = swap
        return self.array

    def selection_sort(self):
        # specifically an in-place comparison sort. It has O(n2) time complexity,
        # making it inefficient on large lists, and generally performs worse than the similar insertion sort.
        # The algorithm divides the input list into two parts:
        # the sub list of items already sorted, which is built up from left to right at the front (left) of the list,
        # and the sub list of items remaining to be sorted that occupy the rest of the list."""
        length_of_array = len(self.array)
        for i in xrange(length_of_array - 1):
            smallest = self.array[i]
            for j in xrange(i + 1, length_of_array):
                if self.array[j] < smallest:
                    smallest = self.array[j]
            if smallest != i:
                self.array[i] = smallest
        return self.array

    def insertion_sort(self):
        # Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one
        # item at a time. This gives insertion sort a quadratic running time (i.e., O(n2)).
        length_of_array = len(self.array)
        for i in xrange(1, length_of_array - 1):
            x = self.array[i]
            j = i
            while j > 0 and self.array[j - 1] > x:
                self.array[j] = self.array[j - 1]
                j -= 1
            self.array[j] = x

        return self.array

    def quick_sort(self):
        # Quick sort is a comparison sort, meaning that it can sort items of any type for which a
        # "less-than" relation.  on average, the algorithm takes O(n log n) comparisons to sort n items.
        # In the worst case, it makes O(n2) comparisons, though this behavior is rare.
        # Quick sort is a divide and conquer algorithm. Quick sort first divides a large array into two smaller
        # sub arrays: the low elements and the high elements. Quick sort can then recursively sort the sub-arrays."""
        pass


def main():
    test_list = [7, 6, 1, 4, 8, 2, 9]
    print SortingAlgorithms(test_list).bubble_sort()
    print SortingAlgorithms(test_list).selection_sort()
    print SortingAlgorithms(test_list).insertion_sort()


if __name__ == '__main__':
    main()




