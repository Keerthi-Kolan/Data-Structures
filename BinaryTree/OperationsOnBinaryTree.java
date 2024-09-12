package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OperationsOnBinaryTree {
    static Scanner sc;
    static Node root;
    public static void main(String[] args) {
        OperationsOnBinaryTree opertion=new OperationsOnBinaryTree();
        sc=new Scanner(System.in);
        root=null;
        while(true){

            System.out.println("Which operation you want to perform?\n1. Insertion\n2. Deletion\n3. Search\n4. print\n  * to exit");
            String input=sc.nextLine();
            if (input.equals("*")) {
                break;
            }
            else{
                int choice=Integer.parseInt(input);
                switch (choice){
                    case 1: opertion.insert();
                    break;
                    case 2:  opertion.delete();
                    break;
                    case 3: System.out.println("What is the number you want to search in the tree?");
                    int number=sc.nextInt();
                    sc.nextLine();
                        if(opertion.search(root,number))
                            System.out.println("The given tree contains number "+number);
                        else
                            System.out.println("The given tree does not contain number "+number);
                    break;
                    case 4: System.out.println("Level order traversal of the given tree: ");
                        opertion.print(root);
                    break;
                    default: System.out.println("Enter a valid choice");
                }
            }
        }
    }

    public void insert(){
        sc=new Scanner(System.in);
        System.out.println("Enter the element you want to insert into the tree");
        int value=sc.nextInt();
        sc.nextLine();
        if(root==null){
            root=new Node(value);
            System.out.println(value+" is the root node");
        }
        else{
            Queue<Node> queue=new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node curr=queue.remove();
                if(curr.left==null){
                    curr.left= new Node(value);
                    System.out.println(value+" is inserted into the tree whose parent is "+ curr.data);
                    break;
                }
                else{
                    queue.add(curr.left);
                }
                if(curr.right==null){
                    curr.right=new Node(value);
                    System.out.println(value+" is inserted into the tree whose parent is "+curr.data);
                    break;
                }
                else{
                    queue.add(curr.right);
                }
            }
        }
    }
    // Function to delete the last node of a binary tree
    public void delete(){
        if(root==null){
            System.out.println("Binary tree is empty");
            return;
        }

        if(root.left==null&&root.right==null){
            root=null;
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        Node lastNode=null,parentOfLastNode=null;
        while(!queue.isEmpty()){
            lastNode = queue.remove();
            if(lastNode.left!=null){
                parentOfLastNode=lastNode;
                queue.add(lastNode.left);
            }
            if(lastNode.right!=null){
                parentOfLastNode=lastNode;
                queue.add(lastNode.right);
            }
        }
        if(parentOfLastNode!=null){
            if(parentOfLastNode.right==lastNode){
                parentOfLastNode.right=null;
            }
            else if(parentOfLastNode.left==lastNode){
                parentOfLastNode.left=null;
            }
        }
    }
    public boolean search(Node root,int number){
        if(root==null){
            return false;
        }
        if(root.data==number){
            return true;
        }
        return search(root.left,number)||search(root.right,number);
    }
    public void print(Node root){
        if(root==null){
            System.out.println("Tree is empty");
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr=queue.remove();
            System.out.print(curr.data+" ");
            if(curr.left!=null){
                queue.add(curr.left);
            }
            if(curr.right!=null){
                queue.add(curr.right);
            }
        }
        System.out.println();
    }
}
