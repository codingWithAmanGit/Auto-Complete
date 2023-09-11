package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private HashMap<Character, Trie> child;
    private boolean isLeaf;
    Trie root;
    private char c;


    public Trie(){
        child = new HashMap<>();
        isLeaf = false;
    }


    public Trie(List<String> list) {
        root = new Trie();
        for(String word: list){
            root.insert(word);
        }
    }

    public void insert(String word){
        Trie curr = this;
        for(char c: word.toCharArray()){


            curr.child.putIfAbsent(c, new Trie());

            curr = curr.child.get(c);
        }

        curr.isLeaf = true;
    }

    public boolean search(String word){

        Trie curr = this;

        for(char c : word.toCharArray()){

            curr = curr.child.get(c);

            if(curr == null){
                return false;
            }
        }

        return curr.isLeaf;

    }

    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        Trie last = root;
        StringBuffer curr = new StringBuffer();
        for(char c: prefix.toCharArray()){
            last = last.child.get(c);
            if(last == null){
                return list;
            }
            curr.append(c);
        }
        suggestHelper(last, list, curr);
        return list;
    }

    private void suggestHelper(Trie root, List<String> list, StringBuffer curr) {

        if(root.isLeaf){
            list.add(curr.toString());
        }
        if(root.child == null || root.child.isEmpty()) return;

        for(Trie children: root.child.values()){
            suggestHelper(children, list, curr.append(children.c));
            curr.setLength(curr.length()-1);
        }
    }
}
