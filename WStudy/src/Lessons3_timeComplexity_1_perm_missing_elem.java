import java.util.Arrays;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
public class Lessons3_timeComplexity_1_perm_missing_elem {

    int[] A = {2,3,1,5};

    /**
     * https://app.codility.com/demo/results/trainingGJ58Y6-KJU/
     * @param A
     * @return
     */
    public int solution(int[] A) {
        Arrays.sort(A);

        int missingInteger = 1; //모두 음수인경우 1반환으로 인한 초기값 세팅

        for (int i=0; i<A.length; i++) {
            if (A[i] == missingInteger) {
                missingInteger++;
            } else {
                return missingInteger;
            }
        }

        return missingInteger;

    }
}
