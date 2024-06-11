package DoublyLinkedList;
import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        Node head = null;
        while (true) {
            System.out.println("Choose the operation you wish to perform. Enter\n1 for Insertion\n2 for Searching an element" +
                    "\n3 for Deleting an element\n4 to print the length of the linked list\n5 to print the elements of linked list.\nPress * to exit");
            String input = sc.next();
            if (input.equals("*"))
                break;
            else {
                ch = Integer.parseInt(input);
            }
            switch (ch) {
                case 1:
                    head = insert(head);
                    break;
                case 2:
                    search(head);
                    break;
                case 3:
                    head = delete(head);
                    break;
                case 4:
                    int len = length(head);
                    System.out.println("The length of the linked list is " + len);
                    break;
                case 5:
                    print(head);
                    break;
                default:
                    System.out.println("Enter either 1, 2 or 3 only");
            }
        }
    }

    public static Node insert(Node head) {
        System.out.println("Enter the elements of the linked list.");
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        // Insertion at head
        if (head == null) {
            head = new Node(sc.nextInt());
            System.out.println(head.data + " is sucessfully inserted. Enter the next element of the linked list or press '*' to exit.");
        }
        System.out.println("Enter the index where you want to add the elements");
        int indexOfElement = sc.nextInt();
        System.out.println("Enter the elements of the linked list");
        if(indexOfElement==0){
            Node newNode = new Node(sc.nextInt());
            newNode.next = head;  // Set newNode's next to current head
            if (head != null) {  // Check if list is not empty
                head.prev = newNode;  // Update current head's prev to newNode
            }
            head = newNode;  // Update head to newNode
            System.out.println(head.data + " is successfully inserted at the head of the linked list");
            return head;
        }

        if (indexOfElement > length(head)) {
            System.out.println("Given index is greater than the length of the array. Insertion is not possible.");
            return head;
        }
        // Insertion at middle or end
       Node curr = head;
        Node prev=null;
        int index = 0;
        while (curr.next != null) {
            index++;
            if (index == indexOfElement) {
                break;
            }
            curr = curr.next;
            prev=curr;
        }
        Node temp = curr.next;
        curr.next = null;
        while (flag) {
            String ch = sc.next();
            if (ch.equals("*"))
                break;
            curr.next = new Node(Integer.parseInt(ch));
            prev=curr;
            curr = curr.next;
            curr.prev=prev;
            System.out.println(curr.data + " is sucessfully inserted. Enter the next element of the linked list or press '*' to exit.");

        }
        //System.out.println(curr.data);
        curr.next = temp;
        return head;
    }
    public static void search(Node head){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the element you want to search");
        int element=sc.nextInt();
        int index=0;
        Node curr=head;
        while(curr!=null){
            if(curr.data==element){
                System.out.println("Element found at index "+index);
                return ;
            }
            index++;
            curr=curr.next;
        }
        System.out.println("Element not found");
    }
    public static Node delete(Node head){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the index of the element you want to delete");
        int elementIndex=sc.nextInt();
        if(elementIndex==0){
            Node temp=head.next;
            head.next=null;
            head=temp;
            head.prev=null;
            System.out.println("Element at index "+elementIndex+" successfully deleted");
            return head;
        }
        int index=0;
        int length=length(head);
        if(elementIndex>=length){
            System.out.println("There is no element at index "+elementIndex);
        }
        Node curr=head;
        while(curr.next!=null){
            index++;
            if(index==elementIndex){
                Node temp=curr.next;
                curr.next=curr.next.next;
                if(curr.next!=null)
                    curr.next.prev=curr;
                System.out.println("Element at index "+elementIndex+" successfully deleted");
                return head;
            }
            curr=curr.next;
        }
        return head;
    }
    public static int length(Node head){
        if(head==null)
            return 0;
        Node curr=head;
        int len=0;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        return len;
    }
    public static void print(Node head){
        if(head==null)
        {
            System.out.println("The Doubly Linked List is empty");
            return;
        }
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            System.out.print(curr.data+" ");
            prev=curr;
            curr=curr.next;
        }
        System.out.println();
        System.out.println("Printing Nodes in reverse order");
        while(prev!=null){
            System.out.print(prev.data+" ");
            prev=prev.prev;
        }
        System.out.println();
    }
}
