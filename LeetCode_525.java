525. Contiguous Array
Solved
Medium
Topics
Companies
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.


SOLUTION:

class Solution {
    public int findMaxLength(int[] n) {
     HashMap<Integer ,Integer>hm = new HashMap<>();
     int len =0,sum=0;
     hm.put(0,-1);
     for(int i=0;i<n.length;i++){
        if(n[i]==0){
            sum+=-1;
        }
        if(n[i]==1){
            sum+=1;
        }
        if(!hm.containsKey(sum)){
            hm.put(sum,i);
            // System.out.print(hm);

        }
        else if(hm.containsKey(sum)) {
            len = Math.max(len,i-hm.get(sum));
            // System.out.print(i+" "+hm.get(sum)+"="+(i-hm.get(sum)));
        }
     }
     return len;
    }
}
