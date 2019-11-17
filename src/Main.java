import java.util.Arrays;

public class Main {

        //For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing subsequences is {0, 2, 6, 9, 11, 15}.
        //It's not contiguous or unique. Other instances are {0, 2, 6, 9, 13, 15}, {0, 4, 6, 9, 11, 15, {0, 4, 6, 9, 13, 15}

        public static void main(String[] args) {
            int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
            System.out.println("Length of LIS: " + findLengthOfLIS(arr));
        }

        public static int findLengthOfLIS(int[] arr) {
            int[] cache = new int[arr.length];
            Arrays.fill(cache, 1);

            for (int i = 1; i < arr.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        cache[i] = Math.max(cache[i], cache[j] + 1);
                    }
                }
            }

            return Arrays.stream(cache).max().getAsInt();
        }

    }

