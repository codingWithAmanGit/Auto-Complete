package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("there");
        System.out.println(trie.search("there"));
        trie.insert("that");
        trie.insert("those");
        trie.insert("bunny");
        trie.insert("bug");

        boolean res = trie.search("bug");
        System.out.println(res);


        List<String> list = List.of("hello", "hell", "helps", "help", "dog", "cat");

        Trie tries = new Trie(list);

        System.out.println(tries.suggest("hel"));
    }

}