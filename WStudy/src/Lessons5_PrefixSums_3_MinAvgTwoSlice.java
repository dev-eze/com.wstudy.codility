/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * contains the following example slices:
 *
 * slice (1, 2), whose average is (2 + 2) / 2 = 2;
 * slice (3, 4), whose average is (5 + 1) / 2 = 3;
 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
 * The goal is to find the starting position of a slice whose average is minimal.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−10,000..10,000].
 */

/**
 * https://app.codility.com/demo/results/training5FKTXU-8J5/
 */
public class Lessons5_PrefixSums_3_MinAvgTwoSlice {
    public int solution() {
        int[] A = new int[]{4,2,2,5,1,5,8};

        // 슬라이스 란 배열 A 의 연속된 부분집합
        //2개 인자의 평균은 항상 2개중 한개의 인자보다 값이 크다.
        //평균들의 평균은 각 인자들의 평균과 같다.
        //평균들의 평균은 그 인자가 되는 평균들 보다 항상 크다.
        //4개의 부분 집합은 0개 1개 2개 3개 4개, 4개의 의 부분집합은 곧 2개의 부분집합 으로 표현되므로, 4개의 부분집합은 2개의 부분집합의 평균들의 평균 이므로 항상 큼
        //2개의 부분집합들로 3개의 부분집합 을 구할 수 없음
        //부분집합중 가장 작은 집합의 평균이 항상 작다. > 모든 부분집합은 2와 3으로 모두 표현된다.

        Float minAvg = Float.MAX_VALUE;
        Float avg;
        int minSliceIndex = 0;

        for (int i=0; i<A.length; i++) {
            if (i+1 < A.length) {
                avg = (A[i]+A[i+1]) / 2F;

                if (minAvg > avg) {
                    minAvg = avg;
                    minSliceIndex = i;
                }
            }

            if (i+2 < A.length) {
                avg = (A[i]+A[i+1]+A[i+2]) / 3F;

                if(minAvg > avg) {
                    minAvg = avg;
                    minSliceIndex = i;
                }
            }
        }

        return minSliceIndex;
    }
}
