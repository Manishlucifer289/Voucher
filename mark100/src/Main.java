
    import java.util.*;

    public class Main {
        public static int LongestSpecialSubarray(int n, List<Integer> a) {
            // Initialize variables
            int maxLen = 0;
            int start = 0;

            // To keep track of frequency of elements in the current window
            Map<Integer, Integer> freq = new HashMap<>();

            for (int end = 0; end < n; end++) {
                // Add the current element to the frequency map
                freq.put(a.get(end), freq.getOrDefault(a.get(end), 0) + 1);

                // Check if the window [start, end] is valid (difference between max and min <= 1)
                while (Collections.max(freq.keySet()) - Collections.min(freq.keySet()) > 1) {
                    // Remove the start element from the frequency map
                    int startElem = a.get(start);
                    freq.put(startElem, freq.get(startElem) - 1);
                    if (freq.get(startElem) == 0) {
                        freq.remove(startElem);
                    }
                    start++;
                }

                // Calculate the length of the current valid subarray
                maxLen = Math.max(maxLen, end - start + 1);
            }

            return maxLen;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();  // number of test cases

            while (t-- > 0) {
                int n = sc.nextInt();  // size of the array
                List<Integer> a = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    a.add(sc.nextInt());  // add each element to the list
                }

                System.out.println(LongestSpecialSubarray(n, a));  // output the result
            }
            sc.close();
        }
    }

