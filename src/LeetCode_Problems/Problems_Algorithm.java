package LeetCode_Problems;

import java.util.*;


public class Problems_Algorithm {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1);
        Solution.ListNode mid1 = new Solution.ListNode(2);
        Solution.ListNode mid2 = new Solution.ListNode(3);
        Solution.ListNode mid3 = new Solution.ListNode(4);
        Solution.ListNode tail = new Solution.ListNode(5);

        head.next = mid1;
        mid1.next = mid2;
//        mid2.next = mid3;
//        mid3.next = tail;

        System.out.println(solution.minimumDifference(new int[]{9,4,1,7},2));

    }
    static class Solution {

        public static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }

            public void printList() {
                System.out.print(val);
                ListNode walker = next;
            }
        }

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        public static class Node {
            public int val;
            public Node left;
            public Node right;
            public Node next;

            public Node() {}

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, Node _left, Node _right, Node _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next;
            }
        }


//
//        //Problem: Reverse an Integer: 123 ==> 321 , 10 ==> 01
//        //Date: 11/10/2020
//        public int reverse(int x) {
//            if (x == 0) return 0;
//            while (x % 10 == 0) x = x / 10;
//            if (x > -10 || x < 10) return x;
//            int No_digits = 0, sum = 0;
//            boolean Nsign = false;
//            if (x < 0) {
//                x = x * (-1);
//                Nsign = true;
//            }
//            int copy = x;
//            while (copy / 10 > 0) {
//                copy = copy / 10;
//                No_digits++;
//            }
//            int[] ary = new int[No_digits + 1];
//            copy = x;
//            No_digits = 0;
//            while (copy / 10 > 0) {
//                ary[No_digits] = copy % 10;
//                copy = copy / 10;
//                No_digits++;
//                if (No_digits == ary.length - 1) {
//                    ary[ary.length - 1] = copy;
//                    break;
//                }
//            }
//            for (int i = 0; i < ary.length; i++) sum += ary[i] * (Math.pow(10, ary.length - 1 - i));
//            if (Nsign) sum = sum * (-1);
//            if (sum <= Math.pow(-2, 31) || sum >= Math.pow(2, 31) - 1) return 0;
//            return sum;
//        } //My Solution - T(n) = O(log n), S(n) = O(log n)
//
//        public int reverse_Optimal_Solution(int x) {
//            int rev = 0;
//            while (x != 0) {
//                int pop = x % 10;
//                x /= 10;
//                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop > -8)) return 0;
//                rev = rev * 10 + pop;
//            }
//            return rev;
//        } //the Optimal Solution - T(n) = O(log n), S(n) = O(1)
//
//
//        //Problem: isPalindrome: 121 ==> true , 123 ==> false , -121 ==> false
//        //Date: 12/10/2020
//        public boolean isPalindrome(int x) {
//            if (x < 0) return false;
//            else if (x < 10) return true;
//            int copy = x, No_digits = 0;
//            while (copy != 0) {
//                copy /= 10;
//                No_digits++;
//            }
//            int[] a = new int[No_digits];
//            copy = x;
//            No_digits = 0;
//            int start = 0, end = a.length - 1;
//            while (copy != 0) {
//                a[No_digits] = copy % 10;
//                copy /= 10;
//                No_digits++;
//            }
//            while (start < end) {
//                if (a[start] != a[end]) return false;
//                start++;
//                end--;
//            }
//            return true;
//        }  //My Solution - T(n) = O(log n), S(n) = O(log n)
//
//        public boolean isPalindrome_Optimal_Solution(int x) {
//            if (x < 0 || (x % 10 == 0 && x != 0)) {
//                return false;
//            }
//            int revertedNumber = 0;
//            while (x > revertedNumber) {
//                revertedNumber = revertedNumber * 10 + x % 10;
//                x /= 10;
//            }
//            return x == revertedNumber || x == revertedNumber / 10;
//        }  //the Optimal Solution - T(n) = O(log n), S(n) = O(1)
//
//
//        //Problem: roman to int: III ==> 3, IV ==> 4, XL ==> 40, LVIII ==> 58, MCMXCIV ==> 1994
//        // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
//        // I can be placed before V (5) and X (10) to make 4 and 9.
//        // X can be placed before L (50) and C (100) to make 40 and 90.
//        // C can be placed before D (500) and M (1000) to make 400 and 900
//        //Date: 21/10/2020
//        public int romanToInt(String s) {
//            if (s.length() == 1) {
//                if (s.charAt(0) == 'I') return 1;
//                if (s.charAt(0) == 'V') return 5;
//                if (s.charAt(0) == 'X') return 10;
//                if (s.charAt(0) == 'L') return 50;
//                if (s.charAt(0) == 'C') return 100;
//                if (s.charAt(0) == 'D') return 500;
//                if (s.charAt(0) == 'M') return 1000;
//            }
//            int sum = 0;
//            for (int i = 1; i < s.length(); i++) {
//                if (s.charAt(i) == 'I') sum += 1;
//                else if (s.charAt(i) == 'V') {
//                    if (s.charAt(i - 1) == 'I') sum += 3;
//                    else sum += 5;
//                } else if (s.charAt(i) == 'X') {
//                    if (s.charAt(i - 1) == 'I') sum += 8;
//                    else sum += 10;
//                } else if (s.charAt(i) == 'L') {
//                    if (s.charAt(i - 1) == 'X') sum += 30;
//                    else sum += 50;
//                } else if (s.charAt(i) == 'C') {
//                    if (s.charAt(i - 1) == 'X') sum += 80;
//                    else sum += 100;
//                } else if (s.charAt(i) == 'D') {
//                    if (s.charAt(i - 1) == 'C') sum += 300;
//                    else sum += 500;
//                } else if (s.charAt(i) == 'M') {
//                    if (s.charAt(i - 1) == 'C') sum += 800;
//                    else sum += 1000;
//                }
//            }
//
//            if (s.charAt(0) == 'I') sum += 1;
//            if (s.charAt(0) == 'V') sum += 5;
//            if (s.charAt(0) == 'X') sum += 10;
//            if (s.charAt(0) == 'L') sum += 50;
//            if (s.charAt(0) == 'C') sum += 100;
//            if (s.charAt(0) == 'D') sum += 500;
//            if (s.charAt(0) == 'M') sum += 1000;
//
//            return sum;
//        }
//
//
//        //Problem: longest common prefix: {"flower", "flow", "flowed"} ==> longest common prefix is: "flow" <== return this
//        // {"abc", "cab", "gab"} ==> longest common prefix is: "" Null, no common between them... return "" (empty string)
//        //Date: 21/10/2020
//        public String longestCommonPrefix(String[] strs) {
//            if (strs.length == 0) return "";
//            if (strs.length == 1) return strs[0];
//            String CommonPrefix = "";
//            boolean exist = false;
//            for (int i = 0; i < strs[0].length(); i++) {
//                char temp = strs[0].charAt(i);
//                for (int j = 1; j < strs.length; j++) {
//                    exist = false;
//                    if (i >= strs[j].length()) {
//                        i = strs[0].length();
//                        break;
//                    }
//                    if (strs[j].charAt(i) == temp) {
//                        exist = true;
//                    } else break;
//                }
//                if (exist) CommonPrefix += temp;
//                else break;
//            }
//            return CommonPrefix;
//        }
//
//        public String longestCommonPrefix_OptimalSolution(String[] strs) {
//            if (strs.length == 0) return "";
//            String prefix = strs[0];
//            for (int i = 1; i < strs.length; i++)
//                while (strs[i].indexOf(prefix) != 0) {
//                    prefix = prefix.substring(0, prefix.length() - 1);
//                    if (prefix.isEmpty()) return "";
//                }
//            return prefix;
//        }
//
//
//        //Problem: Valid Parentheses: () ==> true, (} ==> false, ({[]}) ==> true, ([)] ==> false
//        // s contains only __'(', '[', '{', '}', ']', ')'__
//        //Date 23/10/2020
//        public boolean isValid(String s) {
//            if (s.length() % 2 != 0) return false;
//            StringBuilder sb = new StringBuilder(s);
//            int length = s.length();
//            for (int i = 0; i < sb.length() - 1; i++) {
//                if (sb.toString().charAt(i) == '(' && (sb.toString().charAt(i + 1) == ']' || sb.toString().charAt(i + 1) == '}')) {
//                    return false;
//                } else if (sb.toString().charAt(i) == '[' && (sb.toString().charAt(i + 1) == ')' || sb.toString().charAt(i + 1) == '}')) {
//                    return false;
//                } else if (sb.toString().charAt(i) == '{' && (sb.toString().charAt(i + 1) == ']' || sb.toString().charAt(i + 1) == ')')) {
//                    return false;
//                }
//
//                if (sb.toString().charAt(i) == '(' && sb.toString().charAt(i + 1) == ')') {
//                    sb.deleteCharAt(i);
//                    sb.deleteCharAt(i);
//                    if (i == 1) i -= 1;
//                    if (i >= 2) i -= 2;
//                    i--;
//                    continue;
//                }
//                if (sb.toString().charAt(i) == '[' && sb.toString().charAt(i + 1) == ']') {
//                    sb.deleteCharAt(i);
//                    sb.deleteCharAt(i);
//                    if (i == 1) i -= 1;
//                    if (i >= 2) i -= 2;
//                    i--;
//                    continue;
//                }
//                if (sb.toString().charAt(i) == '{' && sb.toString().charAt(i + 1) == '}') {
//                    sb.deleteCharAt(i);
//                    sb.deleteCharAt(i);
//                    if (i == 1) i -= 1;
//                    if (i >= 2) i -= 2;
//                    i--;
//                    continue;
//                }
//
//            }
//            return sb.length() == 0;
//        }
//
//        // Hash table that takes care of the mappings.
//        private HashMap<Character, Character> mappings;
//
//        // Initialize hash map with mappings. This simply makes the code easier to read.
//        public Solution() {
//            this.mappings = new HashMap<Character, Character>();
//            this.mappings.put(')', '(');
//            this.mappings.put('}', '{');
//            this.mappings.put(']', '[');
//        }
//
//        public boolean isValid_OptimalSolution(String s) {
//
//            // Initialize a stack to be used in the algorithm.
//            Stack<Character> stack = new Stack<Character>();
//
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//
//                // If the current character is a closing bracket.
//                if (this.mappings.containsKey(c)) {
//
//                    // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
//                    char topElement = stack.empty() ? '#' : stack.pop();
//
//                    // If the mapping for this bracket doesn't match the stack's top element, return false.
//                    if (topElement != this.mappings.get(c)) {
//                        return false;
//                    }
//                } else {
//                    // If it was an opening bracket, push to the stack.
//                    stack.push(c);
//                }
//            }
//
//            // If the stack still contains elements, then it is an invalid expression.
//            return stack.isEmpty();
//        }   //Optimal Solution T(n) = n, S(n) = n
//
//
//        //Problem: Merge to sorted lists [1,2,4] + [3,5,8] = [1,2,3,4,5,8]
//        //Date: 23/10/2020
//        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//            if (l1 == null) {
//                return l2;
//            }
//            if (l2 == null) {
//                return l1;
//            }
//            ListNode l3;
//            ListNode tail;
//            if (l1.val < l2.val) {
//                l3 = l1;
//                tail = l3;
//                l1 = l1.next;
//            } else {
//                l3 = l2;
//                tail = l3;
//                l2 = l2.next;
//            }
//            while (l1 != null && l2 != null) {
//                if (l1.val < l2.val) {
//                    tail.next = l1;
//                    tail = tail.next;
//                    l1 = l1.next;
//                } else {
//                    tail.next = l2;
//                    tail = tail.next;
//                    l2 = l2.next;
//                }
//            }
//            if (l1 == null) {
//                tail.next = l2;
//            } else {
//                tail.next = l1;
//            }
//
//
//            return l3;
//        }
//
//
//        //Problem: Remove Duplicates from Sorted Array:
//        //[0,1,1,2,2,3,4,4] ==> [0,1,2,3,4,...] length 5(the length for the sorted part of the array) It doesn't matter what you leave beyond the returned length.
//        //You should use O(1) Space Complexity {-Modify the given array-}
//        //Date: 23/10/2020
//        public int removeDuplicates(int[] nums) {
//            if (nums.length == 0) return 0;
//            if (nums.length == 1) return 1;
//            int counter = 1, current = nums[0];
//            for (int i = 1; i < nums.length; i++) {
//                if (nums[i] > current) {
//                    current = nums[i];
//                    swap_removeDuplicates(counter++, i, nums);
//                }
//            }
//            return counter;
//        }
//
//        void swap_removeDuplicates(int Ia, int Ib, int[] arr) {
//            int temp = arr[Ia];
//            arr[Ia] = arr[Ib];
//            arr[Ib] = temp;
//        }
//
//
//        //Problem: Remove element from an array, you should return the length for the part of the array that doesn't include the removed value
//        //[0,1,2,2,4,0,6,2,2,3] [2] ==> [0,1,4,0,6,3] length = 6 <== return this
//        //[3,2,2,3] [3] ==> [2,2,3,3] length = 2 <== return this
//        //Date: 23/10/2020
//        public int removeElement(int[] nums, int val) {
//            if (nums.length == 0) return 0;
//            if (nums.length == 1 && nums[0] == val) return 0;
//
//            int counter = 0, removeIndex = 0;
//            boolean found = false;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != val) counter++;
//                if (nums[i] == val && !found) {
//                    removeIndex = i;
//                    found = true;
//                } else if (nums[i] != val && found) {
//                    swap_removeElement(removeIndex++, i, nums);
//                }
//            }
//            return counter;
//        }
//
//        void swap_removeElement(int Ia, int Ib, int[] arr) {
//            int temp = arr[Ia];
//            arr[Ia] = arr[Ib];
//            arr[Ib] = temp;
//        }
//
//
//        //Problem: Implementation of IndexOf(SubString) method (returns the index of the first occurrence of the SubString) String:"hello",SubString"ll" ==> the Index: 2
//        //if SubString is empty return 0, if Not-found return -1
//        //Date: 23/10/2020
//        public int strStr(String haystack, String needle) {
//            if (needle.length() == 0) return 0;
//            if (haystack.length() == 0) return -1;
//
//            int point = 0;
//            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
//                if (haystack.charAt(i) == needle.charAt(point)) {
//                    int[] possibility = checkingPossibility(haystack, needle, i);
//                    if (possibility[1] == 1) return i;
//                    else continue;
//                }
//            }
//            return -1;
//        }
//
//        public int[] checkingPossibility(String haystack, String needle, int start) {
//            for (int i = 0; i < needle.length(); i++) {
//                if (haystack.charAt(start++) != needle.charAt(i)) {
//                    return new int[]{i, 0};
//                }
//            }
//            return new int[]{start, 1};
//        }
//
//
//        //Problem: given a sorted distinct element array and a target
//        //Return the target index in the array and if it's not found return where it should be
//        //Date: 24/10/2020
//        public int searchInsert(int[] nums, int target) {
//            return BinarySearch(nums, 0, nums.length - 1, target);
//        }
//
//        public int BinarySearch(int[] a, int s, int e, int t) {
//            if (a.length == 0) return 0;
//            if (s == e && a[s] < t) return s + 1;
//            if (s == e && a[s] == t) return s;
//            if (s == e && a[s] > t) return s;
//            if (t > a[e]) return e + 1;
//            if (t < a[s]) return s;
//            if (a[s] == t) return s;
//            if (a[e] == t) return e;
//            int m = (e + s) / 2;
//            if (a[m] == t) return m;
//            else if (t > a[m]) return BinarySearch(a, m + 1, e, t);
//            else return BinarySearch(a, s, m - 1, t);
//
//        }
//
//
//        //Problem: Salah can climb one or two stairs each step, return how many ways he can climb the stair
//        // if we have a stair from 4 stairs he can climb: [1,1,1,1] [1,1,2] [2,1,1] [1,2,1] [2,2]. Return 5 cus can climb them in 5 ways
//        //Date: 28/10/2020
//        public int climbStairs(int n) {
//            if (n == 0) return 0;
//            if (n == 1) return 1;
//            int[] a = new int[n];
//            a[0] = 1;
//            a[1] = 2;
//            for (int i = 2; i < n; i++) {
//                a[i] = a[i - 1] + a[i - 2];
//            }
//            return a[n - 1];
//        }
//
//
//        //Problem: Get Maximum SubArray
//        //Date: 28/10/2020
//        public int maxSubArray(int[] nums) {
//            if (nums.length == 1) return nums[0];
//            int max = nums[0], temp_max = nums[0];
//            for (int i = 1; i < nums.length; i++) {
//                if (temp_max + nums[i] > nums[i]) temp_max += nums[i];
//                else temp_max = nums[i];
//                max = Math.max(max, temp_max);
//            }
//            return max;
//        }
//
//
//        //Problem: Length of last word: "Hel World  " return ==> 5(length of "World")
//        // "a " return ==> 1(length of "a")
//        //Spaces ' ' are not count so we return the last word we see
//        //Date: 29/10/2020
//        public int lengthOfLastWord(String s) {
//            if (s.length() == 0) return 0;
//            int counter = 0;
//            boolean space = false;
//            for (int i = s.length() - 1; i >= 0; i--) {
//                if (s.charAt(i) != ' ') {
//                    counter++;
//                    space = true;
//                } else if (space)
//                    return counter;
//            }
//            return counter;
//        }
//
//
//        //Problem: Imagine the given array as a number, and you have to plus 1 to this number and return the new array
//        //Given a non-empty array of digits representing a non-negative integer
//        //the Given array it's elements is only one digit: 0 <= digit[i] >= 9
//        // take: [1,2,3] return [1,2,4], take: [4,3,2,1] return [4,3,2,2], take: [9,9,9] return [1,0,0,0]
//        //Date: 29/10/2020
//        public int[] plusOne(int[] digits) {
//            for (int i = digits.length - 1; i >= 0; i--) {
//                if (digits[i] != 9) {
//                    digits[i] += 1;
//                    return digits;
//                } else
//                    digits[i] = 0;
//            }
//            int[] res = new int[digits.length + 1];
//            res[0] = 1;
//            return res;
//        }
//
//
//        //Problem: add two Binary: "1101" + "100" = "10001"
//        //Date: 2/11/2020
//        public String addBinary(String a, String b) {
//            String result = "";
//            int s = 0;
//            int i = a.length() - 1, j = b.length() - 1;
//            while (i >= 0 || j >= 0 || s == 1) {
//                s += ((i >= 0) ? a.charAt(i) - '0' : 0);
//                s += ((j >= 0) ? b.charAt(j) - '0' : 0);
//
//                // If current digit sum is
//                // 1 or 3, add 1 to result
//                result = (char) (s % 2 + '0') + result;
//
//                // Compute carry
//                s /= 2;
//
//                i--;
//                j--;
//            }
//            return result;
//        }
//
//
//        //Problem: Calculate the root of x: 9 => 3, 100 => 10, 8 => 2, 5 => 2
//        //Date: 2/11/2020
//        public int mySqrt(int x) {
//            if (x <= 1) return x;
//            int start = 1, end = x / 2;
//            while (start < end) {
//                if (x / start == start) return start;
//                if (x / end == end) return end;
//                int mid = ((start + end) / 2) + 1;
//                if (x / mid == mid) return mid;
//                if (x / mid > mid) start = mid;
//                else end = mid - 1;
//            }
//            return start;
//        }
//
//
//        //Problem: remove duplicated elements fro singly linked list: [1 -> 1 -> 2 -> 3 -> 3] ==> [1 -> 2 -> 3]
//        //Date: 2/11/2020
//        public ListNode deleteDuplicates(ListNode head) {
//            if (head == null) return new ListNode();
//            ListNode h = head, walker = head;
//
//            while (walker.next != null) {
//                if (walker.val == walker.next.val) {
//                    walker.next = walker.next.next;
//                } else
//                    walker = walker.next;
//            }
//            return h;
//        }
//
//
//        //Problem: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array
//        //The number of elements initialized in nums1 and nums2 are m and n respectively.
//        //You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
//        //nums1 = [1,2,3,0,0,0], m = 3
//        //nums2 = [2,5,6],       n = 3
//        //Output: [1,2,2,3,5,6]
//        //Date: 3/11/2020
//        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            int[] ans = new int[m + n];
//            int p1 = 0, p2 = 0, ans_p = 0;
//            while (p1 < m && p2 < n) {
//                if (nums1[p1] <= nums2[p2]) {
//                    ans[ans_p++] = nums1[p1++];
//                } else {
//                    ans[ans_p++] = nums2[p2++];
//                }
//            }
//            while (p1 < m) {
//                ans[ans_p++] = nums1[p1++];
//            }
//            while (p2 < n) {
//                ans[ans_p++] = nums2[p2++];
//            }
//            p1 = 0;
//            for (int e : ans)
//                nums1[p1++] = e;
//        }
//
//        public void merge_Optimal(int[] nums1, int m, int[] nums2, int n) {
//            int i = m - 1, j = n - 1, k = m + n - 1;
//
//            while (i >= 0 && j >= 0) {
//                if (nums1[i] > nums2[j])
//                    nums1[k--] = nums1[i--];
//                else
//                    nums1[k--] = nums2[j--];
//            }
//
//            while (i >= 0)
//                nums1[k--] = nums1[i--];
//            while (j >= 0)
//                nums1[k--] = nums2[j--];
//        } //The same with my idea but with efficient space  S(n) = O(1)
//
//
//        //Problem: Rearrange the String s characters according to the array indices
//        // s = "art" , indices = [1,0,2] ===> "rat"
//        //the n'th character in the string should be in the induces[n] place then return the rearranged string
//        //Date: 3/11/2020
//        public String restoreString(String s, int[] indices) {
//            char[] correct_string = new char[indices.length];
//            int pointer = 0;
//            for (int e : indices)
//                correct_string[e] = s.charAt(pointer++);
//            return new String(correct_string);
//        }
//
//
//        //Problem: Given a string s. You should re-order the string using the following algorithm:
//        //
//        // 1-   Pick the smallest character from s and append it to the result.
//        // 2-   Pick the smallest character from s which is greater than the last appended character to the result and append it.
//        // 3-   Repeat step 2 until you cannot pick more characters.
//        // 4-   Pick the largest character from s and append it to the result.
//        // 5-   Pick the largest character from s which is smaller than the last appended character to the result and append it.
//        // 6-   Repeat step 5 until you cannot pick more characters.
//        // 7-   Repeat the steps from 1 to 6 until you pick all characters from s.
//        //
//        //In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
//        //
//        //Return the result string after sorting s with this algorithm.
//        //
//        //Date: 5/11/2020
//        public String sortString(String s) {
//            int start = 25;
//            int end = 0;
//            int[] map = new int[26];
//
//            for (char c : s.toCharArray()) {
//                if (c - 'a' < start) start = c - 'a';
//                if (c - 'a' > end) end = c - 'a';
//                map[c - 'a']++;
//            }
//
//            int count = s.length(), j = 0;
//            char[] c = new char[count];
//            while (count > 0) {
//                for (int i = start; i <= end; i++)
//                    if (map[i]-- > 0) {
//                        c[j++] = (char) (i + 'a');
//                        count--;
//                    }
//
//                for (int i = end; i >= start; i--)
//                    if (map[i]-- > 0) {
//                        c[j++] = (char) (i + 'a');
//                        count--;
//                    }
//            }
//            return new StringBuilder().append(c).toString();
//        }
//
//
//        //Problem:Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
//        //Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.
//        //
//        //Date: 6/11/2020
//        public boolean canMakeArithmeticProgression(int[] arr) {
//            Arrays.sort(arr);
//            int jump = arr[0] - arr[1];
//            for (int i = 1; i < arr.length - 1; i++) {
//                if (arr[i] - arr[i + 1] != jump)
//                    return false;
//            }
//            return true;
//        }
//
//
//        //Given the array nums, obtain a subsequence of the array whose sum of elements is strictly greater than the sum of the non included elements in such subsequence.
//        //
//        //If there are multiple solutions, return the subsequence with minimum size and if there still exist multiple solutions, return the subsequence with the maximum total sum of all its elements. A subsequence of an array can be obtained by erasing some (possibly zero) elements from the array.
//        //
//        //Note that the solution with the given constraints is guaranteed to be unique. Also return the answer sorted in non-increasing order.
//        //
//        //Date: 6/11/2020
//        public List<Integer> minSubsequence(int[] nums) {
//            List<Integer> l = new ArrayList<>();
//            Arrays.sort(nums);
//            int sum = 0, SubSequence = 0, i;
//            for (int e : nums) sum += e;
//            for (i = nums.length - 1; i >= 0; i--) {
//                if (SubSequence + nums[i] <= sum - nums[i]) {
//                    SubSequence += nums[i];
//                    sum -= nums[i];
//                    l.add(nums[i]);
//                } else {
//                    break;
//                }
//            }
//            l.add(nums[i]);
//            return l;
//        }
//
//        public List<Integer> minSubsequence_Optimal(int[] nums) {
//            List<Integer> l = new ArrayList();
//            int[] arr = new int[100];
//            int max = -1, sum = 0, sub_sum = 0;
//            for (int e : nums) {
//                sum += e;
//                arr[e - 1]++;
//                if (e > max) max = e;
//            }
//            for (int i = max - 1; i >= 0; i--) {
//                if (arr[i] > 0) {
//                    while (arr[i] > 0 && sub_sum <= sum) {
//                        l.add(i + 1);
//                        arr[i]--;
//                        sub_sum += i + 1;
//                        sum -= i + 1;
//                    }
//                    if (sub_sum > sum) return l;
//                }
//            }
//            return l;
//        }
//
//
//        //Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
//        //
//        //Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
//        //
//        //You may return any answer array that satisfies this condition.
//        //
//        //Date: 6/11/2020
//        public int[] sortArrayByParityII(int[] A) {
//            int[] arr = new int[A.length];
//            int even_pointer = 0, odd_pointer = 1;
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] % 2 == 0) {
//                    arr[even_pointer] = A[i];
//                    even_pointer += 2;
//                } else {
//                    arr[odd_pointer] = A[i];
//                    odd_pointer += 2;
//                }
//            }
//            return arr;
//        }
//
//        public int[] sortArrayByParityII_Optimal(int[] A) {
//            int even_pointer = 0;
//            int odd_pointer = 1;
//            while (even_pointer < A.length) {
//                if ((A[even_pointer] & 1) != 0) { //this line: check if A[even_pointer] is even or not
//                    while ((A[odd_pointer] & 1) == 1) {   //this line: check if A[odd_pointer] is odd or not
//                        odd_pointer += 2;
//                    }
//                    int t = A[even_pointer];
//                    A[even_pointer] = A[odd_pointer];
//                    A[odd_pointer] = t;
//                    odd_pointer += 2;
//                }
//                even_pointer += 2;
//            }
//            return A;
//        }
//
//
//        //Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
//        //
//        //Return the sorted array.
//        //
//        //Date: 6/11/2020
//        public int[] sortByBits(int[] arr) {
//            Arrays.sort(arr);
//            int[] bitCount = new int[14];
//            for (int e : arr)
//                bitCount[Integer.bitCount(e)]++;
//
//            int[] fillWithStartPosition = new int[14];
//            fillWithStartPosition[0] = 0;
//            for (int i = 1; i < fillWithStartPosition.length; i++) {
//                fillWithStartPosition[i] =
//                        fillWithStartPosition[i - 1] + bitCount[i - 1];
//            }
//
//            int[] result = new int[arr.length];
//            for (int i = 0; i < arr.length; i++) {
//                result[fillWithStartPosition[Integer.bitCount(arr[i])]++] = arr[i];
//            }
//
//            return result;
//        }
//
//        public int[] sortByBits_Optimal(int[] arr) {
//            quickSort(arr, 0, arr.length - 1);
//            return arr;
//        }
//
//        public void quickSort(int[] arr, int l, int r) {
//            if (r <= l) {
//                return;
//            }
//            int pivot = Integer.bitCount(arr[r]), idx = l;
//            for (int i = l; i < r; i++) {
//                int tmp = Integer.bitCount(arr[i]);
//                if (tmp < pivot || (tmp == pivot && arr[i] < arr[r])) {
//                    swap(idx++, i, arr);
//                }
//            }
//            swap(idx, r, arr);
//            quickSort(arr, l, idx - 1);
//            quickSort(arr, idx + 1, r);
//
//        }
//
//        public void swap(int i, int j, int[] arr) {
//            int numTmp = arr[j];
//            arr[j] = arr[i];
//            arr[i] = numTmp;
//        }
//
//
//        //Given an array of unique integers salary where salary[i] is the salary of the employee i.
//        //
//        //Return the average salary of employees excluding the minimum and maximum salary.
//        //
//        //Date: 6/11/2020
//        public double average(int[] salary) {
//            int min = salary[0], max = salary[0], n = salary.length;
//            long sum = salary[0];
//            for (int i = 1; i < n; i++) {
//                if (salary[i] < min) min = salary[i];
//                if (salary[i] > max) max = salary[i];
//                sum += salary[i];
//            }
//            return (sum - max - min) * 1.0 / (n - 2);
//        }
//
//
//        //Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//        //
//        //Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
//        //
//        //Date: 6/11/2020
//        public int[] relativeSortArray(int[] arr1, int[] arr2) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int x : arr1) map.put(x, map.getOrDefault(x, 0) + 1);
//
//            int index = 0;
//            for (int i = 0; i < arr2.length; i++) {
//                int freq = map.get(arr2[i]);
//                for (int j = 0; j < freq; j++) arr1[index++] = arr2[i];
//                map.remove(arr2[i]);
//            }
//
//            // now add remaining to list to be sorted
//            List<Integer> remaining = new ArrayList<>();
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                for (int i = 0; i < entry.getValue(); i++) remaining.add(entry.getKey());
//            }
//
//            Collections.sort(remaining);
//            for (int i = 0; i < remaining.size(); i++) arr1[index++] = remaining.get(i);
//
//            return arr1;
//        }
//
//        public int[] relativeSortArray_BetterOne(int[] arr1, int[] arr2) {
//            int[] map = new int[1001];
//            int[] res = new int[arr1.length];
//            int pointer = 0;
//            for (int e : arr1) map[e]++;
//
//            for (int e : arr2) {
//                while (map[e] > 0) {
//                    res[pointer++] = e;
//                    map[e]--;
//                }
//            }
//            for (int i = 0; i < 1001; i++)
//                while (map[i] > 0) {
//                    res[pointer++] = i;
//                    map[i]--;
//                }
//            return res;
//        }
//
//
//        //Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
//        //
//        //Return the sorted array.
//        //
//        //Date: 13/11/2020
//        public int[] frequencySort(int[] nums) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//            int n = nums.length;
//
//            for (int num : nums) {
//                map.put(num, map.getOrDefault(num, 0) + 1);
//            }
//            Integer[] sorted = new Integer[n];
//            for (int i = 0; i < n; i++) {
//                sorted[i] = nums[i];
//            }
//            Arrays.sort(sorted, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer a, Integer b) {
//                    if (map.get(a) == map.get(b)) {
//                        return b.compareTo(a);
//                    }
//                    return map.get(a) - map.get(b);
//                }
//            });
//            return Arrays.stream(sorted).mapToInt(Integer::intValue).toArray();
//        }
//
//        public int[] frequencySort_faster(int[] nums) {
//            int min = 0, max = 0;
//            for (int i = 0; i < nums.length; ++i) {
//                if (nums[i] < min) {
//                    min = nums[i];
//                }
//                if (nums[i] > max) {
//                    max = nums[i];
//                }
//            }
//            int[] count = new int[max - min + 1];
//            int maxfreq = 0;
//            for (int i = 0; i < nums.length; ++i) {
//                int j = nums[i] - min;
//                count[j]++;
//                if (count[j] > maxfreq) maxfreq = count[j];
//            }
//            List<Integer>[] freq = new ArrayList[maxfreq + 1];
//            for (int i = count.length - 1; i >= 0; --i) {
//                if (count[i] == 0) {
//                    continue;
//                }
//                if (freq[count[i]] == null) {
//                    freq[count[i]] = new ArrayList<>();
//                }
//                freq[count[i]].add(i + min);
//            }
//            int k = 0;
//            for (int i = 0; i <= maxfreq; ++i) {
//                if (freq[i] == null) {
//                    continue;
//                }
//                for (int x : freq[i]) {
//                    for (int j = 0; j < i; ++j) {
//                        nums[k++] = x;
//                    }
//                }
//            }
//            return nums;
//        }
//
//
//        //Given two arrays, write a function to compute their intersection.
//        //
//        //Input: nums1 = [1,2,2,1], nums2 = [2,2]
//        //Output: [2]
//        //
//        //Date: 13/11/2020
//        public int[] intersection(int[] nums1, int[] nums2) {
//            if (nums1.length <= 0 || nums2.length < 0) {
//                return new int[]{};
//            }
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < nums1.length; i++) {
//                max = Math.max(nums1[i], max);
//            }
//            int a[] = new int[max + 1];
//            int b[] = new int[Math.min(nums1.length, nums2.length)];
//            int j = 0;
//            for (int i = 0; i < nums1.length; i++) {
//                a[nums1[i]] = 1;
//            }
//            for (int i = 0; i < nums2.length; i++) {
//                if (nums2[i] <= max && a[nums2[i]] == 1) {
//                    a[nums2[i]] = 0;
//                    b[j++] = nums2[i];
//                }
//            }
//            int c[] = new int[j];
//            for (int i = 0; i < j; i++) {
//                c[i] = b[i];
//            }
//            return c;
//        }
//
//        public int[] intersection_new(int[] nums1, int[] nums2) {
//            if (nums1.length == 0 || nums2.length == 0) return new int[]{};
//
//            HashSet<Integer> ans = new HashSet<>();
//
//            HashSet<Integer> set1 = new HashSet<>();
//            for (int e : nums1) set1.add(e);
//
//            for (int e : nums2)
//                if (set1.contains(e) && !ans.contains(e)) {
//                    ans.add(e);
//                }
//            int pointer = 0;
//            int[] res = new int[ans.size()];
//            for (int e : ans) {
//                res[pointer++] = e;
//            }
//            return res;
//        }
//
//
//        //Date: 16/11/2020
//        public int largestPerimeter(int[] A) {
//            Arrays.sort(A);
//            for (int i = A.length - 1; i >= 2; i--) {
//                if (A[i] < A[i - 1] + A[i - 2]) {
//                    return A[i] + A[i - 1] + A[i - 2];
//                }
//            }
//            return 0;
//        }
//
//        public int largestPerimeter_fasterOne(int[] A) {
//            // find largest value a
//            // find next largest value b
//            // find next largest value c
//
//            // if b + c > a, return else
//            // discard a, find next largest value d and keep checking
//            // if there are no more values, return 0
//
//            int a = 0;
//            int aindex = 0;
//            int b = 0;
//            int bindex = 0;
//            int c = 0;
//            int cindex = 0;
//
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] > a) {
//                    a = A[i];
//                    aindex = i;
//                }
//            }
//
//            A[aindex] = -1;
//
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] > b) {
//                    b = A[i];
//                    bindex = i;
//                }
//            }
//
//            A[bindex] = -1;
//
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] > c) {
//                    c = A[i];
//                    cindex = i;
//                }
//            }
//
//            A[cindex] = -1;
//
//            while (b + c <= a) {
//                a = b;
//                b = c;
//                c = -1;
//
//                for (int i = 0; i < A.length; i++) {
//                    if (A[i] > c) {
//                        c = A[i];
//                        cindex = i;
//                    }
//                }
//
//                A[cindex] = -1;
//
//                if (c == -1) {
//                    return 0;
//                }
//            }
//
//            return a + b + c;
//        }
//
//
//        //Date: 16/11/2020
//        public boolean isAnagram(String s, String t) {
//            int[] s_arr = new int[26];
//            int n = s.length(), m = t.length();
//            if (n != m) return false;
//            for (int i = 0; i < n; i++) {
//                s_arr[s.charAt(i) - 'a']++;
//            }
//            for (int i = 0; i < m; i++) {
//                s_arr[t.charAt(i) - 'a']--;
//                if (s_arr[t.charAt(i) - 'a'] < 0)
//                    return false;
//            }
//            return true;
//        }
//
//
//        //Date: 17/11/2020
//        public int[] intersect(int[] nums1, int[] nums2) {
//            if (nums1.length == 0 || nums2.length == 0) return new int[]{};
//
//            HashMap<Integer, Integer> arr1 = new HashMap<>();
//            List<Integer> l = new ArrayList<>();
//
//            for (int e : nums1) arr1.put(e, arr1.getOrDefault(e, 0) + 1);
//
//            for (int i = 0; i < nums2.length; i++) {
//                if (arr1.containsKey(nums2[i])) {
//                    int freq = arr1.get(nums2[i]);
//                    if (freq >= 1) {
//                        l.add(nums2[i]);
//                        arr1.put(nums2[i], --freq);
//                    }
//                }
//            }
//            int[] ans = new int[l.size()];
//            for (int i = 0; i < ans.length; i++) ans[i] = l.get(i);
//            return ans;
//        }
//
//        public int[] intersect_OtherSolution(int[] nums1, int[] nums2) {
//            if (nums1.length == 0 || nums2.length == 0) return new int[]{};
//            Arrays.sort(nums1);
//            Arrays.sort(nums2);
//            int pointer1 = 0, pointer2 = 0, ansPointer = 0;
//            int[] ans = new int[Math.min(nums1.length, nums2.length)];
//            for (; pointer1 < nums1.length && pointer2 < nums2.length; ) {
//                if (nums1[pointer1] == nums2[pointer2]) {
//                    ans[ansPointer++] = nums1[pointer1];
//                    pointer1++;
//                    pointer2++;
//                } else if (nums1[pointer1] > nums2[pointer2]) pointer2++;
//                else pointer1++;
//            }
//            return Arrays.copyOf(ans, ansPointer);
//        }
//
//
//        //Date: 19/11/2020
//        public boolean canFormArray(int[] arr, int[][] pieces) {
//            HashSet<Integer> set = new HashSet<>();
//            for (int e : arr) set.add(e);
//
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < arr.length; i++) {
//                map.put(arr[i], i);
//            }
//
//            for (int i = 0; i < pieces.length; i++) {
//                if (pieces[i].length == 1) {
//                    if (!set.contains(pieces[i][0])) return false;
//                } else {
//                    if (!set.contains(pieces[i][0])) return false;
//                    int index = map.get(pieces[i][0]);
//                    if (arr.length - index < pieces[i].length) return false;
//                    for (int j = 0; j < pieces[i].length; j++) {
//                        if (arr[index++] != pieces[i][j]) return false;
//                    }
//                }
//            }
//            return true;
//        }
//
//        public boolean canFormArray_FasterSolution(int[] arr, int[][] pieces) {
//            int[] table = new int[101];
//            for (int i = 0; i < pieces.length; i++) {
//                table[pieces[i][0]] = i + 1;
//            }
//
//            int index, count = 0;
//            for (int i = 0; i < arr.length; ) {
//                if ((index = table[arr[i]] - 1) < 0) {
//                    return false;
//                }
//                for (int j = 0; j < pieces[index].length; j++, i++) {
//                    if (i >= arr.length || arr[i] != pieces[index][j]) {
//                        return false;
//                    }
//                }
//                count++;
//            }
//            return count == pieces.length;
//        }
//
//
//        public String removeOuterParentheses(String S) {
//            if (S.isEmpty() == true) return "";
//            char[] s = S.toCharArray();
//            Stack<Character> stack = new Stack<>();
//            int start = 0, end = s.length - 1;
//            for (int i = 0; i <= end; i++) {
//                if (s[i] == '(') {
//                    stack.push('(');
//                }
//                if (s[i] == ')') {
//                    stack.pop();
//                }
//                if (stack.isEmpty()) {
//                    for (int j = start; j < i - 1; j++) {
//                        s[j] = s[j + 1];
//                    }
//                    for (int j = i - 1; j <= end - 2; j++) {
//                        s[j] = s[j + 2];
//                    }
//                    start = i;
//                    end -= 2;
//                    i -= 2;
//                }
//            }
//            String res = new String();
//            for (int i = 0; i <= end; i++) res += s[i];
//            return res;
//        }
//
//        public String removeOuterParentheses_FasterSolution(String S) {
//            StringBuilder sb = new StringBuilder();
//            int start = 0;
//            for (char e : S.toCharArray()) {
//                if (e == '(') {
//                    start++;
//                    if (start > 1)
//                        sb.append(e);
//                } else {
//                    start--;
//                    if (start > 0)
//                        sb.append(e);
//                }
//            }
//            return sb.toString();
//        }
//
//
//        // calculate an equation consist only from '+' or '-' or '*' and numbers with one digit
//        // ex: System.out.println(calc("5 - 1 + 2 * 3 - 4 * 5 - 1 + 2 - 8"));
//        public static boolean isOperation(String element) {
//            if (element.length() != 1) return false;
//            char ch = element.charAt(0);
//            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') return true;
//            return false;
//        }
//
//        public static double newCalc(String equation) {
//
//            Map<Character, Integer> priorityMap = new HashMap<>();
//            priorityMap.put('+', 1);
//            priorityMap.put('-', 1);
//            priorityMap.put('*', 2);
//            priorityMap.put('/', 2);
//
//            String[] equationElements = equation.split(" ");
//            Stack<Double> numbers = new Stack<>();
//            Stack<Character> operations = new Stack<>();
//
//            for (int i = 0; i < equationElements.length; i++) {
//                if (isOperation(equationElements[i])) {
//                    char ch = equationElements[i].charAt(0);
//                    if (!operations.isEmpty() && (priorityMap.get(ch) >= priorityMap.get(operations.peek()))) {
//                        while (!operations.isEmpty()) {
//                            double b = numbers.pop(), a = numbers.pop();
//                            char op = operations.pop();
//                            switch (op) {
//                                case '+':
//                                    numbers.add(a + b);
//                                    break;
//                                case '-':
//                                    numbers.add(a - b);
//                                    break;
//                                case '*':
//                                    numbers.add(a * b);
//                                    break;
//                                case '/':
//                                    numbers.add(a / b);
//                            }
//                        }
//                    }
//                    operations.add(equationElements[i].charAt(0));
//                } else {
//                    numbers.add(Double.parseDouble(equationElements[i]));
//                }
//            }
//
//            while (!operations.isEmpty()) {
//                double b = numbers.pop(), a = numbers.pop();
//                char op = operations.pop();
//                switch (op) {
//                    case '+':
//                        numbers.add(a + b);
//                        break;
//                    case '-':
//                        numbers.add(a - b);
//                        break;
//                    case '*':
//                        numbers.add(a * b);
//                        break;
//                    case '/':
//                        numbers.add(a / b);
//                }
//            }
//            return numbers.pop();
//        }
//
//
//
//
//        public boolean isSymmetric(TreeNode root) {
//            if (root == null) return true;
//            return isSymmetric(root.left, root.right);
//        }
//
//        public boolean isSymmetric(TreeNode p, TreeNode q) {
//            if (p == null && q == null) return true;
//            if (p == null || q == null) return false;
//            if (p.val != q.val) return false;
//            return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
//        }
//
//
//        public int maxDepth(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//
//            int maxDepth = 0;
//            Queue<TreeNode> q = new LinkedList<>();
//            q.add(root);
//            while (!q.isEmpty()) {
//                int nodeInThisLevel = q.size();
//                while (nodeInThisLevel-- > 0) {
//                    TreeNode temp = q.poll();
//                    if (temp.left != null)
//                        q.add(temp.left);
//                    if (temp.right != null)
//                        q.add(temp.right);
//                }
//                maxDepth++;
//            }
//            return maxDepth;
//        }
//
//
//        public int minDepth(TreeNode root) {
//            if (root == null) {
//                return 0;
//            }
//
//            int minDepth = 0;
//            Queue<TreeNode> q = new LinkedList<>();
//            q.add(root);
//            while (!q.isEmpty()) {
//                int nodeInThisLevel = q.size();
//                while (nodeInThisLevel-- > 0) {
//                    TreeNode temp = q.poll();
//                    if (temp.right == null && temp.left == null) return minDepth;
//                    if (temp.left != null)
//                        q.add(temp.left);
//                    if (temp.right != null)
//                        q.add(temp.right);
//                }
//                minDepth++;
//            }
//            return minDepth;
//        }
//
//
//        public boolean hasPathSum(TreeNode root, int sum) {
//            if (root == null) return false;
//            Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
//            q.add(new Pair<TreeNode, Integer>(root, sum - root.val));
//            while (!q.isEmpty()) {
//                Pair<TreeNode, Integer> pair = q.poll();
//                TreeNode node = pair.getKey();
//                int value = pair.getValue();
//                if (node.left == null && node.right == null && value == 0) return true;
//                if (node.left != null)
//                    q.add(new Pair<TreeNode, Integer>(node.left, value - node.left.val));
//                if (node.right != null)
//                    q.add(new Pair<TreeNode, Integer>(node.right, value - node.right.val));
//            }
//            return false;
//        }
//
//
//        public int singleNumber(int[] nums) {
//            int res = 0;
//            for (int e : nums) {
//                res ^= e;
//            }
//            return res;
//        }
//
//
//        public boolean hasCycle(ListNode head) {
//            if (head == null) return false;
//            ListNode fast = head.next, slow = head;
//            while (fast != slow) {
//                if (fast == null || fast.next == null) return false;
//                fast = fast.next.next;
//                slow = slow.next;
//            }
//            return true;
//        }
//
//
//        class MinStack {
//
//            /**
//             * initialize your data structure here.
//             */
//            Stack<Integer> min = new Stack<>();
//            ArrayList<Integer> arr;
//
//            public MinStack() {
//                arr = new ArrayList<>(16);
//            }
//
//            public void push(int x) {
//                if (min.isEmpty() || x <= min.peek()) min.push(x);
//                arr.add(x);
//            }
//
//            public void pop() {
//                int s = arr.remove(arr.size() - 1);
//                if (s == min.peek()) min.pop();
//            }
//
//            public int top() {
//                return arr.get(arr.size() - 1);
//            }
//
//            public int getMin() {
//                return min.peek();
//            }
//        }
//
//
//        public int majorityElement(int[] nums) {
//            int temp = nums[0], s = 1;
//            for (int i = 1; i < nums.length; i++) {
//                if (s == 0) temp = nums[i];
//                if (temp == nums[i]) s++;
//                else s--;
//            }
//            return temp;
//        }
//
//
//        public int trailingZeroes(int n) {
//            int res = 0, expOf5 = 5;
//            while (n >= expOf5) {
//                res += n / expOf5;
//                expOf5 *= 5;
//            }
//            return res;
//        }
//
//
//        public boolean isPalindrome(String s) {
//            int length = s.length() - 1;
//            for (int i = 0; i < length; i++, length--) {
//                char c = s.charAt(i);
//                while (!Character.isLetterOrDigit(c) && i < length) {
//                    i++;
//                    c = s.charAt(i);
//                }
//                char d = s.charAt(length);
//                while (!Character.isLetterOrDigit(d) && length > i) {
//                    length--;
//                    d = s.charAt(length);
//                }
//                c = Character.toLowerCase(c);
//                d = Character.toLowerCase(d);
//                if (c != d) return false;
//            }
//            return true;
//        }
//
//
//        public double findMedianSortedArrays(int[] a, int[] b) {
//            int[] arr = new int[a.length + b.length];
//            int p1 = 0, p2 = 0;
//
//            int i = 0;
//            while (p1 < a.length && p2 < b.length) {
//                if (a[p1] < b[p2]) arr[i++] = a[p1++];
//                else arr[i++] = b[p2++];
//            }
//            while (p1 < a.length) arr[i++] = a[p1++];
//            while (p2 < b.length) arr[i++] = b[p2++];
//            if (arr.length % 2 == 0) {
//                int q = arr[arr.length / 2];
//                int p = arr[(arr.length / 2) - 1];
//                return (q + p) / 2.0;
//            } else return arr[arr.length / 2];
//        }
//
//
//        class Point<E> implements Comparable<Point> {
//            int value, index;
//
//            Point(int value, int index) {
//                this.value = value;
//                this.index = index;
//            }
//
//            @Override
//            public int compareTo(Point o) {
//                return this.value - o.value;
//            }
//        }
//
//        public int maxArea(int[] height) {
//            int maxArea = 0;
//            Point[] points = new Point[height.length];
//            for (int i = 0; i < height.length; i++) {
//                points[i] = new Point(height[i], i);
//            }
//            Arrays.sort(points);
//            for (int i = height.length - 1; i >= 0; i--) {
//                for (int j = i - 1; j >= 0; j--) {
//                    int area = Math.abs(Math.min(points[i].value, points[j].value) * (points[i].index - points[j].index));
//                    if (area > maxArea) maxArea = area;
//                }
//            }
//            return maxArea;
//        } // O(n^2)
//
//        public int maxArea2(int[] height) {
//            int maxArea = 0, l = 0, r = height.length - 1;
//            while (l < r) {
//                maxArea = Math.max(maxArea, Math.max(height[l], height[r]) * (r - l));
//                if (height[l] < height[r]) l++;
//                else r--;
//            }
//            return maxArea;
//        } // O(n)
//
//
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//            int a, b, carry = 0;
//            ListNode res = new ListNode(0);
//            ListNode tail = res;
//            while (l1 != null || l2 != null) {
//                if (l1 != null) a = l1.val;
//                else a = 0;
//                if (l2 != null) b = l2.val;
//                else b = 0;
//                int sum = a + b + carry;
//                carry = sum / 10;
//                tail.next = new ListNode(sum % 10);
//                tail = tail.next;
//                if (l1 != null) l1 = l1.next;
//                if (l2 != null) l2 = l2.next;
//            }
//            if (carry > 0) tail.next = new ListNode(carry);
//            return res.next;
//        }
//
//
//        public int lengthOfLongestSubstring(String s) {
//            if (s.length() == 0) return 0;
//            if (s.length() == 1) return 1;
//            HashSet<Character> set = new HashSet<>();
//            int i = 0, j = 0, max = 0;
//            while (j < s.length()) {
//                if (set.contains(s.charAt(j))) {
//                    set.remove(s.charAt(i++));
//                } else {
//                    set.add(s.charAt(j++));
//                    max = Math.max(max, set.size());
//                }
//            }
//            return max;
//        }
//
//
//        public int myAtoi(String s) {
//            int res = 0, w = 0;
//            boolean negative = false;
//            while (w < s.length() && s.charAt(w) == ' ') {
//                w++;
//            }
//            if (w == s.length()) return 0;
//            if (s.charAt(w) == '+' || s.charAt(w) == '-') {
//                if (s.charAt(w++) == '-') negative = true;
//            }
//            while (w < s.length() && Character.isDigit(s.charAt(w))) {
//                if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && s.charAt(w) - '0' > Integer.MAX_VALUE % 10) {
//                    if (negative) return Integer.MIN_VALUE;
//                    else return Integer.MAX_VALUE;
//                }
//                res = res * 10 + s.charAt(w++) - 48;
//            }
//
//            if (negative) res *= -1;
//            return res;
//        }
//
//
//        public String intToRoman(int num) {
//            String res = "";
//            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//            String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//            for (int i = 0; i < values.length; i++) {
//                while (num >= values[i]) {
//                    num -= values[i];
//                    res = res + roman[i];
//                }
//            }
//            return res;
//        }
//
//
//        public List<List<Integer>> threeSum(int[] nums) {
//            if (nums.length < 3) return new ArrayList<>();
//            Arrays.sort(nums);
//            Set<List<Integer>> res = new HashSet<>();
//
//            for (int i = 0; i < nums.length - 2; i++) {
//                int j = i + 1, k = nums.length - 1;
//                while (j < k) {
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if (sum == 0)
//                        res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
//                    else if (sum > 0) k--;
//                    else j++;
//                }
//            }
//            return new ArrayList<>(res);
//        }
//
//
//        public ListNode removeNthFromEnd(ListNode head, int n) {
//            ListNode temp = new ListNode(0);
//            temp.next = head;
//            ListNode walker = temp, slower = temp;
//            for (int i = 0; i < n + 1; i++) {
//                walker = walker.next;
//            }
//            while (walker != null) {
//                slower = slower.next;
//                walker = walker.next;
//            }
//            slower.next = slower.next.next;
//            return temp.next;
//        }
//
//
//        public boolean isValidSudoku(char[][] board) {
//            Set<Integer> setRows, setColumns, box[] = new HashSet[9];
//            for (int i = 0; i < 9; i++) {
//                box[i] = new HashSet<>();
//            }
//            for (int i = 0; i < 9; i++) {
//                setRows = new HashSet<>();
//                setColumns = new HashSet<>();
//                for (int j = 0; j < 9; j++) {
//                    if (board[i][j] != '.') {
//                        if (setRows.contains(board[i][j] - 48))
//                            return false;
//                        else
//                            setRows.add(board[i][j] - 48);
//                    }
//
//                    if (board[j][i] != '.') {
//                        if (setColumns.contains(board[j][i] - 48))
//                            return false;
//                        else
//                            setColumns.add(board[j][i] - 48);
//                    }
//
//
//                    if (board[i][j] != '.') {
//                        if (box[((i / 3) * 3 + j / 3)].contains(board[i][j] - 48)) return false;
//                        else box[((i / 3) * 3 + j / 3)].add(board[i][j] - 48);
//                    }
////                    if((i+1)%3==0 && (j+1)%3==0){
////                        box=new HashSet<>();
////                    }
////                    if((i+1)%3==0 && (j+1)%3==0){
////                        if(!isValidSudokuSquare(board,i,j)) return false;
////                    }
//                }
//            }
//            return true;
//        }
//
//        public boolean isValidSudokuSquare(char[][] board, int i, int j) {
//            Set<Integer> set = new HashSet<>();
//            for (int k = 0; k < 3; k++) {
//                for (int l = 0; l < 3; l++) {
//                    if (board[i - k][j - l] != '.') {
//                        if (set.contains(board[i - k][j - l] - 48))
//                            return false;
//                        else
//                            set.add(board[i - k][j - l] - 48);
//                    }
//                }
//            }
//            return true;
//        }
//
//
//        public List<String> commonChars(String[] A) {
//            int[] first = new int[26];
//            for (int i = 0; i < A[0].length(); i++) {
//                first[A[0].charAt(i) - 'a']++;
//            }
//
//            for (int i = 1; i < A.length; i++) {
//                int[] temp = new int[26];
//                for (int j = 0; j < A[i].length(); j++) {
//                    temp[A[i].charAt(j) - 'a']++;
//                }
//                for (int j = 0; j < 26; j++) {
//                    first[j] = Math.min(first[j], temp[j]);
//                }
//            }
//            List<String> res = new ArrayList<>();
//            for (int i = 0; i < 26; i++) {
//                while (first[i]-- > 0)
//                    res.add((char) (i + 'a') + "");
//            }
//            return res;
//        }
//
//
//        //        public class TreeNode {
////            int val;
////            TreeNode left;
////            TreeNode right;
////
////            TreeNode(int x) {
////                val = x;
////            }
////        }
//        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//            TreeNode node = root;
//            while (node != null) {
//                if (q.val > node.val && p.val > node.val)
//                    node = node.right;
//                else if (q.val < node.val && p.val < node.val)
//                    node = node.left;
//                else
//                    return node;
//            }
//            return null;
//        }
//
//
//        public int findComplement(int num) {
//            String binaryString = Integer.toBinaryString(num);
//            String res = "";
//            for (int i = 0; i < binaryString.length(); i++) {
//                if (binaryString.charAt(i) == '0')
//                    res = res + '1';
//                else
//                    res = res + '0';
//            }
//            return Integer.parseInt(res, 2);
//        }
//
//        public int findComplement_faster(int num) {
//            int n = 0, temp = num;
//            while (temp > 0) {
//                temp >>= 1;
//                n++;
//            }
//            return num ^ ((1 << n) - 1);
//        }
//
//
//        public double myPow(double x, int n) {
//            return getPow(x, n);
//        }
//
//        private double getPow(double x, long n) {
//            if (n == 0) {
//                return 1.0;
//            } else if (n == 1) {
//                return x;
//            } else if (n < 0) {
//                return getPow(1 / x, -n);
//            }
//
//            double result = getPow(x * x, n / 2);
//            if (n % 2 == 1) {
//                result *= x;
//            }
//
//            return result;
//        }
//
//
//        public boolean canJump(int[] nums) {
//            int lastGoodPos = nums.length - 1;
//            for (int i = nums.length - 1; i >= 0; i--) {
//                if (nums[i] + i >= lastGoodPos)
//                    lastGoodPos = i;
//            }
//            return lastGoodPos == 0;
//        }
//
//
//        public boolean searchMatrix(int[][] matrix, int target) {
//            int row = 0, length = matrix[0].length - 1;
//            while (row < matrix.length) {
//                if (target <= matrix[row][length])
//                    break;
//                row++;
//            }
//            if (row >= matrix.length) return false;
//            for (int i = 0; i <= length; i++) {
//                if (matrix[row][i] == target)
//                    return true;
//            }
//            return false;
//        }
//
//
//        public void sortColors(int[] nums) {
//            int r = 0, w = 0, b = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] == 0) r++;
//                else if (nums[i] == 1) w++;
//                else b++;
//            }
//            int pointer = 0;
//            for (int i = 0; i < r; i++) {
//                nums[pointer++] = 0;
//            }
//            for (int i = 0; i < w; i++) {
//                nums[pointer++] = 1;
//            }
//            for (int i = 0; i < b; i++) {
//                nums[pointer++] = 2;
//            }
//        }
//
//
//        public void setZeroes(int[][] matrix) {
//            boolean firstCol = false;
//            for (int i = 0; i < matrix.length; i++) {
//                if (matrix[i][0] == 0) firstCol = true;
//                for (int j = 1; j < matrix[0].length; j++) {
//                    if (matrix[i][j] == 0) {
//                        matrix[i][0] = 0;
//                        matrix[0][j] = 0;
//                    }
//                }
//            }
//
//            for (int i = 1; i < matrix.length; i++) {
//                for (int j = 1; j < matrix[0].length; j++) {
//                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
//                        matrix[i][j] = 0;
//                    }
//                }
//            }
//
//            if (matrix[0][0] == 0) {
//                for (int j = 0; j < matrix[0].length; j++) {
//                    matrix[0][j] = 0;
//                }
//            }
//            if (firstCol) {
//                for (int j = 0; j < matrix.length; j++) {
//                    matrix[j][0] = 0;
//                }
//            }
//        }
//
//
//        public boolean HackerRankKangaroo(int x1, int v1, int x2, int v2) {
//            if (x1 < x2 && v1 < v2) return false;
//            if (x2 < x1 && v2 < v1) return false;
//
//            int newPos1 = x1 < x2 ? x1 : x2;
//            int newPos2 = newPos1 == x1 ? x2 : x1;
//            int newV1 = newPos1 == x1 ? v1 : v2;
//            int newV2 = newV1 == v1 ? v2 : v1;
//
//            while (newPos1 < newPos2) {
//                newPos1 += newV1;
//                newPos2 += newV2;
//
//                if (newPos1 == newPos2) return true;
//
//            }
//            return false;
//        }
//
//
//        public String longestPalindrome(String s) {
//            char[] c = s.toCharArray();
//            int len = c.length, clen = len;
//            if (len < 2)
//                return s;
//            for (; clen > 1; clen--)
//                for (int y = 0; y < len - clen + 1; y++)
//                    if (isPalinDrome(c, y, y + clen - 1))
//                        return new String(c, y, clen);
//            return String.valueOf(c[0]);
//        }
//
//        boolean isPalinDrome(char[] c, int x, int y) {
//            while (x < y) {
//                if (c[x] != c[y])
//                    return false;
//                ++x;
//                --y;
//            }
//            return true;
//        }
//
//
//        public int threeSumClosest(int[] nums, int target) {
//            Arrays.sort(nums);
//            int l, r, min = Integer.MAX_VALUE, res = -1;
//            for (int i = 0; i < nums.length && min != 0; ++i) {
//                l = i + 1;
//                r = nums.length - 1;
//                while (l < r) {
//                    int temp = nums[i] + nums[l] + nums[r];
//                    if (Math.abs(target - temp) < Math.abs(min)) {
//                        min = target - temp;
//                    }
//                    if (temp < target) ++l;
//                    else {
//                        --r;
//                    }
//                }
//            }
//            return target - min;
//        }
//
//
//        public List<List<Integer>> permute(int[] nums) {
//            List<List<Integer>> ans = new ArrayList<>();
//            generate(nums, new int[nums.length], ans, 1);
//            return ans;
//        }
//
//        public void generate(int a[], int visited[], List<List<Integer>> ans, int count) {
//            if (count == a.length + 1) {
//                List<Integer> now = new ArrayList<>();
//                for (int i = 0; i < a.length; i++)
//                    now.add(0);
//                for (int i = 0; i < a.length; i++) {
//                    now.set(visited[i] - 1, a[i]);
//                }
//                ans.add(now);
//                return;
//            }
//
//            for (int i = 0; i < a.length; i++) {
//                if (visited[i] != 0)
//                    continue;
//                visited[i] = count;
//                generate(a, visited, ans, count + 1);
//                visited[i] = 0;
//            }
//
//        }
//
//
//        int sum = 0;
//
//        public int sumRootToLeaf(TreeNode root) {
//            if (root == null) return 0;
//            helperSumRoot(root, 0);
//            return sum;
//        }
//
//        private void helperSumRoot(TreeNode root, int curr) {
//            if (root != null) {
//                curr = curr * 2 + root.val;
//
//                if (root.left == null && root.right == null) sum += curr;
//                helperSumRoot(root.left, curr);
//                helperSumRoot(root.right, curr);
//            }
//        }
//
//
//        public int maxProfit(int[] prices) {
//            int min = Integer.MAX_VALUE, max = 0;
//            for (int i = 0; i < prices.length; i++) {
//                if (prices[i] < min) min = prices[i];
//                else if (prices[i] - min > max) max = prices[i] - min;
//            }
//            return max;
//        }
//
//
//        public void backtrack(String combination, String next_digits, Map<String, String> phone, List<String> output) {
//            if (next_digits.length() == 0) {
//                output.add(combination);
//            } else {
//                String digit = next_digits.substring(0, 1);
//                String letters = phone.get(digit);
//                for (int i = 0; i < letters.length(); i++) {
//                    String letter = phone.get(digit).substring(i, i + 1);
//                    backtrack(combination + letter, next_digits.substring(1), phone, output);
//                }
//            }
//        }
//
//        public List<String> letterCombinations(String digits) {
//            Map<String, String> phone = new HashMap<String, String>() {{
//                put("2", "abc");
//                put("3", "def");
//                put("4", "ghi");
//                put("5", "jkl");
//                put("6", "mno");
//                put("7", "pqrs");
//                put("8", "tuv");
//                put("9", "wxyz");
//            }};
//            List<String> output = new ArrayList<>();
//            if (digits.length() != 0)
//                backtrack("", digits, phone, output);
//            return output;
//        }
//
//
//        public int divide(int dividend, int divisor) {
//            if (dividend == Integer.MIN_VALUE && divisor == -1)
//                return Integer.MAX_VALUE;
//
//            boolean isNegative = false;
//            if (dividend < 0 || divisor < 0) {
//                isNegative = true;
//            }
//            // if both are -ve it will be cancelled out
//            if (dividend < 0 && divisor < 0) {
//                isNegative = false;
//            }
//
//            int a = Math.abs(dividend);
//            int b = Math.abs(divisor);
//            int result = 0;
//            // 10-3>=0
//            while (a - b >= 0) {
//                int x = 0; //  its like 2^0=1 , at the end u will get to know
//
//                //checking further we can able to subtract divisor(3)
//                //10 - (3<<1<<0)
//                //10 - (6) >=0
//                while (a - (b << 1 << x) >= 0) {
//                    x++;
//                }
//                // after 1st iteration x = 1
//                // 0 = 0 + (1<<1)
//                // 0 = 0 + 2
//                result += 1 << x;
//
//
//                //10 =10 - (3<<1)
//                //10 =10 - (6)
//                a = a - (b << x);//  a = 4
//                //again while loop continue.....
//
//            }
//
//            return isNegative ? -result : result;
//        }
//
//        public void solveSudoku(char[][] board) {
//            solve(0, 0, board);
//        }
//
//        private boolean solve(int row, int col, char[][] board) {
//            // If completed all rows, we have solved board, return true
//            if (row == 9) return true;
//
//            // Reached to the last cell in a row, move to next row and first col
//            if (col == 9) {
//                return solve(row + 1, 0, board);
//            }
//
//            // If current cell is empty
//            if (board[row][col] == '.') {
//                for (char num = '1'; num <= '9'; num++) {
//                    // try placing each number at empty cell
//                    // if board is still valid, move to next cell
//                    boolean valid = isValid(num, row, col, board);
//
//                    if (valid) {
//                        // place the number
//                        board[row][col] = num;
//
//                        // solve for next cell
//                        boolean solved = solve(row, col + 1, board);
//
//
//                        if (solved) {
//                            return true;
//                        } else {
//                            // if board can't be solved with current number
//                            // reset and try next number
//                            board[row][col] = '.';
//                        }
//                        ;
//                    }
//                }
//
//            } else {
//                // if not empty, solve for next cell in same row
//                return solve(row, col + 1, board);
//            }
//
//
//            return false;
//
//        }
//
//        private boolean isValid(char n, int row, int col, char[][] board) {
//            char digit = n;
//
//            // check if row has n
//            for (int i = 0; i < 9; i++) {
//                if (board[row][i] == digit) return false;
//            }
//
//            // check if col has n
//            for (int i = 0; i < 9; i++) {
//                if (board[i][col] == digit) return false;
//            }
//
//            // check if 3x3 box has n
//            // get index of first cell in 3x3 matrix for current row,col
//            // then iterate all the cell in 3x3 matrix
//
//            // these are the first cells of each 3x3 matrix
//            // (0,0) (0,3) (0,6)
//            // (3,0) (3,3) (3,6)
//            // (6,0) (6,3) (6,6)
//
//            int startRowIndex = (row / 3) * 3;
//            int startColIndex = (col / 3) * 3;
//
//            for (int i = startRowIndex; i < startRowIndex + 3; i++) {
//                for (int j = startColIndex; j < startColIndex + 3; j++) {
//                    if (board[i][j] == digit) return false;
//                }
//            }
//
//            return true;
//        }
//
////        public boolean isNumber(String s) {
////            for (int i = 0; i < s.length(); i++) {
////                if(s.charAt(i) != 'e' || s.charAt(i) != 'E' || s.charAt(i) != '.' ||!Character.isDigit(s.charAt(i)))
////                    return false;
////            }
////
////            return true;
////        }
//
//
//        public List<Integer> partitionLabels(String s) {
//
//            int[] lastAry = new int[26];
//            for (int i = 0; i < s.length(); ++i)
//                lastAry[s.charAt(i) - 'a'] = i;
//
//            List<Integer> res = new ArrayList<>();
//            int part = 0;
//            int temp = 0;
//            int sum = 0;
//            HashSet<Character> set = new HashSet<>();
//            int last = lastAry[s.charAt(0) - 'a'];
//            for (int i = 0; i < s.length(); i++) {
//                if (i >= last) {
//
//                    if (last == s.length() - 1) {
//                        res.add(s.length() - sum);
//                        return res;
//                    }
//                    if (last == s.length() - 2) {
//                        res.add(s.length() - sum - 1);
//                        res.add(1);
//                        return res;
//                    }
//
//                    res.add(part + 1);
//                    sum += part + 1;
//                    set.clear();
//                    part = 0;
//
//                    last = lastAry[s.charAt(i + 1) - 'a'];
//                    set.add(s.charAt(i + 1));
//
//
//                } else {
//                    part++;
//                    if (!set.contains(s.charAt(i))) {
//                        temp = lastAry[s.charAt(i) - 'a'];
//                        if (temp > last) last = temp;
//                        set.add(s.charAt(i));
//                    }
//                }
//            }
//            return res;
//        }
//
//
//        public int minSteps(String s, String t) {
//            int[] freq = new int[26];
//            int diff = 0;
//            for (int i = 0; i < s.length(); i++) {
//                freq[s.charAt(i) - 'a']++;
//                freq[t.charAt(i) - 'a']--;
//            }
//            for (int i = 0; i < freq.length; i++) {
//                if (freq[i] > 0) diff += freq[i];
//            }
//            return diff;
//        }
//
//
//        int centuryFromYear(int year) {
//            if (year % 100 == 0) return year / 100 + 1;
//            return (int) Math.ceil(year / 100.00f);
//        }
//
//
//        String[] allLongestStrings(String[] inputArray) {
//            ArrayList<String> res = new ArrayList<>();
//            int maxLengt = inputArray[0].length();
//            for (int i = 0; i < inputArray.length; i++) {
//                if (inputArray[i].length() > maxLengt) {
//                    maxLengt = inputArray[i].length();
//                    res.clear();
//                    res.add(inputArray[i]);
//                    continue;
//                }
//                if (inputArray[i].length() == maxLengt) {
//                    res.add(inputArray[i]);
//                }
//            }
//            return res.toArray(new String[0]);
//        }
//
//        int[] sortByHeight(int[] a) {
//            ArrayList<Integer> people = new ArrayList<>();
//            ArrayList<Integer> peopleIndexes = new ArrayList<>();
//            for (int i = 0; i < a.length; i++) {
//                if (a[i] > 0) {
//                    people.add(a[i]);
//                    peopleIndexes.add(i);
//                }
//            }
//
//            Collections.sort(people);
//            for (int i = 0; i < peopleIndexes.size(); i++) {
//                a[peopleIndexes.get(i)] = people.get(i);
//            }
//            return a;
//        }
//
//        public static String reverseInParentheses(String equation) {
//            while (true) {
//                int lastB = getFirstClosingBracket(equation, 0);
//                int firstB = getLastOpeningBracket(equation);
//                if (lastB == -1 || firstB == -1) {
//                    break;
//                }
//                String insideBrackets = new StringBuilder(equation.substring(firstB + 1, lastB)).reverse().toString();
//                equation = equation.substring(0, firstB) + insideBrackets + equation.substring(lastB + 1);
//            }
//            return equation;
//        }
//
//        public static int getFirstClosingBracket(String equation, int searchFrom) {
//            for (int i = searchFrom; i < equation.length(); i++) {
//                if (equation.charAt(i) == ')')
//                    return i;
//            }
//            return -1;
//        }
//
//        public static int getLastOpeningBracket(String equation) {
//            int index = -1;
//            for (int i = 0; i < equation.length(); i++) {
//                if (equation.charAt(i) == '(')
//                    index = i;
//            }
//            return index;
//        }
//
//
//        public String convertToTitle(int columnNumber) {
//            StringBuilder res = new StringBuilder();
//
//            while (columnNumber > 0) {
//                if (columnNumber % 26 == 0) {
//                    res.insert(0, 'Z');
//                    columnNumber--;
//                } else {
//                    res.insert(0, (char) ('A' + columnNumber % 26 - 1));
//                }
//                columnNumber /= 26;
//            }
//
//            return res.toString();
//        }
//
//
//        public int titleToNumber(String columnTitle) {
//            int res = 0;
//            for (int i = columnTitle.length() - 1; i >= 0; i--) {
//                res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, columnTitle.length() - 1 - i);
//            }
//            return res;
//        }
//
//
//        public boolean isIsomorphic(String s, String t) {
//            return traverse(s).equals(traverse(t));
//        }
//
//        private String traverse(String s) {
//            StringBuilder sb = new StringBuilder();
//            HashMap<Character, Integer> map = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                if (!map.containsKey(s.charAt(i))) {
//                    map.put(s.charAt(i), i);
//                    sb.append(i + "-");
//                } else {
//                    sb.append(map.get(s.charAt(i)) + "-");
//                }
//            }
//            return sb.toString();
//        }
//
//
//        public boolean wordPattern(String pattern, String s) {
//            String arr[] = s.split(" ");
//            if (pattern.length() != arr.length) return false;
//            HashMap<Character, String> hm = new HashMap<>();
//            for (int i = 0; i < arr.length; i++) {
//                char ch = pattern.charAt(i);
//                if (hm.containsKey(ch)) {
//                    if (!hm.get(ch).equals(arr[i])) return false;
//                } else if (!hm.containsValue(arr[i])) {
//                    hm.put(ch, arr[i]);
//                } else return false;
//            }
//
//            return true;
//        }
//
//        public boolean canConstruct(String ransomNote, String magazine) {
//            int[] magArr = new int[26];
//            int[] noteStr = new int[26];
//            for (char ch : ransomNote.toCharArray()) {
//                noteStr[ch - 'a']++;
//            }
//            for (char ch : magazine.toCharArray()) {
//                magArr[ch - 'a']++;
//            }
//
//            for (int i = 0; i < noteStr.length; i++) {
//                if (noteStr[i] > magArr[i]) return false;
//            }
//            return true;
//        }
//
//
//        public List<List<Integer>> generate(int numRows) {
//            List<List<Integer>> res = new ArrayList<>();
//            List<Integer> temp = new ArrayList<>();
//
//            temp.add(1);
//            res.add(temp);
//
//            if (numRows == 1) {
//                return res;
//            }
//            temp = new ArrayList<>();
//            temp.add(1);
//            temp.add(1);
//
//            res.add(temp);
//
//            if (numRows == 2) return res;
//
//            for (int i = 2; i < numRows; i++) {
//                List<Integer> row = new ArrayList<>();
//                row.add(1);
//                for (int j = 1; j <= i - 1; j++) {
////                    if(j == 0 || j == i-1){ row.add(1); continue; }
//                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
//
//                }
//                row.add(1);
//                res.add(row);
//            }
//            return res;
//        }
//
//        public List<Integer> getRow(int rowIndex) {
//            List<Integer> res = new ArrayList<>();
//            long num = 1;
//            res.add(1);
//            for (int i = 0; i < rowIndex; i++) {
//                num = num * (rowIndex - i) / (i + 1);
//                res.add((int) num);
//            }
//            return res;
//        }
//
//        public void moveZeroes(int[] nums) {
//            int pointer = 0;
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i] != 0) {
//                    swap(i, pointer++, nums);
//                }
//            }
//        }
//
//
//        public ListNode mergeKLists(ListNode[] lists) {
//            ListNode res = new ListNode();
//            ListNode walker = new ListNode();
//            ArrayList<Integer> nums = new ArrayList<>();
//            for (int i = 0; i < lists.length; i++) {
//                walker = lists[i];
//                while (walker != null) {
//                    nums.add(walker.val);
//                    walker = walker.next;
//                }
//            }
//
//            Collections.sort(nums);
//            walker = res;
//            for (int i = 0; i < nums.size(); i++) {
//                walker.val = nums.get(i);
//                if (i == nums.size() - 1) break;
//                else {
//                    walker.next = new ListNode();
//                    walker = walker.next;
//                }
//            }
//            return res;
//        }
//
//
//        public int nthUglyNumber(int n) {
//            int[] memo = new int[n];
//            memo[0] = 1;
//
//            int l2 = 0, l3 = 0, l5 = 0;
//            for (int i = 1; i < n; i++) {
//                memo[i] = Math.min(memo[l2] * 2, Math.min(memo[l3] * 3, memo[l5] * 5));
//
//                if (memo[i] == memo[l2] * 2) l2++;
//                if (memo[i] == memo[l3] * 3) l3++;
//                if (memo[i] == memo[l5] * 5) l5++;
//            }
//            return memo[n - 1];
//        }
//
//
//        public int[] countBits(int n) {
//            int[] ans = new int[n + 1];
//            ans[0] = 0;
//            for (int i = 1; i <= n; i++) {
//                ans[i] = ans[i / 2] + i % 2;
//            }
//            return ans;
//        }
//
//        public boolean isSubsequence(String s, String t) {
//            int pointer = 0;
//            for (int i = 0; i < t.length(); i++) {
//                if (t.charAt(i) == s.charAt(pointer)) {
//                    pointer++;
//                }
//            }
//            return pointer == s.length();
//        }
//
//
//        public int fib(int n) {
//            int[] f = new int[n + 1];
//            f[0] = 0;
//            f[1] = 1;
//            for (int i = 2; i <= n; i++) {
//                f[i] = f[i - 1] + f[i - 2];
//            }
//            return f[n];
//        }
//
//
//        public int minCostClimbingStairs(int[] cost) {
//            int[] f = new int[cost.length];
//            for (int i = 0; i < f.length - 2; i++) {
//                f[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
//            }
//            System.out.println(Arrays.toString(f));
//            return 0;
//        }
//
//
//        public int tribonacci(int n) {
//            if (n == 0) return 0;
//            if (n == 1 || n == 2) return 1;
//            int[] dp = new int[n + 1];
//            dp[0] = 0;
//            dp[1] = 1;
//            dp[2] = 1;
//            for (int i = 3; i <= n; i++) {
//                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
//            }
//            return dp[n];
//        }
//
//
//        public int getMaximumGenerated(int n) {
//            if (n == 0) return 0;
//            if (n == 1) return 1;
//
//            int[] dp = new int[n + 1];
//            dp[0] = 0;
//            dp[1] = 1;
//            int max = 1;
//            for (int i = 1; i <= n; i++) {
//                if (2 * i >= 2 && 2 * i <= n) {
//                    dp[2 * i] = dp[i];
//                    if (dp[2 * i] > max) max = dp[2 * i];
//                }
//                if (2 * i + 1 >= 2 && 2 * i + 1 <= n) {
//                    dp[2 * i + 1] = dp[i] + dp[i + 1];
//                    if (dp[2 * i + 1] > max) max = dp[2 * i + 1];
//                }
//            }
//
//            return max;
//        }
//
//
//        public int countTriples(int n) {
//            int res = 0;
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= n; j++) {
//
//                    double temp = Math.sqrt((i * i) + (j * j));
//                    if (temp >= 1 && temp <= n && temp % 1 == 0) res++;
//                }
//            }
//            return res;
//        }
//
//        public int[] countPoints(int[][] points, int[][] queries) {
//            int[] ans = new int[queries.length];
//            for (int i = 0; i < queries.length; i++) {
//                for (int j = 0; j < points.length; j++) {
//                    if (getDistanceBetweenPoints(points[j][0], points[j][1], queries[i][0], queries[i][1]) <= queries[i][2])
//                        ans[i]++;
//                }
//            }
//            return ans;
//        }
//
//        private double getDistanceBetweenPoints(int x1, int y1, int x2, int y2) {
//            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//        }
//
//
//        public int numberOfRounds(String startTime, String finishTime) {
//            Integer startHH = Integer.parseInt(startTime.substring(0, 2));
//            Integer startMM = Integer.parseInt(startTime.substring(3));
//            Integer finishHH = Integer.parseInt(finishTime.substring(0, 2));
//            Integer finishMM = Integer.parseInt(finishTime.substring(3));
//
//            int start = startHH * 60 + startMM;
//            int end = finishHH * 60 + finishMM;
//            if (start > end) {
//                end += 24 * 60;
//            }
//
//            return (int) Math.floor(end / 15.00) - (int) Math.ceil(start / 15.00);
//        }
//
//
//        public int findTheWinner(int n, int k) {
//            Queue<Integer> players = new LinkedList<>();
//            for (int i = 1; i <= n; i++) {
//                players.add(i);
//            }
//            while (players.size() > 1) {
//
//
//                for (int i = 0; i < k - 1; i++) {
//                    players.add(players.remove());
//                }
//                players.remove();
//            }
//            return players.remove();
//        }
//
//
//        public int minOperations(int n) {
//            int[] arr = new int[n];
//            long sum = 0;
//            int res = 0;
//            for (int i = 0; i < n; i++) {
//                arr[i] = 2 * i + 1;
//                sum += 2 * i + 1;
//            }
//            int target = (int) (sum/n);
//            for (int i = 0; i < n; i++) {
//                res+=Math.abs(arr[i] - target);
//            }
//            return res/2;
//        }
//
//
//        public List<List<Integer>> fourSum(int[] nums, int target) {
//            Arrays.sort(nums);
//            return sumK(nums,target,0,4);
//        }
//
//        public List<List<Integer>> sumK(int[] nums,int target,int start,int k) {
//            List<List<Integer>> res = new ArrayList<>();
//            if(start == nums.length || nums[start]*k > target || nums[nums.length-1]*k < target) {
//                return res;
//            }
//            if(k==2) {
//                return twoSum(nums, target,start);
//            }
//            for (int i = start; i < nums.length; ++i) {
//                if(i == start || nums[i] != nums[i-1]){
//                   for(List<Integer> subset : sumK(nums,target - nums[i],i+1,k-1)){
//                       res.add(new ArrayList<>(Arrays.asList(nums[i])));
//                       res.get(res.size()-1).addAll(subset);
//                   }
//                }
//            }
//            return res;
//        }
//        public List<List<Integer>> twoSum(int[] nums, int target, int start) {
//    List<List<Integer>> res = new ArrayList<>();
//    int lo = start, hi = nums.length - 1;
//
//    while (lo < hi) {
//        int currSum = nums[lo] + nums[hi];
//        if (currSum < target || (lo > start && nums[lo] == nums[lo - 1]))
//            ++lo;
//        else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
//            --hi;
//        else
//            res.add(Arrays.asList(nums[lo++], nums[hi--]));
//    }
//
//    return res;
//}
//
//
//        public List<String> generateParenthesis(int n) {
//            List<String> res = new ArrayList<>();
//            backtracking(res,"",0,0,n);
//            return res;
//        }
//        public void backtracking(List<String> res,String curr,int open,int close,int max) {
//            if(curr.length() == max*2) {
//                res.add(curr);
//                return;
//            }
//            if(open < max) backtracking(res,curr+"(",open+1,close,max);
//            if(close<open) backtracking(res,curr+")",open,close+1,max);
//        }
//
//
//        public ListNode swapPairs(ListNode head) {
//            // Return 'head' if the list has 0 or 1 node only
//            if(head == null || head.next == null)
//                return head;
//
//            // Else take two pointer nodes
//            ListNode prev = head;       // To traverse from 'head'
//            ListNode track = null;      // To keep track of the previous node of 'prev'
//
//            // Run a loop while the current node or next node becomes 'null'
//            while(prev != null && prev.next != null){
//                // Take a temporary node pointing to the next node of 'prev'
//                ListNode post = prev.next;
//
//                // Swap the 2 nodes
//                prev.next = post.next;
//                post.next = prev;
//
//                // Check if 'track' is 'null' or not
//                if(track == null){
//                    // If Yes, then make 'head' point to the next node of 'prev'
//                    head = post;
//                }
//                else{
//                    // Else, make 'post' the next node of 'track'
//                    track.next = post;
//                }
//                // Update 'track' by pointing it to 'prev'
//                track = prev;
//                // Move 'prev' to the next node it's pointing
//                prev = prev.next;
//
//            }
//            // Finally, return 'head'
//            return head;
//        }
//
//
//        public void rotate(int[] nums, int k) {
//            k = k % nums.length;
//            if(k == 0)return;
//            int n = nums.length-1;
//
//            reverse(nums,0,n);
//            reverse(nums,0,k-1);
//            reverse(nums,k,n);
//
//            return;
//        }
//        private void reverse(int[] nums,int from,int to) {
//            while (to > from){
//                int tmp = nums[from];
//                nums[from++] = nums[to];
//                nums[to--] = tmp;
//            }
//        }
//
//        public int[] twoSum(int[] numbers, int target) {
//            int p1 = 0, p2 = numbers.length - 1;
//            int[] res = new int[2];
//            while (p1 < p2) {
//                if(numbers[p1] + numbers[p2] > target) { p2--; continue; }
//
//                if(numbers[p1] + numbers[p2] < target) { p1++; continue;}
//                if(numbers[p1] + numbers[p2] == target) {return new int[]{p1+1,p2+1};}
//            }
//            return res;
//        }
//
//
//        public String reverseWords(String s) {
//            String[] words = s.split(" ");
//            String res = "";
//            for (int i = 0; i < words.length; i++) {
//                res+= new StringBuilder(words[i]).reverse()+" ";
//            }
//            return res.substring(0,res.length()-1);
//        }
//
//
//        public ListNode middleNode(ListNode head) {
//            ListNode walker = head;
//            int length = 0;
//            while (walker != null) {
//                walker = walker.next;
//                length++;
//            }
//            for (int i = 0; i < length; i++) {
//                if(i == length/2) {
//                    return head;
//                }
//                head = head.next;
//            }
//            return head;
//        }
//
//        public boolean exist(char[][] a, String word)
//        {
//            boolean[][] visited = new boolean[a.length][a[0].length];
//            int m = a.length,n=a[0].length;
//            for(int i=0;i<m;i++)
//            {
//                for(int j=0;j<n;j++)
//                {
//                    if(a[i][j]==word.charAt(0)) if(checkifPossible(i,j,a,word,1,visited)) return true;
//                }
//            }
//            return false;
//        }
//        public boolean checkifPossible(int i,int j,char[][] a,String word,int index,boolean[][] visited)
//        {
//            if(index==word.length()) return true;
//
//            visited[i][j] = true;
//
//            if(i+1<a.length && a[i+1][j]==word.charAt(index) && visited[i+1][j]==false)
//            {
//                if(checkifPossible(i+1,j,a,word,index+1,visited)) return true;
//            }
//
//            if(j+1<a[0].length && a[i][j+1]==word.charAt(index) && visited[i][j+1]==false)
//            {
//                if(checkifPossible(i,j+1,a,word,index+1,visited)) return true;
//            }
//
//            if(i-1>=0 && a[i-1][j]==word.charAt(index) && visited[i-1][j]==false)
//            {
//                if(checkifPossible(i-1,j,a,word,index+1,visited)) return true;
//            }
//
//            if(j-1>=0 && a[i][j-1]==word.charAt(index) && visited[i][j-1]==false)
//            {
//                if(checkifPossible(i,j-1,a,word,index+1,visited)) return true;
//            }
//
//            visited[i][j] = false;
//            return false;
//        }
//
//        public boolean checkInclusion(String s1, String s2) {
//            if(s1.length() > s2.length()) return false;
//
//            int[] s1Ary = new int[26];
//
//            for(int i=0;i<s1.length();i++) s1Ary[s1.charAt(i)-'a']++;
//
//            for (int i = 0; i <= s2.length() - s1.length(); i++) {
//                int[] s2map = new int[26];
//                for (int j = 0; j < s1.length(); j++) {
//                    s2map[s2.charAt(i + j) - 'a']++;
//                }
//                if (matches(s1Ary, s2map))
//                    return true;
//            }
//            return false;
//        }
//
//        private boolean matches(int[] s1map, int[] s2map) {
//            for (int i = 0; i < 26; i++) {
//                if (s1map[i] != s2map[i])
//                    return false;
//            }
//            return true;
//        }
//
//        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//            boolean[][] visited = new boolean[image.length][image[0].length];
//            backtracking(image,sr,sc,newColor,image[sr][sc],visited);
//            return image;
//        }
//        private void backtracking(int[][] image,int sr,int sc,int newColor,int oldColor,boolean[][] visited) {
//            if(image[sr][sc] != oldColor) return;
//            if(visited[sr][sc]) return;
//            visited[sr][sc] = true;
//            image[sr][sc] = newColor;
//            if(sr + 1 < image.length) backtracking(image,sr+1,sc,newColor, oldColor,visited);
//            if(sr-1 >= 0) backtracking(image,sr-1,sc,newColor, oldColor,visited);
//            if(sc + 1 < image[0].length) backtracking(image,sr,sc+1,newColor, oldColor,visited);
//            if(sc-1 >= 0) backtracking(image,sr,sc-1,newColor, oldColor,visited);
//        }
//
//
//        public int maxAreaOfIsland(int[][] grid) {
//            int[] res = new int[1];
//            int max = 0;
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    if(grid[i][j] == 1) {
//                        backtracking(grid, i, j, res);
//                        if(res[0] > max) max = res[0];
//                        res[0] = 0;
//                    }
//
//                }
//            }
//            return max;
//        }
//        private void backtracking(int[][] grid,int x,int y, int[] res) {
//            if(grid[x][y]==0) return;
//            grid[x][y] = -1;
//            res[0]++;
//            if(x + 1 < grid.length && grid[x+1][y] == 1) {
//                backtracking(grid, x + 1, y, res);
//            }
//            if(x - 1 >= 0 && grid[x-1][y] == 1) {
//                backtracking(grid, x - 1, y, res);
//            }
//            if(y + 1 < grid[0].length && grid[x][y+1] == 1) {
//                backtracking(grid, x , y + 1, res);
//            }
//            if(y - 1 >= 0 && grid[x][y-1] == 1) {
//                backtracking(grid, x, y-1, res);
//            }
//        }
//
//
//        public ListNode reverseList(ListNode head) {
//            ArrayList<ListNode> list = new ArrayList<>();
//            while (head != null) {
//                list.add(head);
//                head = head.next;
//            }
//            for (int i = list.size()-1; i > 0; i--) {
//                list.get(i).next = list.get(i-1);
//            }
//            list.get(0).next = null;
//            return list.get(list.size()-1);
//        }
//
//
//        public int rob(int[] nums) {
//            int n = nums.length;
//            if(n == 0) return 0;
//            if(n == 1) return nums[0];
//            int v1 = nums[0],v2 = Math.max(v1,nums[1]);
//            for(int i = 2; i<n; i++){
//                int temp = v2;
//                v2 = Math.max(v2,v1+nums[i]);
//                v1 = temp;
//            }
//            return v2;
//        }
//
//
//        public int minimumTotal(List<List<Integer>> triangle) { //Slow
//            return recursion(triangle,0,0);
//        }
//        private int recursion(List<List<Integer>> tri, int x, int y) {
//            if(y == tri.size()) return tri.get(y).get(x);
//
//            return tri.get(y).get(x) + Math.min(recursion(tri,x,y+1),recursion(tri,x+1,y+1));
//        }
//        public int minimumTotalFaster(List<List<Integer>> tri) {
//
//            int y = tri.size(),x = tri.get(y-1).size();
//
//            int[] min = new int[x+1];
//
//            for(int i=y-1;i>=0;i--) {
//                for(int j=0;j<=i;j++) {
//                    min[j] = Math.min(min[j],min[j+1]) + tri.get(i).get(j);
//                }
//            }
//            return min[0];
//        }
//
//
//        public int reverseBits(int n) {
//            return Integer.parseInt(new StringBuilder(Integer.toBinaryString(n)).reverse().toString(),2);
//        }
//
//
//        public int minEatingSpeed(int[] piles, int h) {
//            long l = 1,r=Integer.MIN_VALUE;
//            for (int i = 0; i < piles.length; i++) {
//                if(piles[i] > r) r = piles[i] + 1;
//            }
//            long lastValidAnswer = 0;
//            while (l <= r) {
//                long mid = (l+r)/2;
//                if(minEatingSpeedCheck(piles,h,mid)) { r = mid-1; lastValidAnswer = mid;}
//                else l = mid + 1;
//            }
//            return (int)lastValidAnswer;
//        }
//        private boolean minEatingSpeedCheck(int[] piles,int h, long k) {
//            long temp = 0;
//            for (int i = 0; i < piles.length; i++) {
//                temp += Math.ceil(piles[i]*1.0/k);
//                if(temp > h) return false;
//            }
//            return true;
//        }
//
//        public int[] searchRange(int[] nums, int target) {
//            if(nums.length == 0) return new int[]{-1,-1};
//            int l = 0,r= nums.length-1;
//            int mid = 0,lastValid = -1;
//            int[] ans = new int[2];
//            while (l<=r){
//                mid = l + (r-l)/2;
//                if(nums[mid] >= target) {
//                    r = mid - 1;
//                    if(nums[mid] == target) lastValid = mid;
//                    else lastValid = -1;
//                }
//                else l = mid+1;
//            }
//            if(lastValid == -1) return new int[]{-1,-1};
//            ans[0] = lastValid;
//            l = lastValid;
//            r =nums.length-1;
//            while (l <= r){
//                mid= l + (r-l)/2;
//                if(nums[mid]<= target){
//                    l = mid+1;
//                    lastValid = mid;
//                }
//                else r = mid-1;
//            }
//            ans[1]= lastValid;
//            return ans;
//        }
//
//
//        public int findPeakElement(int[] nums) {
//            int l = 0, r = nums.length - 1;
//            while (l < r) {
//                int mid = (l + r) / 2;
//                if (nums[mid] > nums[mid + 1])
//                    r = mid;
//                else
//                    l = mid + 1;
//            }
//            return l;
//        }
//
//
//        public String multiply(String num1, String num2) {
//            if(num1.equals("0") || num2.equals("0")) return "0";
//
//            StringBuilder ans = new StringBuilder();
//            StringBuilder s1 = new StringBuilder(num1);
//            StringBuilder s2 = new StringBuilder(num2);
//
//            s1.reverse(); s2.reverse();
//            int N = s1.length() + s2.length();
//            for (int i = 0; i < N; i++) {
//                ans.append('0');
//            }
//
//            for (int i = 0; i < s1.length(); i++) {
//                int digit1 = num1.charAt(num1.length()-1-i)-'0';
//                for (int j = 0; j < s2.length(); j++) {
//                    int digit2 = num2.charAt(num2.length()-1-j)-'0';
//
//                    int currPos = i + j;
//
//                    int carry = ans.charAt(currPos)-'0';
//                    int multiply = digit1 * digit2 + carry;
//
//                    ans.setCharAt(currPos, (char) (multiply%10+'0'));
//
//                    int val = ans.charAt(currPos + 1)-'0' + multiply/10;
//                    ans.setCharAt(currPos+1, (char) (val+'0'));
//
//                }
//            }
//            if(ans.charAt(ans.length()-1)=='0')
//                ans.deleteCharAt(ans.length()-1);
//            ans.reverse();
//            return ans.toString();
//        }
//
//
//        static class DSU {
//            int[] representative;
//            int[] size;
//
//            DSU(int sz) {
//                representative = new int[sz];
//                size = new int[sz];
//
//                for (int i = 0; i < sz; ++i) {
//                    // Initially each group is its own representative
//                    representative[i] = i;
//                    // Intialize the size of all groups to 1
//                    size[i] = 1;
//                }
//            }
//
//            // Finds the representative of group x
//            public int findRepresentative(int x) {
//                if (x == representative[x]) {
//                    return x;
//                }
//
//                // This is path compression
//                return representative[x] = findRepresentative(representative[x]);
//            }
//
//            // Unite the group that contains "a" with the group that contains "b"
//            public void unionBySize(int a, int b) {
//                int representativeA = findRepresentative(a);
//                int representativeB = findRepresentative(b);
//
//                // If nodes a and b already belong to the same group, do nothing.
//                if (representativeA == representativeB) {
//                    return;
//                }
//
//                // Union by size: point the representative of the smaller
//                // group to the representative of the larger group.
//                if (size[representativeA] >= size[representativeB]) {
//                    size[representativeA] += size[representativeB];
//                    representative[representativeB] = representativeA;
//                } else {
//                    size[representativeB] += size[representativeA];
//                    representative[representativeA] = representativeB;
//                }
//            }
//        }
//        public List<List<String>> accountsMerge(List<List<String>> accountList) {
//                int accountListSize = accountList.size();
//                DSU dsu = new DSU(accountListSize);
//
//                // Maps email to their component index
//                Map<String, Integer> emailGroup = new HashMap<>();
//
//                for (int i = 0; i < accountListSize; i++) {
//                    int accountSize = accountList.get(i).size();
//
//                    for (int j = 1; j < accountSize; j++) {
//                        String email = accountList.get(i).get(j);
//                        String accountName = accountList.get(i).get(0);
//
//                        // If this is the first time seeing this email then
//                        // assign component group as the account index
//                        if (!emailGroup.containsKey(email)) {
//                            emailGroup.put(email, i);
//                        } else {
//                            // If we have seen this email before then union this
//                            // group with the previous group of the email
//                            dsu.unionBySize(i, emailGroup.get(email));
//                        }
//                    }
//                }
//
//                // Store emails corresponding to the component's representative
//                Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
//                for (String email : emailGroup.keySet()) {
//                    int group = emailGroup.get(email);
//                    int groupRep = dsu.findRepresentative(group);
//
//                    if (!components.containsKey(groupRep)) {
//                        components.put(groupRep, new ArrayList<String>());
//                    }
//
//                    components.get(groupRep).add(email);
//                }
//
//                // Sort the components and add the account name
//                List<List<String>> mergedAccounts = new ArrayList<>();
//                for (int group : components.keySet()) {
//                    List<String> component = components.get(group);
//                    Collections.sort(component);
//                    component.add(0, accountList.get(group).get(0));
//                    mergedAccounts.add(component);
//                }
//
//                return mergedAccounts;
//            }
//
//
//        public List<List<String>> groupAnagrams(String[] strs) {
//            List<List<String>> res = new ArrayList<>();
//
//            HashMap<String,ArrayList<String>> dic = new HashMap<>();
//            for (int i = 0; i < strs.length; i++) {
//                char ch[] = strs[i].toCharArray();
//                Arrays.sort(ch);
//                String temp = String.valueOf(ch);
//
//                ArrayList<String> tempList = dic.getOrDefault(temp,new ArrayList<>());
//                tempList.add(strs[i]);
//                dic.put(temp,tempList);
//            }
//
//            return new ArrayList<>(dic.values());
//        }
//
//
//
//        public List<List<Integer>> combinationSum(int[] candidates, int target) {
//            List<List<Integer>> list = new ArrayList<>();
//            Arrays.sort(candidates);
//            helper_combinationSum(list, new ArrayList<>(), candidates, 0, target);
//            return list;
//        }
//
//        public void helper_combinationSum(List<List<Integer>> list, List<Integer> temp, int[] candidates, int start, int target) {
//            // base case
//            if(target == 0) {
//                list.add(new ArrayList<>(temp));
//                return;
//            }
//            if(start>= candidates.length) return;
//            // recursion step
////            for(int i = start; i < candidates.length; i++) {
//
//                if(target < candidates[start]) return;
//
//                temp.add(candidates[start]);
//                helper_combinationSum(list, temp, candidates, start, target - candidates[start]);
//                temp.remove(temp.size() - 1);
//                helper_combinationSum(list,temp,candidates,start+1,target);
//
//        }
//
//
//
//        public ListNode reverseKGroup(ListNode head, int k) {
//            ListNode res = new ListNode();
//            ListNode tail = new ListNode();
//            res.next = tail;
//            ListNode walker = head;
//            if(k == 1) return head;
//            ListNode[] queue = new ListNode[k];
//            int size = 0;
//            while (walker != null || size == k){
//                if(size == k){
//
//                    ListNode[] temp = reverseListNode(queue);
//                    tail.next = temp[0];
//                    tail = temp[1];
//
//                    size = 0;
//                }
//                else{
//                    queue[size++] = walker;
//                    walker = walker.next;
//                }
//
//            }
//            if(size > 0)tail.next = queue[0];
//            return res.next.next;
//        }
//        private ListNode[] reverseListNode(ListNode[] listNodes){
//            ListNode a = null;
//            ListNode b = listNodes[0];
//            ListNode c = b.next;
//            for (int i = 0; i < listNodes.length-1; i++) {
//                b.next = a;
//                a = b;
//                b = c;
//                c = c.next;
//            }
//            b.next = a;
//            return new ListNode[]{b,listNodes[0]};
//        }
//
//
//        public void rotate(int[][] matrix) {
//            transpose(matrix);
//            reflect(matrix);
//        }
//        private void transpose (int[][] matrix){
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = i; j < matrix[0].length; j++) {
//                    int tmp = matrix[i][j];
//                    matrix[i][j] = matrix[j][i];
//                    matrix[j][i] = tmp;
//                }
//            }
//        }
//        private void reflect (int[][] matrix) {
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix.length/2; j++) {
//                    int tmp = matrix[i][j];
//                    matrix[i][j] = matrix[i][matrix.length - 1 - j];
//                    matrix[i][matrix.length - 1 - j] = tmp;
//                }
//            }
//        }
//
//
//        public int countPairs(int[] deliciousness) {
//            int mod = (int) (1e9+7);
//            HashMap<Integer,Integer> map = new HashMap<>();
//            int res = 0;
//            for(int num : deliciousness){
//                int power = 1;
//                for (int i = 0; i < 22; i++) {
//                    if(map.containsKey(power - num)) {
//                        res+=map.get(power-num);
//                        res%=mod;
//                    }
//                    power *=2;
//                }
//                map.put(num,map.getOrDefault(num,0)+1);
//            }
//            return res;
//        }
//
//
//
//        public int jump(int[] nums) {
//            if(nums.length == 1) return 0;
//            int n = nums.length-1;
//            int res = 0,tmpIndex = 0;
//            for (int i = 0; i < nums.length;) {
//                if(nums[i] >= n - i) return res + 1;
//                int max = 0;
//                for (int j = 1; j <= nums[i]; j++) {
//                    if(nums[i+j]+i+j > max) {
//                        max = nums[i + j]+i+j;
//                        tmpIndex = i+j;
//                    }
//                }
//                i = tmpIndex;
//                res++;
//            }
//            return res;
//        }
//
//
//
//        public int getDecimalValue(ListNode head) {
//            int res = 0;
//            while (head != null) {
//                if(head.val==0) {
//                    head = head.next;
//                    continue;
//                }
//                while (head != null) {
//                    res = (res << 1) | head.val;
//                    head = head.next;
//                }
//                return res;
//            }
//            return 0;
//        }
//
//
//
//        public int findMin(int[] nums) {
//            int l = 0,r = nums.length-1;
//            if(nums[l] < nums[r]) return nums[0];
//            int mid = 0;
//            while (l<=r){
//                mid = l + (r-l)/2;
//               if(nums[mid] >= nums[0]) l = mid + 1;
//               else r = mid-1;
//            }
//            return nums[l];
//        }
//
//
//
//        public String reverseWords_Q151(String s) {
//            String[] words = s.split(" ");
//            if(words.length == 0) return "";
//            if(words.length == 1) return words[0];
//            StringBuilder res = new StringBuilder();
//            for (int i = words.length - 1; i >= 0 ; i--) {
//                if(words[i].length()!=0) {
//                    res.append(words[i]+" ");
//                }
//            }
//            return res.deleteCharAt(res.length()-1).toString();
//        }
//
//
//
//        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//            ListNode walkerA = headA,walkerB = headB;
//            int lenA = 0,lenB = 0;
//            while (walkerA != null || walkerB != null){
//                if(walkerA != null){
//                    lenA++;
//                    walkerA = walkerA.next;
//                }
//                if(walkerB != null){
//                    lenB++;
//                    walkerB = walkerB.next;
//                }
//            }
//            while (lenA > lenB){
//                headA = headA.next;
//                lenA--;
//            }
//            while (lenB > lenA){
//                headB = headB.next;
//                lenB--;
//            }
//            while (headA != null && headB != null) {
//                if(headA == headB) return headA;
//                headA = headA.next;
//                headB = headB.next;
//            }
//            return null;
//        }
//
//
//        public boolean isSameTree(TreeNode p, TreeNode q) {
//            if(p == null && q == null) return true;
//            if(p == null || q == null) return false;
//            Queue<TreeNode> qu = new LinkedList<>();
////            Queue<TreeNode> q2 = new LinkedList<>();
//
//            qu.add(p);
//            qu.add(q);
//
//            while (!qu.isEmpty()){
//                TreeNode first = qu.poll();
//                TreeNode sec = qu.poll();
//                if(first.val != sec.val) return false;
//
//                TreeNode child1 = first.left;
//                TreeNode child2 = sec.left;
//                if((child1 == null && child2 != null) ||(child1 != null && child2 == null)) return false;
//                if(child1 != null) {
//                    qu.add(child1);
//                    qu.add(child2);
//                }
//                child1 = first.right;
//                child2 = sec.right;
//                if((child1 == null && child2 != null) ||(child1 != null && child2 == null)) return false;
//                if(child1 != null) {
//                    qu.add(child1);
//                    qu.add(child2);
//                }
//
//            }
//            return true;
//        }
//        /*
//                public boolean isSameTree(TreeNode p, TreeNode q) {
//            if (p == null && q == null) return true;
//            if (p == null || q == null) return false;
//            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(q.right, q.right);
//        }
//         */
//
//
//
//        private long gcd(int x,int y){
//            if(x ==0 )return y;
//            return gcd(y%x,x);
//        }
//        public int nthMagicalNumber(int n, int a, int b) {
//            final int mod = (int) (1e9+7);
//            long L = a / gcd(a,b)*b;
//            long l = 0,r = (long) n *Math.min(a,b);
//            while (l<r){
//                long mid = l + (r-l)/2;
//                if(mid/a + mid/b - mid/L < n){
//                    l = mid+1;
//                }
//                else r = mid;
//            }
//            return (int) (l%mod);
//        }
//
//
//
//        public boolean canPartition(int[] nums) {
//            int sum = 0;
//            int n = nums.length;
//            for (int num : nums) sum+=num;
//            if(sum % 2 != 0) return false;
//            sum/= 2;
//            boolean[] dp = new boolean[sum+1];
//            dp[0] = true;
//            for(int num : nums)
//                for (int i = sum; i >= num; i--) {
//                    dp[i] = dp[i] || dp[i-num];
//                }
//            return dp[sum];
//        }


//        public int firstMissingPositive(int[] nums) {
//            int i = 0;
//            while (i < nums.length){
//                if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
//                        int temp = nums[i];
//                        nums[i] = nums[nums[i] - 1];
//                        nums[temp-1] = temp;
//                    }
//                    else {
//                    i++;
//                }
//            }
//
//            for (int j = 0; j < nums.length; j++) {
//                if(nums[j] != j+1) return j+1;
//            }
//            return nums.length+1;
//        }



//        public ListNode oddEvenList(ListNode head) {
//            ListNode odd = new ListNode();
//            ListNode oddNext = new ListNode();
//            ListNode even = new ListNode();
//            ListNode evenNext = new ListNode();
//
//            odd.next = oddNext;
//            even.next = evenNext;
//            boolean isEven = false;
//            while (head != null){
//                if(isEven){
//                    evenNext.next = head;
//                    evenNext = evenNext.next;
//                }
//                else{
//                    oddNext.next = head;
//                    oddNext = oddNext.next;
//                }
//                isEven = !isEven;
//                head = head.next;
//            }
//            evenNext.next = null;
//            oddNext.next = even.next.next;
//            return odd.next.next;
//        }


//        public Node connect(Node root) {
//            if(root == null) return null;
//            Queue<Node> queue = new LinkedList<>();
//            int size;
//            queue.add(root);
//            while (!queue.isEmpty()){
//                size = queue.size();
//                for (int i = 0; i < size; i++) {
//                    Node temp = queue.poll();
//                    if(temp.left!= null) queue.add(temp.left);
//                    if(temp.right != null) queue.add(temp.right);
//                    if(i == size-1) temp.next = null;
//                    else temp.next = queue.peek();
//                }
//            }
//            return root;
//        }



//        public int minCostClimbingStairs(int[] cost) {
//            int first = cost[0];
//            int sec = cost[1];
//            int current;
//            for (int i = 2; i < cost.length; i++) {
//               current = cost[i] + Math.min(first,sec);
//                first = sec;
//                sec = current;
//            }
//            return Math.min(first,sec);
//        }



//        public List<Integer> findDisappearedNumbers(int[] nums) {
//            List<Integer> res = new LinkedList<>();
//            int i = 0,temp;
//            while (i < nums.length) {
//                if (nums[i] != nums[nums[i] - 1]) {
//                    temp = nums[i];
//                    nums[i] = nums[nums[i] - 1];
//                    nums[temp-1] = temp;
//                } else i++;
//            }
//            for (int j = 0; j < nums.length; j++) {
//                if(nums[j] != j+1) res.add(j+1);
//            }
//            return res;
//        }



//        public int findContentChildren(int[] g, int[] s) {
//            if(s.length == 0) return 0;
//            Arrays.sort(g); Arrays.sort(s);
//            int gPoniter = 0,sPointer = 0;
//            for(;gPoniter < g.length && sPointer < s.length;){
//                if(g[gPoniter] <= s[sPointer]) {
//                    gPoniter++;
//                    continue;
//                }
//                sPointer++;
//            }
//            return gPoniter;
//        }




//        public int arrayPairSum(int[] nums) {
//            Arrays.sort(nums);
//            int res = 0;
//            for (int i = 0; i < nums.length; i+=2) {
//                res += Math.min(nums[i],nums[i+1]);
//            }
//            return res;
//        }




//        public int minimumDifference(int[] nums, int k) {
//            if(k == 1) return 0;
//            Arrays.sort(nums);
//            int res = Integer.MAX_VALUE;
//            for (int i = 0; i <= nums.length - k; i++) {
//                res = Math.min(res,nums[i+k-1] - nums[i]);
//            }
//            return res;
//        }
    }
}



