class Solution {
    public List<Integer> findMissingElements(int[] nums) {
List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        int expected = nums[0];

        for (int i = 0; i < nums.length; i++) {
            while (expected < nums[i]) {
                ans.add(expected);
                expected++;
            }
            expected = nums[i] + 1;
        }

        return ans;
    }
}