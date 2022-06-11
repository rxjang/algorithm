package leetCode;

public class AddToNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int temp = 0;
        int a = 0;
        int b = 0;

        do {
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            } else {
                a = 0;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            } else {
                b = 0;
            }
            sum = a + b + temp;
            temp = sum / 10;
            sb.append(sum % 10);
        } while (l1 != null || l2 != null);

        if (temp > 0) {
            sb.append(temp);
        }

        String ans = sb.toString();

        ListNode ln = new ListNode(sb.charAt(ans.length() - 1) - '0');

        for (int i = 1; i < ans.length(); i++) {
            temp = sb.charAt(ans.length() - 1 - i) - '0';
            ln = new ListNode(temp, ln);
        }
        return ln;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int sum = 0;

        while (l1 != null || l2 != null || sum > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(sum % 10);
            sum /= 10;
            node = node.next;
        }


        return result.next;
    }

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
