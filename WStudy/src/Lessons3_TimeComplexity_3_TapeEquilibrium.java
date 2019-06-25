import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 *
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 *
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 *
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 *
 * For example, consider array A such that:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * We can split this tape in four places:
 *
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 *
 * For example, given:
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * the function should return 1, as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 */
public class Lessons3_TimeComplexity_3_TapeEquilibrium {
    int[] A = new int[]{3,1,2,4,3};

    /*
    index i일 때 i 이전의 합, i 이후의 합의 절대값차 중 가장 작은 값을 리턴한다.
     */

    /**
     * https://app.codility.com/demo/results/trainingT7J3KS-326/
     * @return
     */
    public int solution1() {
        int aSum = IntStream.of(A).sum();
        int iberoreSum = 0;
        int iafterSum = 0;
        int minimalDiffernce = aSum; // 배열A 요소의 전체합으로 초기

        for (int i=0; i<A.length; i++) {
            iberoreSum += A[i];
            iafterSum = aSum - iberoreSum;
            int absGap = Math.abs(iberoreSum - iafterSum);

            if(minimalDiffernce > absGap) { // 또는 Collections.Min사용
                minimalDiffernce = absGap;
            }
        }
        return minimalDiffernce;
    }

    /**
     * https://app.codility.com/demo/results/trainingJHHB87-D54/
     * @return
     */
    public int solution2() {
        int aSum = 0;
        int iberoreSum = 0;
        int iafterSum = 0;

        for (int eachInt : A) {
            aSum += eachInt;
        }

        int minimalDiffernce = aSum;

        for (int i=0; i<A.length; i++) {
            iberoreSum += A[i];
            iafterSum = aSum - iberoreSum;
            int absGap = Math.abs(iberoreSum - iafterSum);

            if(minimalDiffernce > absGap) { // 또는 Collections.Min사용
                minimalDiffernce = absGap;
            }
        }
        return minimalDiffernce;
    }

    /**
     * https://app.codility.com/demo/results/trainingKZZ5K4-TFQ/
     * @return
     */
    public int solution3() {
        int aSum = IntStream.of(A).sum();
        int iberoreSum = 0;
        int iafterSum = 0;

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<A.length; i++) {
            iberoreSum += A[i];
            iafterSum = aSum - iberoreSum;
            int absGap = Math.abs(iberoreSum - iafterSum);

            list.add(absGap);
        }
        return Collections.min(list);
    }

    /**
     * https://app.codility.com/demo/results/training48ZWRE-XD6/
     * @return
     */
    public int solution4() {
        int aSum = 0;
        int iberoreSum = 0;
        int iafterSum = 0;

        List<Integer> list = new ArrayList<>();

        for (int eachInt : A) {
            aSum += eachInt;
        }

        for (int i=0; i<A.length; i++) {
            iberoreSum += A[i];
            iafterSum = aSum - iberoreSum;
            int absGap = Math.abs(iberoreSum - iafterSum);
            list.add(absGap);

        }
        return Collections.min(list);
    }
}
