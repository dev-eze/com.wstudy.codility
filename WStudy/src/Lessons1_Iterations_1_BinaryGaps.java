import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://app.codility.com/demo/results/training7XQQUC-F2G/
 */
public class Lessons1_Iterations_1_BinaryGaps {
    public int solution(int N) {
        String inputBinary = Integer.toBinaryString(N);
        String[] binaryArr = inputBinary.split("");
        List<Integer> binaryList = new ArrayList();
        Integer zeroCount = 0;

        for(int i=0 ;i<binaryArr.length; i++) {
            if("0".equals(binaryArr[i])) {
                zeroCount ++;
            }

            if("1".equals(binaryArr[i])) {
                binaryList.add(zeroCount);
                zeroCount = 0;
            }
        }

        return (int) Collections.max(binaryList);
    }
}
