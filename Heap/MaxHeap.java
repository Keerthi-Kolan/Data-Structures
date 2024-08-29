package Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxHeap {
    ArrayList<Integer> maxHeap;
    private int size;

    MaxHeap(){
        maxHeap =new ArrayList<>();
        size=0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        MaxHeap heap=new MaxHeap();
        while(true){
            System.out.println("Enter you choice\n1. Insert an element\n2. Print the all elements\n3. Print maximum element\n4. Delete maximum element\n5. Delete element at position x\npress '*' to exit");
            String choice=sc.nextLine();
            if(choice.equals("*"))
                break;
            switch (choice){
                case "1": heap.insert();
                    break;
                case "2": heap.print();
                    break;
                case "3": heap.printMax();
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
            return;
        }
        int maximumElement = maxHeap.get(position);
        maxHeap.set(position, maxHeap.get(size-1));
        maxHeap.remove(size - 1);
        size--;
        int index=position;
        int maximumIndex =position;
        while(index<size){
            int left=(2*index)+1;
            int right=(2*index)+2;
            if(left<size&& maxHeap.get(left)> maxHeap.get(maximumIndex)){
                maximumIndex =left;
            }
            if(right<size&& maxHeap.get(right)> maxHeap.get(maximumIndex)){
                maximumIndex =right;
            }
            if(index!= maximumIndex){
                int temp= maxHeap.get(index);
                maxHeap.set(index, maxHeap.get(maximumIndex));
                maxHeap.set(maximumIndex, temp);

            }
            else{
                break;
            }
            index= maximumIndex;

        }
        System.out.println("Element "+ maximumElement +" removed from the heap");
    }
    public void printMax(){
        System.out.println("The maximum element of the heap is "+ maxHeap.get(0));
    }
    public void heapify(ArrayList<Integer> heap,int index){
        while(index>0){
            int parent=(index-1)/2;
            if(heap.get(parent)<heap.get(index)){
                int temp=heap.get(parent);
                heap.set(parent,heap.get(index));
                heap.set(index,temp);
            }
            else{
                break;
            }
            index=parent;
        }
    }
    public void insert(){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the element you want to insert in the heap.");
        int element=sc.nextInt();
        sc.nextLine();
        size++;
        maxHeap.add(element);
        heapify(maxHeap,size-1);
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(maxHeap.get(i)+" ");
        }
        System.out.println();
    }
}
