package _2两数相加;


//简化版
class Solution2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        boolean flag = false;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1!=null||l2!=null)
        {
            int num = flag? ((l1==null)?0:l1.val)+((l2==null)?0:l2.val)+1:((l1==null)?0:l1.val)+((l2==null)?0:l2.val);
            if(num>9)
            {
                flag=true;
                ListNode node = new ListNode(num-10);
                temp.next=node;
            }
            else
            {
                flag=false;
                ListNode node = new ListNode(num);
                temp.next=node;
            }
            temp=temp.next;
            l1 = (l1==null)? l1:l1.next;
            l2 = (l2==null)? l2:l2.next;
        }
        if(flag)
        {
            temp.next=new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode nodea1 = new ListNode(9);
//        ListNode nodea2 = new ListNode(4);
//        ListNode nodea3 = new ListNode(3);
        ListNode nodeb1 = new ListNode(1);
        ListNode nodeb2 = new ListNode(9);
        ListNode nodeb3 = new ListNode(9);
        ListNode nodeb4 = new ListNode(9);
        ListNode nodeb5 = new ListNode(9);
        ListNode nodeb6 = new ListNode(9);
        ListNode nodeb7 = new ListNode(9);
        ListNode nodeb8 = new ListNode(9);
        ListNode nodeb9 = new ListNode(9);
        ListNode nodeb10 = new ListNode(9);
//        nodea1.next=nodea2;
//        nodea2.next=nodea3;
        nodeb1.next=nodeb2;
        nodeb2.next=nodeb3;
        nodeb3.next=nodeb4;
        nodeb4.next=nodeb5;
        nodeb5.next=nodeb6;
        nodeb6.next=nodeb7;
        nodeb7.next=nodeb8;
        nodeb8.next=nodeb9;
        nodeb9.next=nodeb10;
        show(nodea1);
        System.out.println();
        show(nodeb1);
        System.out.println();
        ListNode node = addTwoNumbers(nodea1,nodeb1);
        show(node);
    }

    public static void show(ListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
}