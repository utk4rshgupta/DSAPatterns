/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int len = 0 ;
        ListNode temp = head;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }
        if(len == 2 || len == 1) return new int[]{-1,-1};

        ArrayList<Integer> index = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        int i = 1;
        while(next != null){
            if(prev.val > curr.val && next.val > curr.val ){
                index.add(i);
            }
            if(prev.val<curr.val && next.val<curr.val){
                index.add(i);
            }
            i++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(index.size() == 0 || index.size() == 1) return new int[]{-1,-1};

        int Min = Integer.MAX_VALUE;
        int Max = index.get(index.size()-1) - index.get(0);
        for(int k =0;k<index.size()-1;k++){
            Min = Math.min(Min , index.get(k+1) - index.get(k));    
        }
        return new int[]{Min ,Max};

    }
}