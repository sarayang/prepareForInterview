/**
 * Created by YANGSONG on 2018-12-02.
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class LinkedListCycle {
    public static ListNode linkedListCycle(ListNode l1, ListNode l2) {
        ListNode slow = l1;
        ListNode fast = l1.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (l1 != slow.next) {
                    l1 = l1.next;
                    slow = slow.next;
                }
                return l1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(3);
        ListNode ll4 = new ListNode(4);
        l1.next = ll1;
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll1;
        System.out.println(linkedListCycle(l1, null).val);
    }
}
