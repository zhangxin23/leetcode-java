package net.coderland.linear_list.list;

/**
 * User: zhangxin
 * Date: 2016-07-29
 * Time: 12:58:00
 */
public class CopyRandomList {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            RandomListNode next = cur.next;
            cur.next = tmp;
            tmp.next = next;
            cur = next;
        }

        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }

        cur = head;
        RandomListNode new_head = head.next;
        RandomListNode new_cur = new_head;
        while(new_cur != null) {
            cur.next = cur.next.next;
            new_cur.next = new_cur.next.next;
            cur = cur.next;
            new_cur = new_cur.next;
        }

        return new_head;
    }

    public RandomListNode initRandomList(int count) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode cur = head;
        for(int i = 0; i < count - 1; i++) {
            RandomListNode tmp = new RandomListNode(i + 2);
            cur.next = tmp;
            cur.random = tmp;
        }

        return head;
    }

    public void show(RandomListNode node) {
        while(node != null) {
            System.out.print("\t" + node.label + "\t");
        }
        System.out.println();
    }

    public static class RandomListNode {
        public int label;
        public RandomListNode next;
        public RandomListNode random;

        public RandomListNode(int x) {
            label = x;
            next = null;
            random = null;
        }
    }

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        RandomListNode head = copyRandomList.initRandomList(10);
        RandomListNode copyHead = copyRandomList.copyRandomList(head);

        System.out.println("======Head========");
        copyRandomList.show(head);

        System.out.println("=========CopyHead=========");
        copyRandomList.show(copyHead);
    }
}
