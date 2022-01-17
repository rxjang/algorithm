package LeetCode;


public class SplitLinkedListinParts725 {
    public ListNode[] splitListToParts(ListNode head, int k) {

        int length = 0;
        ListNode node = head;

        while(node != null) {
            length ++;
            node = node.next;
        }

        int num = length / k;
        int remains = length % k;

        ListNode[] parts = new ListNode[k];

        ListNode partsHead = head;

        for(int i = 0; i < k && partsHead != null; i++) {
            parts[i] = partsHead;

            int size = num + (i < remains ? 1 : 0);

            for(int j = 0; j < size - 1; j++) {
                partsHead = partsHead.next;
            }
            ListNode nextNode = partsHead.next;
            partsHead.next = null;
            partsHead = nextNode;
        }
        return parts;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
