// {Approach 1}
// Time Complexity : O(2n) == O(n) .... List is traversed two times 
// Space Complexity : O(n) ..... extra spance is used for stack
//
// {Approach 2}
// Time Complexity : O(n) 
// Space Complexity : O(n) ..... used for recursion
//
// {Approach 3}
// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/*
Leetcode : https://leetcode.com/problems/reverse-linked-list/description/
Given the head of a singly linked list, reverse the list, and return the reversed list.

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
*/


/*
Approach 1 : using extra memory space for stack

// Time Complexity : O(2n) == O(n) .... List is traversed two times 
// Space Complexity : O(n) ..... extra spance is used for stack

With two pointers we will not be able to do it, as we loose the reference to the linked list. 
So we required threee pointers, where prev ptr is at null, current ptr is at head and fast ptr is pointing to the curr.next 

Algo:
while(curr != next){
    fast = curr.next; // first store the reference to the node and next lines start changing the ptr.
    curr.next = prev;
    prev = curr;
    curr = fast;
}
*/


import java.lang.classfile.components.ClassPrinter.ListNode;

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = null;

        while(curr != null){
            fast = curr.next; // first store the reference to the ptr buy using current 
            curr.next = prev;
            prev = curr;
            curr = fast;
        }

        return prev;
    }
}


// {Approach 2}
// Using recursion
// Time Complexity : O(n) 
// Space Complexity : O(n) ..... stack used for recursion
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
//

public ListNode reverseList(ListNode head) {
    // base 
    if(head == null || head.next == null) return head;
    // this result will be returned only once from base case and will return 5 
    ListNode result = reverseList(head.next);

    head.next.next = head; // first pass : head = 4 ; 5 -> 4 ; so 5 points to 4
    head.next = null;  // 4-> null 4 now points to null
    return result

}

//Approach 3
//