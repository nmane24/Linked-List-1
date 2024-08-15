

/*
Leetcode : https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Given the head of a linked list, remove the nth node from the end of the list and return its head.
*/

/*
// {Approach 1}
// Time Complexity : O(2n) == O(n) .... List is traversed two times  
// Space Complexity : O(1) ..... extra spance is used dummy node and count which is constant.

Approach 1 : 
In first pass, total size of the node is counted.
We may need to remove the head node as well. To handle such scenario, dummy node is added
to the start of the head.

After couting the nodes; list traversal is done again to calculate (size - target) n so as to reach one 
node before the target node. Now, just set currenNode->next = currenNode->next->next;

If we are still at dummy node after the travserse, that means head is neede to be deleted. In
this case just return head->next.

*/

import java.lang.classfile.components.ClassPrinter.ListNode;

public class Remove_nth_node_from_end {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode ptr = head;
        int listSize = 0;

        //traverse the list to get the size
        while(ptr != null){
            listSize ++;
            ptr = ptr.next;
        }

        //Add dummy node to the start of the list
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // this will help us to traverse the list and reach one node before target node
        int count = listSize - n;

        ptr = dummy;
        while(count > 0){
            ptr = ptr.next;
            count --;
        }

        if(ptr == dummy) return head.next; // head itself is needed to be deleted.
        ptr.next = ptr.next.next;
        return head;

    }
}


/*
Approach 2 : Using two pointers with Window method 

Two pointers are used slow and fast. Difference between slow and fast pointers is maintained
same as number of node needed from the end.  Once the position of slow and fast is obtained , then we try to move the slow and 
fast by one positions till the fast reaches the end of the list. Once ,when fast node is at the end of the list;
slow pointer is at node node which is needed to be deleted.
So we do 2 steps here 
1. we try to maintain slow and fast ptrs such it will have n nodes between them.
2. Then we are moving both the pointers one by one.

// {Approach 2}
// Time Complexity : O(n) .. 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
*/


public class Remove_nth_node_from_end {
    //Using dummy node ( when using dummy we need to return the next from its reference)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int count = 0;  // start the counter from 0
        // first while loop to calculate and maintain the n nodes gap between fast and slow 
        while(count <=n){
            fast = fast.next;
            count ++;
        }
        //next while loop to move pointers one by one till the fast reaches the null
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        // WE found the node to be deleted, and we are one node previous to the target node which needs to be deleted
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;

        return dummy.next;
    }



    //Without Using dummy node ( we put an extra check in the first while loop and also return the head)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        int count = 0;
         // first while loop to calculate and maintain the n nodes gap between fast and slow 
        while(count <= n){
           fast = fast.next;
           if(fast == null && count <n){    // this means we already reached null and no node to move ahead, and we need to delete the head itself
                return head.next;
           }
           count++;
        }
        
        //next while loop to move pointers one by one till the fast reaches the null
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        // WE found the node to be deleted, and we are one node previous to the target node which needs to be deleted
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;

        return head;
    }

}

