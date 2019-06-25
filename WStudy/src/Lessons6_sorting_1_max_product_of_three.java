import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 *
 * For example, array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * contains the following example triplets:
 *
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 *
 * For example, given array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
public class Lessons6_sorting_1_max_product_of_three {
    int[] A = {-3,1,2,-2,5,6};

    public int solution1(int[] A) {
        int maxSum = Integer.MIN_VALUE;

        Arrays.sort(A);

        for (int i=0; i<A.length; i++) {
            if(i+2<A.length) {
                int eachSum = A[i]*A[i+1]*A[i+2];
                if (eachSum > maxSum) {
                    maxSum = eachSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * https://app.codility.com/demo/results/trainingHQUC4B-3H7/
     * @param A
     * @return
     */
    public int solution2(int[] A) {
        int maxSum = Integer.MIN_VALUE;

        Arrays.sort(A);

        for (int i=0; i<A.length; i++) {
            if(i+2<A.length) {
                int eachSum = A[i]*A[i+1]*A[i+2];
                maxSum = eachSum > maxSum ? eachSum : maxSum;
            }
        }
        return maxSum;
    }

    /**
     * https://app.codility.com/demo/results/trainingPDTBJK-2Y3/
     */
    public int solution3(int[] A) {
        // write your code in Java SE 8
        int maxSum = Integer.MIN_VALUE;

        Arrays.sort(A);

        for (int i=0; i<A.length; i++) {
            if(i+2<A.length) {
                int eachSum = A[i]*A[i+1]*A[A.length-1];
                maxSum = eachSum > maxSum ? eachSum : maxSum;
            }
        }
        return maxSum;
    }
}
