package codeLatteDataStructure.Tree;

public class RedBlackTree {

    Node root;

    static final int RED = 0;
    static final int BLACK = 1;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;
        if (root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }
        root.color = BLACK;
    }

    private void insertNode(Node x, Node newNode) {

        if (x.key > newNode.key && !isExist(x.left)) {
            x.left = newNode;
            newNode.parent = x;
        } else if (x.key <= newNode.key && !isExist(x.right)) {
            x.right = newNode;
            newNode.parent = x;
        } else if (x.key > newNode.key) {
            insertNode(x.left, newNode);
        } else {
            insertNode(x.right, newNode);
        }
        insertFixup(x);
    }

    public void remove(int key) {
        removeNode(root, key);
    }

    void removeNode(Node x, int key) {
        if (x == null) {
            throw new RuntimeException("key를 찾을 수 없습니다.");
        } else if (x.key > key) {
            removeNode(x.left, key);
        } else if (x.key < key) {
            removeNode(x.right, key);
        } else {
            if (isExist(x.left)) {
                Node predecessor = getLargestNode(x.left);
                int removeKey = x.key;
                x.key = predecessor.key;
                predecessor.key = removeKey;
                removeNode(x.left, predecessor.key);
            } else if (isExist(x.right)) {
                Node successor = getSmallestNode(x.right);
                int removeKey = x.key;
                x.key = successor.key;
                successor.key = removeKey;
                removeNode(x.right, successor.key);
            } else {
                // x 노드가 삭제할 노드
                if (root == x) {
                    root = null;
                } else {
                    if (isBlack(x)) {
                        removeFixup(x);
                    }
                    // TODO : 연결 해제
                    if (x.parent.left == x) {
                        x.parent.left = null;
                    } else if (x.parent.right == x) {
                        x.parent.right = null;
                    }
                    x.parent = null;
                }
            }

        }
    }

    private void removeFixup(Node x) {
        while (root != x && isBlack(x)) {
            if (x == x.parent.left) {
                Node w = x.parent.right;
                // CASE 1
                if (isRed(w)) {
                    w.color = BLACK;
                    x.parent.color = RED;
                    RR_rotate(x.parent);
                    w = x.parent.right;
                }
                // CASE 2
                if (isBlack(w.left) && isBlack(w.right)) {
                    w.color = RED;
                    x = x.parent;
                } else {
                    // CASE 3
                    if (isBlack(w.right)) {
                        w.left.color = BLACK;
                        w.color = RED;
                        LL_rotate(w);
                        w = w.parent.right;
                    }
                    // CASE 4
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    RR_rotate(x.parent);
                    break;
                }
            } else {
                // 삭제 할 노드가 우측 Left 노드인 경우

            }
            x.color = BLACK;
        }
    }

    private Node getLargestNode(Node x) {
        if (null == x.right) {
            return x;
        }
        return getLargestNode(x.right);
    }

    private Node getSmallestNode(Node x) {
        if (null == x.left) {
            // TODO : 좌측 자식 노드가 존재하지 않는다. (가장 작은 노드)
            return x;
        }
        return getSmallestNode(x.left);
    }

    public int search(int key) {
        return searchNode(root, key).key;
    }

    private Node searchNode(Node parent, int key) {
        if (parent == null) {
            throw new RuntimeException("노드를 찾을 수 없습니다.");
        } else if (parent.key > key) {
            parent = searchNode(parent.left, key);
        } else if (parent.key < key) {
            parent = searchNode(parent.right, key);
        }
        return parent;
    }

    boolean isExist(Node x) {
        return x != null;
    }

    boolean isRed(Node x) {
        return isExist(x) && x.color == RED;
    }

    boolean isBlack(Node x) {
        return !isRed(x);
    }

    void swapColor(Node nodeA, Node nodeB) {
        int temp = nodeA.color;
        nodeA.color = nodeB.color;
        nodeB.color = temp;
    }

    void LL_rotate(Node P) {
        Node GP = P.parent;
        Node L = P.left;
        Node LR = L.right;
        L.right = P;
        P.left = LR;

        P.parent = L;
        if (isExist(LR)) {
            LR.parent = P;
        }

        LR.parent = GP;

        if(!isExist(GP)) {
            this.root = L;
        } else {
            /**
             * 조부마가 없을 경우
             * 부모가 조부모의 어느 자식인지 모름
             * 조부모의 이전 자식이 부모 노드였으므리 동일한 링크를 찾으면 조부모의 어느 자식인지 찾을 수 있다.
             */
            if (P == GP.right) {
                GP.right = L;
            } else if (P == GP.left) {
                GP.left = L;
            }
        }

    }

    void RR_rotate(Node P) {
        Node GP = P.parent;
        Node R = P.right;
        Node RL = P.left;
        R.left = P;
        P.right = RL;

        P.parent = R;

        if (!isExist(GP)) {
            this.root = R;
        } else {
            if (GP.right == P) {
                GP.right = R;
            } else if (GP.left == P) {
                GP.left = R;
            }
        }

    }

    /**
     * 삽입시 노드를 재배치
     */
    private void insertFixup(Node g) {
        if (isRed(g.right) && isRed(g.right.left) && isBlack(g.left)) {
            LL_rotate(g.right);
            swapColor(g, g.right);
            RR_rotate(g);
        } else if (isRed(g.right) && isRed(g.right.right) && isBlack(g.left)) {
            swapColor(g, g.right);
            RR_rotate(g);
        } else if (isRed(g.left) && isRed(g.right.right) && isBlack(g.right)) {
            g.color = RED;
            g.right.color = BLACK;
            g.left.color = BLACK;
        } else if (isRed(g.left) && isRed(g.left.right) && isBlack(g.right)) {
            RR_rotate(g.left);
            swapColor(g, g.left);
            LL_rotate(g);
        } else if (isRed(g.left) && isRed(g.left.left) && isBlack(g.right)) {
            swapColor(g, g.left);
            LL_rotate(g);
        } else  if (isRed(g.left) && (isRed(g.left.left)) || isRed(g.left.right)) {
            g.color = RED;
            g.left.color = BLACK;
            g.right.color = BLACK;
        }
    }
}
