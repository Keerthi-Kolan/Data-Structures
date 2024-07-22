package Stack;
import java.util.Scanner;
public class StackUsingArray {
    int[] array;
    int top;
    StackUsingArray(){
        array=new int[10];
        top=-1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StackUsingArray stack=new StackUsingArray();
        System.out.println("This stack can hold atmost 10 numbers:\nEnter your choice");
        while(true) {
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. isEmpty\n5. isFull\n6. Print");
            System.out.println("Enter your choice or press '*' to exit");
           String ch = sc.nextLine();
           if(ch.equals("*")){
               break;
           }
           else {
               int choice=Integer.parseInt(ch);
               switch (choice) {
                   case 1:
                       stack.push();
                       break;
                   case 2:
                       stack.pop();
                       break;
                   case 3:
                       stack.peek();
                       break;
                   case 4:
                       stack.isEmpty();
                       break;
                   case 5:
                       stack.isFull();
                       break;
                   case 6:
                       stack.print();
                       break;
                   default:
                       System.out.println("Enter a valid choice");
               }
           }
        }
    }
    public void push(){
        Scanner sc=new Scanner(System.in);
        while(true){
            if(top==9)
            {
                System.out.println("Stack is Full");
                return;
            }
            System.out.println("Enter the element into the stack or press '*' to exit");
            String input=sc.nextLine();
            if(input.equals("*"))
                break;
            else {
                array[++top] = Integer.parseInt(input);
            }
        }
    }
    public void pop(){
        Scanner sc=new Scanner(System.in);
        while(true){
            if(top==-1)
            {
                System.out.println("Stack is Empty");
                return;
            }
            System.out.println("Press any key to delete element on the top of the stack or press '*' to exit");
            String input=sc.nextLine();
            if(input.equals("*"))
                break;
            else {
                System.out.println(array[top]+" is removed from the stack");
                array[top--] = 0;
            }
        }
    }
    public void peek(){
        System.out.println("Element at the top of the stack is: "+array[top]);
    }
    public void isEmpty() {
        System.out.println((top==-1)?"Stack is Empty":"Stack is not empty");
    }
    public void isFull(){
        System.out.println((top==9)?"Stack is Full" : "Stack is not Full");
    }
    public void print(){
        int index=top;
        System.out.println("*******");
        System.out.println("Elements of the stack: ");
        while(index>=0){
            System.out.println(array[index--]);
        }
        System.out.println("*******");
    }
}
