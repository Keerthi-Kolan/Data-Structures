package Trie;

import java.util.Scanner;

public class Trie {
    static Node root;
    public void insert(String str){
        Node curr=root;
        for(char ch:str.toCharArray()){
            if(curr.alphabet[ch-'a']==null){
                Node node=new Node();
                curr.alphabet[ch-'a']=new Node();
            }
            curr=curr.alphabet[ch-'a'];
        }
        curr.isEnd=true;
    }
    public void delete(String str){
    Node curr=root;
    for(char ch:str.toCharArray()){
        int count=0;
        for(int i=0;i<26;i++){
            if(curr.alphabet[i]!=null){
                count++;
            }
        }
        System.out.println("Count="+count);
        if(count==1){
            curr.alphabet[ch-'a']=null;
            break;
        }
        curr=curr.alphabet[ch-'a'];
    }
    System.out.println(str+" successfully deleted from Trie");
    }
    public boolean search(String str){
        Node curr=root;
        for(char ch:str.toCharArray()){
            if(curr.alphabet[ch-'a']==null){
                return false;
            }
            curr=curr.alphabet[ch-'a'];
        }
        return curr.isEnd;
    }
    public boolean startsWith(String str){
        Node curr=root;
        for(char ch:str.toCharArray()){
            if(curr.alphabet[ch-'a']==null){
                return false;
            }
            curr=curr.alphabet[ch-'a'];
        }
        return true;
    }
    public static void main(String[] args){
        root=new Node();
        Trie trie=new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("alcohol");
        System.out.println("Trie has \"app\"? "+trie.search("app"));
        trie.delete("app");
        System.out.println("App deleted");
        System.out.println("Trie has \"app\"? "+trie.search("app"));
        System.out.println("Trie has \"apple\"? "+trie.search("apple"));
        System.out.println("Trie has \"alcohol\"? "+trie.search("alcohol"));
    }
}
