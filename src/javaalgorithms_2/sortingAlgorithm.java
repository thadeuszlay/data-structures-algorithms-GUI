/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms_2;

/**
 *
 * @author pad
 */
public enum sortingAlgorithm {
        noSortingAlgorithm (""),
        BubbleSort("Bubble Sort"),
        InsertionSort("Insertion Sort"),
        SelectSort("Select Sort"),
        BucketSort("Bucket Sort"),
        RadixSort("Radix Sort"),
        QuickSort("Quick Sort"),
        MergeSort("Merge Sort"),
        HeapSort("Heap Sort");
        
        private final String sortAlgo;
        
        sortingAlgorithm(String sortAlgo){
            this.sortAlgo=sortAlgo;
        }
        
        public String getSortAlgo(){
            return sortAlgo;
        }
}
