349. Intersection of Two Arrays
Solved
Easy
Topics
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

  SOLUTION:
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            hm.put(nums1[i],1);
        }
        for(int i=0;i<nums2.length;i++){
            if(hm.containsKey(nums2[i])){
                hm.put(nums2[i],hm.get(nums2[i])+1);
            }
        }
        List<Integer>l = new ArrayList<>();
        int j=0;
        for(int n : hm.keySet()){
            if(hm.get(n)>1)
            l.add(n);
        }
        int res[] = new int[l.size()];
        int i=0;
        for(int n:l) res[i++] =n;
        return res;
    }
}
