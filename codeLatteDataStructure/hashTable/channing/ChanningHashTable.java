package codeLatteDataStructure.hashTable.channing;

import java.util.LinkedList;

public class ChanningHashTable {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private static final float ROAD_FACTOR_THRESHOLD = 0.75F;

    private LinkedList<Entry>[] bucket;
    private int bucketSize;

    public ChanningHashTable() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public ChanningHashTable(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("정상적인 해시 테이블의 크기를 정해주세요");
        }
        bucket = new LinkedList[tableSizeFor(capacity)];
    }

    private int tableSizeFor(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 15;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private int hash(Object key) {

        int h;
        h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return h & (bucket.length - 1);
    }

    private int probing(Object key) {
        return hash(key);
    }

    public Object get(Object key) {
        int index = probing(key);

        if (bucket[index] == null) {
            return null;
        }

        LinkedList<Entry> list = bucket[index];
        for (Entry entry : list) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void put(Object key, Object value) {
        putValue(key, value);
    }

    private void putValue(Object key, Object value) {
        int index = probing(key);
        if (bucket[index] == null) {
            bucket[index] = new LinkedList<>();
            ++bucketSize;
        }
        boolean isExistKey = false;
        for (Entry entry : bucket[index]) {
            if (entry.key.equals(key)) {
                isExistKey = true;
                entry.value = value;
                break;
            }
        }

        if (!isExistKey) {
            bucket[index].add(new Entry(key, value));
        }
        resizeBucket();
    }

    public void remove(Object key) {
        int index = probing(key);
        if (bucket[index] != null) {
            LinkedList<Entry> list = bucket[index];
            for (Entry entry : list) {
                if (entry.key.equals(key)) {
                    list.remove(entry);
                    break;
                }
            }
            if (list.isEmpty()) {
                bucket[index] = null;
                --bucketSize;
            }
        }

    }

    private void resizeBucket() {
        int prevBucketSize = bucket.length;

        if (prevBucketSize >= MAXIMUM_CAPACITY) {
            return;
        }

        if (bucketSize * 1.0F / bucket.length > ROAD_FACTOR_THRESHOLD) {
            int newBucketSize = tableSizeFor(prevBucketSize << 1);

            LinkedList<Entry>[] tempList = bucket;
            bucket = new LinkedList[newBucketSize];
            bucketSize = 0;

            for (LinkedList<Entry> list : tempList) {
                if (list != null) {
                    while (!list.isEmpty()) {
                        Entry entry = list.removeFirst();
                        putValue(entry.key, entry.value);
                    }
                }
            }
        }
    }

    public void printHashTable() {
        System.out.println("-------------");
        for (int i = 0; i < bucket.length; i++) {
            if (null != bucket[i]) {
                System.out.printf("| %d | %s %s\n", i, "List", printNode(bucket[i]));
            } else {
                System.out.printf("| %d | %s\n", i, "null");
            }
        }
        System.out.println("-------------");
    }

    private String printNode(LinkedList<Entry> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("head -> ");
        for (Entry entry : list) {
            builder.append("(").append(entry.key).append(",").append(entry.value).append(") -> ");
        }
        builder.append("null");
        return builder.toString();
    }
}
