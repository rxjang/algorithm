package codeLatteDataStructure.Tree;

public class AVLTree {

    Node root;

    public void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if (root == null) {
            root = newNode;
        } else {
            root = insertNode(root, newNode);
        }
    }

    private Node insertNode(Node x, Node newNode) {
        if (x == null) {
            return newNode;
        } else if ( x.key > newNode.key) {
            x.left = insertNode(x.left, newNode);
        } else {
            x.right = insertNode(x.right, newNode);
        }

        changeNodeHeight(x);
        return rotate(x);
    }

    public void remove(int key) {
        root = removeNode(root, key);
    }

    private Node removeNode(Node x, int key) {
        if (x == null) {
            throw new RuntimeException("노드가 존재하지 않습니다.");
        }

        if (x.key > key) {
            x.left = removeNode(x.left, key);
        } else if (x.key < key) {
            x.right = removeNode(x.right, key);
        } else {
            if (x.left != null) {
                Node predecessor = getLargestNode(x.left);
                int removeKey = x.key;
                x.key = predecessor.key;
                predecessor.key = removeKey;
                x.left = removeNode(x.left, key);
            } else if (x.right != null) {
                Node successor = getSmallestNode(x.right);
                int removeKey = x.key;
                x.key = successor.key;
                successor.key = removeKey;
                x.right = removeNode(x.right, key);
            } else {
                return null;
            }
        }
        changeNodeHeight(x);
        return rotate(x);
    }

    private Node getLargestNode(Node x) {
        if (x.right == null) {
            return x;
        }
        return getLargestNode(x.right);
    }

    private Node getSmallestNode(Node x) {
        if (x.left == null) {
            return x;
        }
        return getSmallestNode(x.left);
    }

    public int search(int key) {
        return searchNode(root, key).key;
    }

    Node searchNode(Node x, int key) {
        Node node = x;
        if (node == null) {
            throw new RuntimeException("키를 찾을 수 없습니다.");
        } else if (node.key > key) {
            node = searchNode(x.left, key);
        } else if (node.key < key) {
            node = searchNode(x.right, key);
        }
        return node;
    }

    /**
     * 자식 노드 중 큰 값에 +1을 한 값
     */
    int getHeight(Node x) {

        int leftChildHead = x.left == null ? -1 : x.left.height;
        int rightChildHead = x.right == null ?  -1 : x.right.height;
        return Math.max(leftChildHead, rightChildHead) + 1;
    }

    /**
     * 노드의 균형도를 계산
     * 좌측 자식 노드에서 우측 자신 노드의 차
     */
    int getBalance(Node x){

        int leftChildHead = x.left == null ? -1 : x.left.height;
        int rightChildHead = x.right == null ?  -1 : x.right.height;
        return leftChildHead - rightChildHead;
    }

    /**
     * 노드의 높이를 변경
     */
    void changeNodeHeight(Node x) {
        x.height = getHeight(x);
    }

    // LL 회전을 함
    Node LL_rotate(Node P) {
        Node L = P.left;
        Node LR = L.right;
        L.right = P;
        P.left = LR;

        changeNodeHeight(P);
        changeNodeHeight(L);

        return L;
    }

    // RR 회전을 함
    Node RR_rotate(Node P) {
        Node R = P.right;
        Node RL = R.left;
        R.left = P;
        P.right = RL;

        changeNodeHeight(P);
        changeNodeHeight(R);

        return R;
    }

    // 균형을 맞추기 위해 회전
    Node rotate(Node x) {
        int xNodeBalance = getBalance(x);

        if (Math.abs(xNodeBalance) >= 2) {
            if (xNodeBalance > 1 && getBalance(x.left) >= 0) {
                // 좌측 비대 문제
                x = LL_rotate(x);
            } else if (xNodeBalance > 1 && getBalance(x.left) == -1) {
                x.left = RR_rotate(x.left);
                x = LL_rotate(x);
            } else if (xNodeBalance < -1 && getBalance(x.right) >= 0) {
                x = RR_rotate(x);
            } else if (xNodeBalance < -1 && getBalance(x.right) == 1) {
                x.right = LL_rotate(x.right);
                x = RR_rotate(x);
            }
        }

        return x;
    }

    public void printTree() {
        printHelper(this.root, "", true);
    }

    public void traversal() {
        inorderTraversal(root);
        System.out.println("");
    }

    private void inorderTraversal(Node node) {
        // TODO : 중위 순회
        if (null == node) {
            return;
        }
        inorderTraversal(node.left);
        System.out.printf("%d ", node.key);
        inorderTraversal(node.right);
    }

    private void printHelper(Node x, String indent, boolean last) {
        if (x != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            System.out.println(x.key + "(h:" + x.height + ")");
            printHelper(x.left, indent, false);
            printHelper(x.right, indent, true);
        }
    }
}
