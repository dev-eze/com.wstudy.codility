/**
 * Write a function:
 *
 * class Solution { public int solution(int A, int B, int K); }
 *
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 *
 * { i : A ≤ i ≤ B, i mod K = 0 }
 *
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 */


public class Lessons4_PrefixSums_CountDiv {
    /**
     * https://app.codility.com/demo/results/trainingXYS5XQ-GMC/
     */
    class Solution1 {
        public int solution(int A, int B, int K) {
            int countDiv = 0;
            for (int i=A; i<=B; i++) {
                if (i%K == 0) {
                    countDiv ++;
                }
            }
            return countDiv;
        }
    }

    /**
     * https://app.codility.com/demo/results/trainingRV8B66-H54/
     */
    class Solution2 {
        public int solution(int A, int B, int K) {
            // write your code in Java SE 8
            int isInclude = 0;
            int divRange = B/K - A/K;

            if(A == B && A%K != 0) {
                return 0;
            }

            if (A%K == 0 ) {
                isInclude = 1;
            }else {
                isInclude = 0;
            }

            return divRange + isInclude;
        }
    }

    /**
     * https://app.codility.com/demo/results/training2HCTUS-FCX/
     */
    class Solution3 {
        public int solution(int A, int B, int K) {
            // write your code in Java SE 8
            int isInclude = 0;
            int divRange = Math.floorDiv(B,K) - Math.floorDiv(A, K);

            if (A % K == 0 ) {
                isInclude = 1;
            } else {
                isInclude = 0;
            }

            return divRange + isInclude;
        }
    }



}
