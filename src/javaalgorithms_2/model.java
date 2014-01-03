/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaalgorithms_2;

import java.awt.List;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author pad
 */
public class model {
    
    private String arrayType="";
    private int arraySize;
    private String filledNumbers="";
    private String sortingAlgorithm="";
    private String output="";
    private String[]  columnNames= {"Index","Content"};
    private int numberOfDigit=0;
    private interactiveTableModel myModel=new interactiveTableModel(columnNames);
    
    /**
     * @return the arrayType
     */
    public String getArrayType() {
        return arrayType;
    }

    /**
     * @param arrayType the arrayType to set
     */
    public void setArrayType(String arrayType) {
        this.arrayType = arrayType;
    }
    
    /**
     * @return the arraySize
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * @param arraySize the arraySize to set
     */
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
    
    
    /**
     * @return the filledNumbers
     */
    public String getFilledNumbers() {
        return filledNumbers;
    }

    /**
     * @param filledNumbers the filledNumbers to set
     */
    public void setFilledNumbers(String filledNumbers) {
        this.filledNumbers = filledNumbers;
    }
    
    /**
     * @return the sortingAlgorithm
     */
    public String getSortingAlgorithm() {
        return sortingAlgorithm;
    }

    /**
     * @param sortingAlgorithm the sortingAlgorithm to set
     */
    public void setSortingAlgorithm(String sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }
    
    
    
    public void initArray(int sizeArray){
        for (int i=0; i<sizeArray; i++){
            //theView.addRow(String.valueOf(i), value);
            myModel.addDataSet(String.valueOf(i), "");
        }
    }
    
