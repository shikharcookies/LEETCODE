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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode p=head;
        int i=0,j=0,arr[][]=new int[m][n],flag=1;//1-right, 2-down,3-left ,4-up
        int left=-1,up=0,loop=0,mn=m*n;
        while(flag>0 && loop<mn){
            int val=(p==null)?-1:p.val;
            switch(flag){
                case 1:
                    if(j+1==n){
                        flag++;
                        n--;
                        break;
                    }
                    arr[i][j]=val;
                    j++;
                    loop++;
                    if(p!=null)p=p.next;
                    break;
                case 2:
                    if(i+1==m){
                        flag++;
                        m--;
                        break;
                    }
                    arr[i][j]=val;
                    i++;
                    loop++;
                    if(p!=null)p=p.next;
                    break;
                case 3:
                    if(j-1==left){
                        flag++;
                        left++;
                        break;
                    }
                    arr[i][j]=val;
                    j--;
                    loop++;
                    if(p!=null)p=p.next;
                    break;
                case 4:
                    if(i-1==up){
                        flag=1;
                        up++;
                        break;
                    }
                    arr[i][j]=val;
                    i--;
                    loop++;
                    if(p!=null)p=p.next;
                    break;
            }
        }
        return arr;
    }
}