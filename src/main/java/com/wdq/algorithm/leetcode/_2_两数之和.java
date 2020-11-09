package com.wdq.algorithm.leetcode;

/**
 * <p>Company: 成都返空汇网络技术有限公司</p>
 *
 * @author wudq
 * @date 2020/11/09
 */
public class _2_两数之和 {

    private static int count = 0;
    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        ListNode2 node = new ListNode2();
        sum(l1, l2, node);
        return node;
    }

    /**
     * 递归 逆序加法，高位到低位 依次相加进位
     * 2 4 3
     * 5 6 4
     * ------
     * 7 0 8
     *
     */
    public static void sum(ListNode2 l1, ListNode2 l2, ListNode2 node) {
        if(l1 == null && l2 == null && count == 0) return;
        l1 = l1 == null ? new ListNode2(0) : l1;
        l2 = l2 == null ? new ListNode2(0) : l2;
        int sum = l1.val + l2.val + count;
        node.val = sum % 10;
        count = sum / 10;
        if (l1.next != null || l2.next != null || count != 0) {
            node.next = new ListNode2();
        }
        sum(l1.next, l2.next, node.next);
    }



    public static void main(String[] args) {
        ListNode2 l1 = new ListNode2(9);
        l1.next = new ListNode2(9);
        l1.next.next = new ListNode2(9);
        l1.next.next.next = new ListNode2(9);
        l1.next.next.next.next = new ListNode2(9);

        ListNode2 l2 = new ListNode2(9);
        l2.next = new ListNode2(9);
        l2.next.next = new ListNode2(9);

        ListNode2 node2 = addTwoNumbers(l1, l2);
        System.out.println("l2 = " + l2);

    }

}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
