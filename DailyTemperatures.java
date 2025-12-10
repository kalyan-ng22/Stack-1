// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain a monotonic stack to capture the temperatures. When a new temperature from the array is greater than the one in the
// top of stack, we poll it and capture the index difference in the result array.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>(); // monotonic stack
        int[] res = new int[temperatures.length]; //result array
        for(int i = 0; i<temperatures.length; i++){
            while(!st.empty() && temperatures[st.peek()] < temperatures[i]){ //warmer day is found
                int re = st.pop(); //pop it
                res[re] = i - re; //capture the index difference in result array
            }
            st.push(i); //add to stack
        }
        return res;
    }
}