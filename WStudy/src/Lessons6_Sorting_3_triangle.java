import java.util.*;

/**
 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
 *
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * For example, consider array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * Triplet (0, 2, 4) is triangular.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.
 *
 * For example, given array A such that:
 *
 *   A[0] = 10    A[1] = 2    A[2] = 5
 *   A[3] = 1     A[4] = 8    A[5] = 20
 * the function should return 1, as explained above. Given array A such that:
 *
 *   A[0] = 10    A[1] = 50    A[2] = 5
 *   A[3] = 1
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 */
public class Lessons6_Sorting_3_triangle {
    //P,Q,R A의 인덱스 정보
    //3의 길이가 안되면 return 0
    //3의 길이이상이면 sort 후
    // P+Q>R
        //정렬된 경우 이 조건이 불확실함.
    // Q+R>P
    // R+P>Q
    // 3가지 조건이 만족한 수가 있으면 1, 아니면 0 반환
    // 0<=P<Q<R<N
    int[] A = new int[]{1,2,3,4,5};

    /**
     * https://app.codility.com/demo/results/trainingQZQFBP-NEV/
     * @return
     */
    public int solution1() {
        if (A.length<3) {
            return  0;
        }

        Arrays.sort(A);

        for (int i=0; i<A.length; i++) {
            if (i+2<A.length) {
                return A[i]+A[i+1]>A[i+2]?1:0;
            }
        }

        return 0;
    }

    //93
    public int solution2(int[] A) {
        if (A.length<3) {
            return  0;
        }

        Arrays.sort(A);

        for (int i=0; i<A.length; i++) {
            if (i+2<A.length && A[i]+A[i+1]>A[i+2]) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * https://app.codility.com/demo/results/trainingJFZCPV-G6W/
     * @param A
     * @return
     */
    public int solution3(int[] A) {
        if (A.length<3) {
            return  0;
        }

        Arrays.sort(A);

        for (int i=0; i<A.length; i++) {
            if (i+2<A.length && A[i]+A[i+1]>A[i+2]) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * https://app.codility.com/demo/results/trainingKDYQ33-99A/
     * @param A
     * @return
     */
    public int solution4(int[] A) {
        if (3 > A.length) return 0;

        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            long P = A[i], Q = A[i + 1], R = A[i + 2];
            if (P + Q > R) return 1;
        }
        return 0;
    }

}
