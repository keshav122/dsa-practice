# Definition for singly-linked list.
from typing import Optional


class ListNode:
     def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class RotateList_61:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if(head is None or  head.next is None or k == 0):
            return head
        len = 1
        tail = head
        while(tail.next is not None):
            len+=1
            tail = tail.next
        
        k = k % len
        if(k == 0):
            return head
        newTail = head
        for i in range(len-k-1):
            newTail = newTail.next
        
        newHead = newTail.next
        newTail.next = None
        tail.next = head
        return newHead