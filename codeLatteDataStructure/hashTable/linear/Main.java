package codeLatteDataStructure.hashTable.linear;

import codeLatteDataStructure.hashTable.linear.LinearProbingHashTable;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linear Probing");
        LinearProbingHashTable linearProbingHashTable = new LinearProbingHashTable(16);
        linearProbingHashTable.put("hi1", 1);
        linearProbingHashTable.put("hi2", 2);
        linearProbingHashTable.put("hi3", 3);
        linearProbingHashTable.put("hi10", 10);
        linearProbingHashTable.put("hi11", 11);
        linearProbingHashTable.put("hi12", 12);
        linearProbingHashTable.put("hi13", 13);
        linearProbingHashTable.put("hi14", 14);
        linearProbingHashTable.printHashTable();
        linearProbingHashTable.remove("hi12");
        linearProbingHashTable.printHashTable();
        System.out.printf("find key:%s value:%s\n\n", "hi11", linearProbingHashTable.get("hi11"));
    }
}
