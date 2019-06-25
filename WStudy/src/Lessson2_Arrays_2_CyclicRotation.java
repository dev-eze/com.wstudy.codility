import java.util.*;

/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 *
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A, int K); }
 *
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 *
 * For example, given
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 *
 *     A = [0, 0, 0]
 *     K = 1
 * the function should return [0, 0, 0]
 *
 * Given
 *
 *     A = [1, 2, 3, 4]
 *     K = 4
 * the function should return [1, 2, 3, 4]
 *
 * Assume that:
 *
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */

/**
 * https://app.codility.com/demo/results/trainingFXWYHW-CCD/
 * https://app.codility.com/demo/results/trainingFPYJ7F-RCD/
 *
 */
public class Lessson2_Arrays_2_CyclicRotation {
    class Solution1 {
        public int[] solution(int[] A, int K) {
            if (A.length == K || K%A.length == 0) {
                return A;
            }

            Deque<Integer> deque = new LinkedList<>();

            for (Integer num : A) {
                deque.add(num);
            }

            for(int i=1; i<=K; i++) {
                Integer peekNum = deque.pollLast();
                deque.addFirst(peekNum);
            }

            List<Integer> list = (List)deque;

            int[] intResultArr = list.stream().mapToInt(i->i).toArray();
            return intResultArr;
        }
    }

    class Solution2 {
        public int[] solution(int[] A, int K) {
            if (A.length == K || (A.length != 0 && K%A.length == 0)) {
                return A;
            }

            Deque<Integer> deque = new LinkedList<>();

            for (Integer num : A) {
                deque.add(num);
            }

            for(int i=1; i<=K; i++) {
                Integer peekNum = deque.pollLast();
                deque.addFirst(peekNum);
            }

            List<Integer> list = (List)deque;

            int[] intResultArr = list.stream().mapToInt(i->i).toArray();
            return intResultArr;
        }
    }

    class Solution3 {
        public int[] solution(int[] A, int K) {
            if (A.length == K || (A.length != 0 && K%A.length == 0)) {
                return A;
            }

            Deque<Integer> deque = new LinkedList<>();

            for (Integer num : A) {
                deque.add(num);
            }

            for(int i=1; i<=K; i++) {
                Integer peekNum = deque.pollLast();
                deque.addFirst(peekNum);
            }

            List<Integer> list = (List)deque;

            int[] resultArr = list.stream()
                    .filter(Objects::nonNull)
                    .mapToInt(Integer::intValue)
                    .toArray();

            return resultArr;
        }
    }

    public int[] solution4 (int[] A, int K) {
        //  push는 데이터를 앞으로 입력하고, offer는 데이터를 뒤로 입력한다.
        //  push 만을 이용하여 데이터를 입력하면 스택처럼 동작하고, offer 만을 이용하여 데이터를 입력하면 큐로 동작
        //  List와 Deque를 구현한 Doubly-Linked List
        //add
        if (A.length == K || (A.length != 0 && K%A.length == 0)) {
            return A;
        }

        Deque<Integer> deque = new LinkedList<>();

        for (Integer num : A) {
            deque.add(num);
        }

        for(int i=1; i<=K; i++) {
            Integer peekNum = deque.pollLast();
            deque.addFirst(peekNum);
        }

        List<Integer> list = (List)deque;

        //Object[] objectArr = list.toArray();
        //Integer[] resultArr = Arrays.copyOf(objectArr, objectArr.length, Integer[].class);
        //int[] resultArr = list.stream().mapToInt(i->i).toArray();
        int[] resultArr = list.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .toArray();

        return resultArr;
    }
}
