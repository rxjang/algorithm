package codeLatteDataStructure.hashTable.linear;

public class Entry {

    Object key;
    Object value;

    boolean isDeleted = false;

    public Entry(Object key, Object value, boolean isDeleted) {
        this.key = key;
        this.value = value;
        this.isDeleted = isDeleted;
    }
}
