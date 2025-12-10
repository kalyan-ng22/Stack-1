// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain a monotonic stack to capture the nums array's index. We loop through the array twice as it's circular and use %i
// condition to handle circular check. We also check i<n so that we wont push the elements to the stack twice. We check if the peek of
// the stack is less than incoming num and pop it, add to result array and continue. In 2nd pass, we wont add to stack again, we just check
// the comparision.

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // fill with -1 intially
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * n; i++) { //circular loop
            int num = nums[i % n]; // to handle circle condition

            while (!st.isEmpty() && nums[st.peek()] < num) {
                int idx = st.pop(); //pop from stack
                res[idx] = num; //add to result array
            }

            if (i < n) { //do not push in 2nd pass
                st.push(i);
            }
        }

        return res;
    }
}
