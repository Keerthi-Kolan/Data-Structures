package Heap;
import java.util.Scanner;
public class MinHeap {
    int[] minHeap;
    static int size;
    int capacity;
    MinHeap(){
        minHeap=new int[100];
        size=0;
        capacity=100;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        MinHeap heap=new MinHeap();
        System.out.println("This heap can store atmost 100 numbers");
        while(true){
            System.out.println("Enter you choice\n1. Insert an element\n2. Print the all elements\n3. Print minimum element\n4. Delete minimum element\n5. Delete element at position x\npress '*' to exit");
            String choice=sc.nextLine();
            if(choice.equals("*"))
                break;
            switch (choice){
                case "1": heap.insert();
                break;
                case "2": heap.print();
                break;
                case "3": heap.printMin();
                break;
                case "4": heap.delete(0);
                break;
                case "5":
                    System.out.println("Enter the position of the element you wish to delete");
                    int position=sc.nextInt();
                    heap.delete(position);
                    sc.nextLine();
                break;
                default: System.out.println("Enter a valid choice");
            }
        }
    }

    public void delete(int position){
        if(size==0){
            System.out.println("Heap is empty. Deletion is not possible");
        }
        int minimumElement=minHeap[position];
        minHeap[position]=minHeap[size-1];
        size--;
        int index=position;
        int minimumIndex=position;
        while(index<size){
            int left=(2*index)+1;
            int right=(2*index)+2;
            if(left<size&&minHeap[left]<minHeap[index]){
                minimumIndex=left;
            }
            if(right<size&&minHeap[right]<minHeap[minimumIndex]){
                minimumIndex=right;
            }
            if(index!=minimumIndex){
                int temp=minHeap[index];
                minHeap[index]=minHeap[minimumIndex];
                minHeap[minimumIndex]=temp;
            }
            else{
                break;
            }
            index=minimumIndex;

        }
        System.out.println("Element "+minimumElement+" removed from the heap");
    }
    public void printMin(){
        System.out.println("The minimum element of the heap is "+minHeap[0]);
    }
    public int[] heapify(int[] heap,int index){
        while(index>0){
            int parent=(index-1)/2;
            if(heap[parent]>heap[index]){
                int temp=heap[parent];
                heap[parent]=heap[index];
                heap[index]=temp;
            }
            else{
                break;
            }
            index=parent;
        }
        return heap;
    }
    public void insert(){
        if(size==capacity){
            System.out.println("Heap is Full. Insertion is not possible");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the element you want to insert in the heap.");
        int element=sc.nextInt();
        size++;
        minHeap[size-1]=element;
        minHeap=heapify(minHeap,size-1);
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(minHeap[i]+" ");
        }
        System.out.println();
    }
}
