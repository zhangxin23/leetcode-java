package net.coderland.linear_list.list;

/**
 * User: zhangxin
 * Date: 2016-09-23
 * Time: 13:11:00
 */
public class HasCycle {
    /**
     * Given a linked list, determine if it has a cycle in it.
     * Follow up: Can you solve it without using extra space?
     * */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode first = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        head.setNext(first);
        first.setNext(second);
        second.setNext(third);
        third.setNext(first);

        boolean flag = new HasCycle().hasCycle(head);
        if(flag) {
            System.out.println("Has Cycle");
        } else {
            System.out.println("Not Has Cycle");
        }
    }
}
