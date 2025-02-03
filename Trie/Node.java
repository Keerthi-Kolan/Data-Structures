package Trie;

public class Node {
    Node[] alphabet;
    boolean isEnd;
    Node(){
        alphabet=new Node[26];
        isEnd=false;
    }
}
