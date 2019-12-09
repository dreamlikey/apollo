package com.wdq.leetcode.algorithm;

import java.util.List;

/**
 * @author wudq
 * @date 2019/8/7
 * @Description:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class 中等_链表两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.add(4);
        l1.add(9);

        ListNode l2 = new ListNode(5);
        l2.add(6);
        l2.add(4);

        SolutionSum solution = new SolutionSum();
        // 1->1->0->8
        ListNode res = solution.addTwoNumbers(l1, l2);
        System.out.println(res);
    }


}

/**
 *
 * 思路：
 * 1、地位向高位计算，进位数带入下一次的计算中
 * 2、curr指向res的内存地址，所以curr.next与res.next是同一个对象
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SolutionSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int carryNum = 0;
        do {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int sumNum = l1Val + l2Val + carryNum;
            //进位数，要带入下一次节点计算
            carryNum = sumNum/10;
            int num = sumNum%10;
            curr.next = new ListNode(num);
            curr = curr.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        } while (l1 != null || l2 != null);

        if (carryNum > 0) {
            curr.next = new ListNode(carryNum);
        }
        return res.next;
    }

}


/**
 * 单向链表
 */
class ListNode {
    int val;
    ListNode next;
    ListNode last;
    ListNode(int x) {
        val = x;
    }

    public void add(int x) {
        if (last == null) {
            next = new ListNode(x);
            last = next;
        }else {
            last.next = new ListNode(x);
            last = last.next;
        }
    }
}

