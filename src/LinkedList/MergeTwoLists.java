package LinkedList;

/**
 * @Description:合并两个有序链表
 * @Author: wenjianli
 * @Date: 2021/6/1 20:25
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(6);
        ListNode node = mergeTwoLists(l1,l2);
        while (node !=null){
            System.out.print(node.val);
            node = node.next;
        }
    }

    // mine-通过，耗时0ms，最优解
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1!=null){
            cur.next = l1;
        }
        if (l2!=null){
            cur.next = l2;
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
