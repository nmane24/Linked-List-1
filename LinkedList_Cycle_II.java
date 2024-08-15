
import java.lang.classfile.components.ClassPrinter;
import java.lang.classfile.components.ClassPrinter.ListNode;

// {Approach 1}
// Time Complexity : O(n)   .. iterating over the linked list
// Space Complexity : O(1) .. no extra space used

/*
Leetcode : https://leetcode.com/problems/linked-list-cycle-ii/description/

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again 
by continuously following the next pointer. Internally, pos is used to denote the index of 
the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. 
Note that pos is not passed as a parameter.
Do not modify the linked list.


Boundary / stopping condition

1 -> 2-> 3 -> 4 -> 5-> null  ( For odd number nodes ;here fast.next != null works not fast.next.next as we will be going to null.next )
        sl          fast


1 -> 2 -> 3 -> 4 -> null ( for odd number nodes, fast != null works)
         slow       fast
*/

/*
Explaination : 
Watch video for better understanding - https://www.youtube.com/watch?v=_vmL9ixEnEo

WE mainatin slow and fast pointers , intially slow is moving by 1x and fast is moving 2x, So the moment slow and fast meet means
a cycle exists in the list, but if they dont meet means no cycle is present
Once a cycle is found, we reset any one of the pointers to head lets say fast pointer and increment them by 1x now. When they meet 
that would be the node, where the cycle starts

Derived based on Fast = a + 2b+c
Slow = a+b
So to make above equal, that is meeting point it would be a = c.
Distance from the meeting point to the starting of the cycle is equal to the the distance 
from the head to the starting point of the cycle.

*/


public class LinkedList_Cycle_II {
    
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; // both initialized to head
        ListNode fast = head;
        boolean flag = false; // flag to determing if cycle exists in list or not.

        while(fast!= null && fast.next != null){    // till fast does not reach the null or its next, this happens when 
        // there is no cycle in the list
            slow = slow.next;   // move by 1x
            fast = fast.next.next; // move by 2x

            if(slow == fast){        // this means cycle is found, so now break out of the loop
                flag = true;
                break;
            }
        }
        if(!flag) return null; // if cycle only not found return from here

        fast = head; // reset on of the pointers to head
        // Once cycle found next while loop is to find the starting point
        while(slow != fast){    // once slow is equal to fast, this means its the starting point
            slow = slow.next;
            fast = fast.next;
        }
        // once out of this while means we have detected the starting point
        return slow;
    }

}
