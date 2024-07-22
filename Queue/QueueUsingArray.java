// This program does not implement circular queue
package Queue;

import java.util.Scanner;

public class QueueUsingArray {
    int[] array;
    int front;
    int rear;
    QueueUsingArray(){
        array=new int[10];
        front=0;
        rear=0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("This queue can hold atmost 10 numbers");
        QueueUsingArray queue=new QueueUsingArray();
        while(true){
            System.out.println("Enter your choice or press '*' to exit");
            System.out.println("1.Enqueue\n2.Dequeue\n3.Peek\n4.isEmpty\n5.isFull\n6.Print");
            String input=sc.nextLine();
            if(input.equals('*'))
                break;
            int choice;
            try {
                choice = Integer.parseInt(input);
            }
            catch (NumberFormatException e){
                System.out.println("Enter a valid choice");
                continue;
            }
            switch (choice){
                case 1: queue.enqueue();
                break;
                case 2: queue.dequeue();
                break;
                case 3: queue.peek();
                break;
                case 4: queue.isEmpty();
                break;
                case 5: queue.isFull();
                break;
                case 6: queue.print();
                break;
                default:System.out.println("Enter a valid choice");
            }
        }
    }
    public void enqueue(){
        Scanner sc=new Scanner(System.in);
        while(true) {
            if (rear == 10) {
                System.out.println("Queue is Full");
                return;
            }
            System.out.println("Enter an element into the queue or press '*' to exit");
            String input=sc.nextLine();
            if(input.equals("*"))
                return;
            int number;
            try{
                number=Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                System.out.println("Enter a valid choice");
                continue;
            }
            array[rear++]=number;
        }
    }
    public void dequeue(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Press any key to delete an element from the queue or press '*' to exit");
            String input=sc.nextLine();
            if(input.equals("*"))
                return;
            if(front==rear){
                System.out.println("Queue is empty");
                front=0;
                rear=0;
                return;
            }
            System.out.println("Element "+array[front]+" is deleted");
            array[front++]=0;

        }
    }
    public void peek(){
        System.out.println("Element on the top is: "+array[front]);
    }
    public void isFull(){
        System.out.println((rear==10)?"Queue is Full":"Queue is not full");
    }
    public void isEmpty(){
        System.out.println((rear==0)?"Queue is Empty":"Queue is not empty");
    }
    public void print(){
        int index=front;
        System.out.println("*******");
        while(index!=rear){
            System.out.println(array[index]);
            index++;
        }
        System.out.println("*******");
    }
}
