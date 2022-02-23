package codeLatteDataStructure.hashTable.linear;

public class LinearProbingHashTable {

    // 버킷으로 할당 할 수 있는 최대 크기
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    // 버킷의 엔트리가 75%를 넘으면 버킷의 크기를 늘린다
    private static final float ROAD_FACTOR_THRESHOLD = 0.75F;

    private Entry[] bucket;
    private int bucketSize;
    private final Entry dummyNull = new Entry(null, null, true);

    public LinearProbingHashTable() {
        this(16);
    }

    public LinearProbingHashTable(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("정상적인 해시 테이블의 크기를 정해주세요.");
        }
        bucket = new Entry[tableSizeFor(capacity)];
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

    /**
     * 보조 해시 함수: h'(k) -> {0. 1. 2. ... m - 1}
     * 해시 값을 최대한 흩어 놓기 위해 앞의 16비트를 옮겨 기존의 해시값과 XOR 연산을 먼저 한 후
     * 버킷의 크기 만큼의 범위에 들어가게 하기 위해 비트 연산을 한다.
     */
    private int secondaryHash(Object key) {

        int h;
        h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        return h & (bucket.length - 1);
    }

    private int hash(Object key, int i) {
        int m = bucket.length;
        return (secondaryHash(key) + i) % m;
    }

    /**
     * 카의 조사를 위해 Dummy null 엔트리도 null로 판단히지 않는 조사 방식
     * @param key
     * @return
     */
    private int probing(Object key) {
        int m = bucket.length;
        int bucketIndex = -1;
        for (int i = 0; i < m; i++) {
            bucketIndex = hash(key, i);
            if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
                // 동일한 키를 찾은 경우
                break;
            } else if (bucket[bucketIndex] == null) {
                break;
            }
        }
        return bucketIndex;
    }

    private int insertProbing(Object key) {
        int m = bucket.length;
        int bucketIndex = -1;
        for (int i = 0; i < m; i++) {
            bucketIndex = hash(key, i);
            if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
                // 동일한 키를 찾은 경우
                break;
            } else if (bucket[bucketIndex] == null || (bucket[bucketIndex] != null && bucket[bucketIndex].isDeleted)) {
                break;
            }
        }
        return bucketIndex;
    }

    public void put(Object key, Object value) {
        putValue(key, value);
    }

    private void putValue(Object key, Object value) {
        int bucketIndex = insertProbing(key);
        if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
            bucket[bucketIndex].value = value;
        } else if(bucket[bucketIndex] == null || (bucket[bucketIndex] != null && bucket[bucketIndex].isDeleted)) {
            bucket[bucketIndex] = new Entry(key, value, false);
            ++bucketSize;
        }
        resizeBucket();
    }

    public Object get(Object key) {
        int bucketIndex = probing(key);
        Entry entry = null;
        if (bucket[bucketIndex] != null && key.equals(bucket[bucketIndex].key)) {
            entry = bucket[bucketIndex];
        }
        return (entry != null) ? entry.value : null;
    }

    public void remove(Object key) {
        int index = probing(key);
        int removedIndex = -1;
        if (bucket[index] != null && key.equals(bucket[index].key)) {
            bucket[index] = this.dummyNull;
            removedIndex = index;
            --bucketSize;
        }

        if (removedIndex != -1) {
            int nullIndex = removedIndex;
            for (int i = 0; i < bucket.length; i++) {
                int moveIndex = (i + removedIndex) % bucket.length;
                if (bucket[moveIndex] != null && !bucket[moveIndex].isDeleted && secondaryHash(bucket[moveIndex].key) <= nullIndex) {
                    bucket[nullIndex] = bucket[moveIndex];
                    bucket[moveIndex] = this.dummyNull;
                    nullIndex = moveIndex;
                }
            }
        }
    }

    private void resizeBucket() {
        int prevBucketSize = bucket.length;
        if (prevBucketSize >= MAXIMUM_CAPACITY) {
            return;
        }

        if (bucketSize * 1.0F / prevBucketSize > ROAD_FACTOR_THRESHOLD) {
            int newBucketSize = tableSizeFor(prevBucketSize << 1);
            Entry[] entries = bucket;
            bucket = new Entry[newBucketSize];
            bucketSize = 0;

            for (Entry entry : entries) {
                if (entry != null && !entry.isDeleted) {
                    putValue(entry.key, entry.value);
                }
            }
        }
    }

    public void printHashTable() {
        System.out.println("-----Linear----");
        for (int i = 0; i < bucket.length; i++) {
            if (null != bucket[i] && bucket[i].isDeleted) {
                System.out.printf("| %d | %s\n", i, "null(dummy)");
            } else if (null != bucket[i]) {
                System.out.printf("| %d | %s\n", i, printNode(bucket[i]));
            } else {
                System.out.printf("| %d | %s\n", i, "null");
            }
        }
        System.out.println("---------------");
    }

    private String printNode(Entry entry) {
        StringBuilder builder = new StringBuilder();
        int hash = secondaryHash(entry.key);
        builder.append("(").append(entry.key).append(",").append(entry.value)
                .append(",").append(hash).append(")");
        return builder.toString();
    }
}