    public void addRow(String index, String value){
        myModel.addDataSet(index, value);
    }
//------------------------------------------------------------------------  
    
/*
 * Big O Notation - is a mathematical 
 * Measurement of efficiency. Mathematical representation. 
 * Number of steps needed for an algorithm to complete processing
 * 
*/
    /*
     * Goes through the unsorted list from left to right. 
     * Compares two neighboring elements. If the left member is bigger than the
     * right one, then it switches their position. It will repeat this until it
     * reaches the end. Then it wll starts from the beginning and repeats the
     * mentioned procedure. But this time it will not go to the end of the whole
     * list, because the last element is already the biggest element.
     * 
     * O(n^2)
     */
    public void bubbleSort(){
        output="";
        //getVector
        for (int i=arraySize-1; i>=0; i--){
            for (int j=0; j<i; j++){
                
                System.out.println("i("+i+")--> j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1));
                output+="\ni("+i+")--> j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1);
                if ( Integer.valueOf((String) myModel.getValueAt(j, 1)) > Integer.valueOf((String) myModel.getValueAt(j+1,1))){
                    swap(j,j+1);
                    System.out.println("SWAP! New position: j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1));
                    output+= "\nSWAP! New position: j("+j+"): "+(String) myModel.getValueAt(j, 1)+" -> j+1("+(j+1)+"): "+(String) myModel.getValueAt(j+1, 1);
                }
            }
        }
    }
    
    /*
     Selection sort goes through the unsorted list and selects the 
     * smallest member of the unsorted list and puts it at the end of
     * the sorted list. After that it repeats the process: It selects the smallest
     * member out of the unsorted list and append this member at the sorted list 
     * of the first smallest member that he found. The algorithm repeats this 
     * process until there are no members to be found in the unsorted list but
     * all of them are in the sorted list.
     * 
     * This algorithm is not very efficient but very easy to implement.
     * 
     * O(n^2)
     */
    public void selectionSort(){
        for (int i=0; i<arraySize; i++){
            int indexOfMinValue=i;
            for (int j=i; j<arraySize; j++){
                System.out.println("i("+i+")--> j("+j+"): "+(String) myModel.getValueAt(j, 1));
                if (Integer.valueOf((String) myModel.getValueAt(j, 1)) < Integer.valueOf((String) myModel.getValueAt(indexOfMinValue,1))){
                    indexOfMinValue=j;
                }
            }
            if (indexOfMinValue!=i)
                swap(i, indexOfMinValue);
                System.out.println("SWAP! New position: j("+i+"): "+(String) myModel.getValueAt(i, 1)+" -> j+1("+indexOfMinValue+"): "+(String) myModel.getValueAt(indexOfMinValue, 1));
        }
    }
    
    /*
     Insertion sort takes the first member of the unsorted list and 
     * goes through the sorted list from it's last member step by step.
     * At each step it checks whether the selected member of the unsorted list 
     * is smaller than the selected member in the sorted list.
     * If it is, it puts it right after the 
     * first element that is smaller than him. Then it takes the next element
     * in the unsorted list and again compares it with the members of the 
     * unsorted list until it finds a value that is smaller than the one
     * that is selected from the sorted list.
     * Because the Insertion sort checks the first member
     * of the unsorted list it finishes when it has reached the end of the
     * unsorted list.
     * <-sorted list-><--unsorted list-->
     * 
     * O(n^2)
     */
    public void insertionSort(){
        // you start with the 2nd index (i.e. index number "1")
        for (int i=1; i<arraySize; i++){
            //get the first one of the sorted list and compare it to the member
            //at the end of the sorted list.  
            //int j=i;
            int j=i;
            String firstMemberInUnsortedList=(String) myModel.getValueAt(j, 1);

            while(j>0 && Integer.valueOf((String) myModel.getValueAt(j-1, 1)) > Integer.valueOf(firstMemberInUnsortedList)){
                //replace the member in j-1 with it's descendend in j
                myModel.setValueAt(myModel.getValueAt(j-1, 1), j, 1);
                j--;
                printOutArray();
            }   
            myModel.setValueAt(firstMemberInUnsortedList, j, 1);
            output+="\n----------end while----------------";
            printOutArray();
        }
    }
    
    /*
     * The Bucket sorting algorithm is not really a sorting algorithm. Instead
     * it's rather a prozcess to improve sorting efficiency and is Usually used 
     * in conjuction with another sorting algorithm, like insertion sort.
     * 
     * 1. In cojunction with other sorting algorithms:
     * The aim is to apply a sorting algorithm not to an entire list but
     * to smaller lists. That's why in Bucket sort the elements in the big list
     * are put into to smaller consecutive lists. E.g. if the list contains 
     * numbers that ranges from 0 to 10, then there will be several
     * smaller lists (=buckets) let's say 3. Then the first bucket can hold
     * numbers from 0 to 3. The second bucket from 4 to 6. And the third 
     * 7 to 10 buckets.
     * Now, within each of this list one of the aforementioned sorting algortihm, 
     * e.g. selction sort or insertion sort can be applied to sort the the elements
     * within the buckets. 
     * After that all of buckets are merged into a big list again.
     * 
     * 2. Bucket sort alone:
     * With Bucket sort alone you create for a large list smaller lists 
     * - exactly the same as in the example above. After that you again create 
     * smaller buckets within each buckets, until there's only one element in this
     * bucket. These created buckets are set in order already, so when there's only 
     * one element in the bucket, you merge the buckets into a large list and get
     * a list that is sorted.
     * 
     * This technique reqires recursion which in turn is costly in terms of 
     * ressources and time.
     * 
     * O(n^2)
     */
    public void bucketSort_insertionSort(){
        output+="\nBucket + Insertion Sort";
        ArrayList<String> bucket_0to2 = new ArrayList<String>();
        ArrayList<String> bucket_3to5 = new ArrayList<String>();
        ArrayList<String> bucket_6to8 = new ArrayList<String>();
        ArrayList<String> bucket_9to11 = new ArrayList<String>(); 
    
        System.out.println("starts");
        for (int i=0; i<myModel.getRowCount(); i++){
            int item=Integer.valueOf((String) myModel.getValueAt(i, 1))/3;

            switch(item){
                case 0:
                    System.out.println("0-2: "+myModel.getValueAt(i, 1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 0-2";
                    bucket_0to2.add((String) myModel.getValueAt(i, 1));
                    break;
                case 1:
                    System.out.println("3-5: "+myModel.getValueAt(i, 1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 3-5";
                    bucket_3to5.add((String) myModel.getValueAt(i, 1));
                    break;
                case 2:
                    System.out.println("6-8: "+myModel.getValueAt(i, 1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 6-8";
                    bucket_6to8.add((String) myModel.getValueAt(i, 1));
                    break;
                case 3:
                    System.out.println("9-11: "+myModel.getValueAt(i, 1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 9-11";                    
                    bucket_9to11.add((String) myModel.getValueAt(i, 1));
                    break;
                default:
                    break;
            }
        }
        
        System.err.println("end");
        
        /*
        String[] bucket_0to2_s;
        String[] bucket_3to5_s;
        String[] bucket_6to8_s;
        String[] bucket_9to11_s;
                
        //sort arrays
        bucket_0to2_s = insertionSort(bucket_0to2).toArray(new String[bucket_0to2.size()]);
        bucket_3to5_s = insertionSort(bucket_3to5).toArray(new String[bucket_3to5.size()]);
        bucket_6to8_s = insertionSort(bucket_6to8).toArray(new String[bucket_6to8.size()]);
        bucket_9to11_s = insertionSort(bucket_9to11).toArray(new String[bucket_9to11.size()]);
        */
        bucket_0to2 = insertionSort(bucket_0to2);
        bucket_3to5 = insertionSort(bucket_3to5);
        bucket_6to8 = insertionSort(bucket_6to8);
        bucket_9to11 = insertionSort(bucket_9to11);
        
        //merge the (now sorted) buckets into myModel:
        //save the merge buckets in interim ArrayList
        ArrayList<String> bucket_sorted = new ArrayList<String>();
        bucket_sorted.addAll(bucket_0to2);
        bucket_sorted.addAll(bucket_3to5);
        bucket_sorted.addAll(bucket_6to8);
        bucket_sorted.addAll(bucket_9to11);
        
        String[] bucket_sorted_array=bucket_sorted.toArray(new String[bucket_sorted.size()]);
        
        
        
        //transfer interim array to myModel via loop
/*        for (int m=0; m<bucket_sorted.size(); m++){
            myModel.setValueAt(bucket_sorted.get(m), m, 1);
        }      */
        merge(bucket_sorted_array);
    }

    public ArrayList<String> insertionSort(ArrayList<String> arr){
        int arrSize=arr.size();

        // you start with the 2nd index (i.e. index number "1")
        for (int i=1; i<arrSize; i++){
            //get the first one of the sorted list and compare it to the member
            //at the end of the sorted list.  
            //int j=i;
            int j=i;
            String firstMemberInUnsortedList=arr.get(j);

            while(j>0 && Integer.valueOf(arr.get(j-1)) > Integer.valueOf(firstMemberInUnsortedList)){
                //replace the member in j-1 with it's descendend in j
                arr.set(j, arr.get(j-1));
                j--;
            }   
            arr.set(j, firstMemberInUnsortedList);
        }
        return arr;
    }
    
    private void merge(String... args){
        
        int m=0;
        for(String arg: args){
            myModel.setValueAt(arg, m, 1);
            m++;
        }
    }
    
    private ArrayList<String> tableModelIntoArrayList(){
        ArrayList<String> a=new ArrayList<String>();
        for (int i=0; i<myModel.getRowCount(); i++){
            a.add((String)myModel.getValueAt(i,1));
        }
        
        return a;
    }
    
    public void bucketSort(){
        output+="\nBucket Sort";
        ArrayList<String> bucket_0 = new ArrayList<String>();
        ArrayList<String> bucket_1 = new ArrayList<String>();
        ArrayList<String> bucket_2 = new ArrayList<String>();
        ArrayList<String> bucket_3 = new ArrayList<String>(); 
        ArrayList<String> bucket_4 = new ArrayList<String>();
        ArrayList<String> bucket_5 = new ArrayList<String>();
        ArrayList<String> bucket_6 = new ArrayList<String>();
        ArrayList<String> bucket_7 = new ArrayList<String>(); 
        ArrayList<String> bucket_8 = new ArrayList<String>();
        ArrayList<String> bucket_9 = new ArrayList<String>();
        
        for (int i=0; i<myModel.getRowCount(); i++){            
            switch(Integer.valueOf((String)myModel.getValueAt(i, 1))){
                case 0:
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 0";
                    bucket_0.add((String) myModel.getValueAt(i, 1));
                    break;
                case 1:
                    bucket_1.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 1";                    
                    break;
                case 2:
                    bucket_2.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 2";                    
                    
                    break;
                case 3:
                    bucket_3.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 3";                    
                    
                    break;
                case 4:
                    bucket_4.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 4";                    
                    
                    break;
                case 5:
                    bucket_5.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 5";                    
                    
                    break;
                case 6:
                    bucket_6.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 6";                    
                    
                    break;
                case 7:
                    bucket_7.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 7";                    
                    
                    break;
                case 8:
                    bucket_8.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 8";                    
                    
                    break;
                case 9:
                    bucket_9.add((String) myModel.getValueAt(i,1));
                    output+="\n"+i+"\t| "+myModel.getValueAt(i, 1) +"\t<-- will be transferred into bucket 9";                    
                    
                    break;
                default:
                    break;
            }
        }     
        
        ArrayList<String> bucket_sorted = new ArrayList<String>();
        bucket_sorted.addAll(bucket_0);
        bucket_sorted.addAll(bucket_1);
        bucket_sorted.addAll(bucket_2);
        bucket_sorted.addAll(bucket_3);
        bucket_sorted.addAll(bucket_4);
        bucket_sorted.addAll(bucket_5);
        bucket_sorted.addAll(bucket_6);
        bucket_sorted.addAll(bucket_7);
        bucket_sorted.addAll(bucket_8);
        bucket_sorted.addAll(bucket_9);
        
        String[] bucket_sorted_array=bucket_sorted.toArray(new String[bucket_sorted.size()]);
        
        merge(bucket_sorted_array);
    }
    
    /*The Radix Sort is most efficient for larger arrays. 
     * It is done for non-comparitive integer sorting algortihm.
     * There are two ways of doing it: 
     * 
     * Least Significan Digit (LSD), Most Significant Digit (MSD). This only means
     * where to start sorting. LSD means in this context that we start with the
     * far right digit. E.g. the far right digit of number 123 is the position where
     * number 3 is. MSD means we start at the position where number 1 is.
     * 
     * In the following example the focus is on LSD.
     * We have 10 buckets. Each carries one of the values from 0 to 9. We will go through the list from 
     * left to right. Given we have 3 digit numbers, then we first look at the value of the
     * number's first digit (since it's LSD) and put these numbers in the buckets 
     * with the same value.
     * E.g. The number 123 has got 3 as a first digit will be put into a bucket
     * with the value 3. The number 456 has got 6 as a first digit and will be put
     * into bucket 6 and so on.
     * According to this first sort we get a new order of our list.
     * In the next step we will look at the value of the number's second digit and 
     * put them in to the buckets with the same value.
     * E.g. the number 123 has got 2 as the second digt and will be put into 
     * the bucket with the value 2. The number 456 has 5 as the second digit and
     * will be put into bucket 5 and so on.
     * After that we get a list that again has a reordered. But we aren't done yet.
     * In the third and last step (it's the last step because we agreed on having
     * 3 digit numbers), we look at the 3rd digit of the numbers and will put them
     * into the according bucket. Now after this step we get a list that is finally
     * ordered.
     * 
     * O(k*n)
     */
    
    // returns a radix sorted list
     private ArrayList<String> SortRadix(int digit, ArrayList<String> arr){
     
         ArrayList<String> bucket_sorted = new ArrayList<String>();
            
         if (digit==0)
            return arr;
         else{
            ArrayList<String> bucket_0 = new ArrayList<String>();
            ArrayList<String> bucket_1 = new ArrayList<String>();
            ArrayList<String> bucket_2 = new ArrayList<String>();
            ArrayList<String> bucket_3 = new ArrayList<String>(); 
            ArrayList<String> bucket_4 = new ArrayList<String>();
            ArrayList<String> bucket_5 = new ArrayList<String>();
            ArrayList<String> bucket_6 = new ArrayList<String>();
            ArrayList<String> bucket_7 = new ArrayList<String>(); 
            ArrayList<String> bucket_8 = new ArrayList<String>();
            ArrayList<String> bucket_9 = new ArrayList<String>();

            
            // goes throught the transferred array "arr" 
            // and checks all of it's members
            for (int i=0; i<arr.size(); i++){

                //"radix" contains the digits of the current number 
                String[] radix=(arr.get(i).split(""));
                System.out.println("String--> "+arr.get(i));
                System.out.println("lenght--> "+(radix.length-1));
                int digi=numberOfDigit!=radix.length-1?digit-(numberOfDigit-(radix.length-1)):digit;
                
                String nthDigit;
                try{
                    nthDigit=radix[digi].equals("")?"0": String.valueOf(radix[digi]);
                }catch(Exception ex){
                    nthDigit="0";
                }
                
                System.out.println("Into bucket "+nthDigit);
                //check the nth Digit
                switch(nthDigit){
                    //transfer it into the table
                    case "":
                    case "0":
                        bucket_0.add(arr.get(i));
                        break;
                    case "1":
                        bucket_1.add(arr.get(i));
                        break;
                    case "2":
                        bucket_2.add(arr.get(i));
                        break;
                    case "3":
                        bucket_3.add(arr.get(i));
                        break;
                    case "4":
                        bucket_4.add(arr.get(i));
                        break;
                    case "5":
                        bucket_5.add(arr.get(i));
                        break;
                    case "6":
                        bucket_6.add(arr.get(i));
                        break;
                    case "7":
                        bucket_7.add(arr.get(i));
                        break;
                    case "8":
                        bucket_8.add(arr.get(i));
                        break;
                    case "9":
                        bucket_9.add(arr.get(i));
                        break;
                    default:
                        System.out.println("case doesn't exist");
                                
                        break;
                }
            }
            //merge into one array, which is "bucket_sorted"
            bucket_sorted.addAll(bucket_0);
            bucket_sorted.addAll(bucket_1);
            bucket_sorted.addAll(bucket_2);
            bucket_sorted.addAll(bucket_3);
            bucket_sorted.addAll(bucket_4);
            bucket_sorted.addAll(bucket_5);
            bucket_sorted.addAll(bucket_6);
            bucket_sorted.addAll(bucket_7);
            bucket_sorted.addAll(bucket_8);
            bucket_sorted.addAll(bucket_9);
            System.out.println("-----------"+digit+"-------------------");
            return SortRadix(digit-1, bucket_sorted);
         }
     }
     
    public void radixSort(){
        
        numberOfDigit=3;
        //translate tableModel into array
        String[] bucket_sorted_array=(SortRadix(numberOfDigit, tableModelIntoArrayList())).toArray(new String[myModel.getRowCount()]);
        
        //merge array into table model
        merge(bucket_sorted_array);        
    }
    
    /*In Quicksort you select one element in the list and partion the list into
     * two sets: One that only conains slements that are larger than the 
     * selected element, also called 'pivot', and one that only contains 
     * elements smaller than the pivot. In order to do so, we start with a two 
     * pointers: 
     * One at the very beginning and one at the very end of the list. 
     * We move the pointer at the beginning one step up to the other end 
     * until it reaches a value that is larger than or equal the pivot. 
     * Then we move the pointer at the end one step down to the other end 
     * until it reaches a value that is smaller than or equal the pivot. 
     * When we have on the left side a value that is larger than or equal the 
     * pivot, and on the right side a value that is smaller than or equal the
     * pivot swap the position of these elements. Then we select another element
     * that is larger than or equal resp. smaller than and equal the pivot and
     * swap position. This process will be repeated until both pointers will 
     * point to the same element - the pivot. 
     * At this point the pivot is in the correct position, Now, we have two sets:
     * One that contains elements smaller than the pivot and one that
     * contains elements that that are larger than the pivot. These two steps
     * will be partioned like we did with the orignal list, until we get lists
     * that are either containing zero or one element and are therefor sorted.
     * In the last step these list, with only one (or zero) elements are rejoined
     * into one big list containing sorted elements.
     * 
     *Average: O(n log n)
     * Worst case: O(n^2)
     */
    public void quickSort(){
        
    }
    
    /*Merge sort uses a similar concept to bucket sort. The big unsorted list 
     * is divided into list containining only one item. Then you compare the 
     * elements within these two lists and put it in another list. The element
     * that is smaller will be put into the new list first. The larger element,
     * will be put in second. You repeat the process for all other single element
     * lists. Now, you don't have lists containing single elements but lists
     * containing two elements (because the aforementioned list contained only
     * one element) that are ordered. 
     * These lists are now compared to each other in a similar manner: 
     * First you select two list. In this two lists, then you select the first 
     * element of each of these lists and compare them to each other. 
     * The one that's smaller will be put in first into a new list. 
     * Then in the list that the item was just put into the new list, we select the 
     * next element and compare it with the currently selected element in the 
     * other list. Again we compare both elements and put it into the new list.
     * We repeat this process until we only got one big list of sorted elements.
     * 
     * Merge sort treats each equally and uses divide and conquer.
     * O(n log n) for best, average and worst case
     */
    public void mergeSort(){
        
    }

    /*first we have to order the unsorted list into a heap. 
     * Parent x==> child1: 2x+1; child2: 2x+2
     * Child y==> parent: (y-1)/2
     * The Heap has by definition the largest number as a root.
     * So, in order to sort our list, we put the root element into the last place 
     * of the list. After that a new root has to be selected. We want the last Heap
     * element to be the root. of course we have to check whether this suffice 
     * the definition of a heap, because the heap has to be the largest element.
     * If it is not, then we will swap it with the largest child until the heap
     * becomes consistent.
     * From there we now have the largest element of the remaining list as a root.
     * This element we will put into the next to last part. We will repeat
     * this until all the heap doesn't contain any elements.
     * 
     * 
     */
    public void heapSort(){
        
    }

//------------------------------------------------------------------------
    private void swap(int iAscend, int iDescend){
        int interimValue=Integer.valueOf((String)myModel.getValueAt(iAscend, 1));
        myModel.setValueAt(myModel.getValueAt(iDescend, 1), iAscend, 1);
        myModel.setValueAt(interimValue, iDescend, 1);
        System.out.println("SWAP! New position: j("+iAscend+"): "+(String) myModel.getValueAt(iAscend, 1)+" -> j+1("+iDescend+"): "+(String) myModel.getValueAt(iDescend, 1));
        output+="\nSWAP! New position: j("+iAscend+"): "+(String) myModel.getValueAt(iAscend, 1)+" -> j+1("+iDescend+"): "+(String) myModel.getValueAt(iDescend, 1);
        //setMyModel(myModel);
    }
    
    public void printOutArray(){
        for (int i=0; i<arraySize; i++){
            System.out.println(i+" | "+(String) myModel.getValueAt(i, 1));
            output+="\n"+i+" | "+(String) myModel.getValueAt(i, 1);
        }

    }
    
    public void deleteTable(){
        myModel.deleteAllRow();
    }
    /**
     * @return the myModel
     */
    public interactiveTableModel getMyModel() {
        return myModel;
    }

    /**
     * @param myModel the myModel to set
     */
    public void setMyModel(interactiveTableModel myModel) {
        this.myModel = myModel;
    }

    /**
     * @return the columnNames
     */
    public String[] getColumnNames() {
        return columnNames;
    }

    /**
     * @param columnNames the columnNames to set
     */
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
    
    void addPrintOutput(ActionListener a){
        
    }

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
    }
    
    public void outputClear(){
        output="";
    }
}
