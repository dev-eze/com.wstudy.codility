/**
 * https://app.codility.com/demo/results/trainingNH9TRC-TE2/
 */
public class Lessons2_Arrays_1_Anonymous {
    public int solution() {
        int[] A = new int[]{9,3,9,3,9,7};
        Integer oddNumber = 0;
        for (Integer number : A) {
            oddNumber = oddNumber^number;
        }

        return oddNumber;
    }
}
