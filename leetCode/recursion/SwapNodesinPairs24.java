package leetCode.recursion;

public class SwapNodesinPairs24 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode second = head.next;
        ListNode third = head.next.next;

        second.next = head;
        head.next = swapPairs(third);

        return second;
    }

}
