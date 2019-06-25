import java.util.ArrayList;
import java.util.List;

/**
 * https://app.codility.com/demo/results/trainingTUYSU7-52Y
 */
public class Lessons5_PrefixSums_1_PassingCars {
    public Integer solution() {
        int[] A = new int[]{0,1,0,1,1};
        //Integer index = Arrays.binarySearch(A, 0);
        List<Integer> zeroIndexList = new ArrayList<>();
        Integer oneCount = 0;
        Integer result = 0;

        for (Integer i=0; i<A.length; i++) {
            if (A[i] == 0) {
                zeroIndexList.add(i);
            }
        }

        for  (Integer i=0; i<zeroIndexList.size(); i++) {
            Integer jInit = zeroIndexList.get(i);

            for (int j=jInit; j<A.length; j++) {
                oneCount += A[j];
            }

        }

        return oneCount;
    }

    public Integer solution1() {
        int[] A = new int[]{0,1,0,1,1};
        List<Integer> zeroIndexList = new ArrayList<>();
        Integer oneCount = 0;
        Integer result = 0;

        for (Integer i=0; i<A.length; i++) {
            if (A[i] == 0) {
                zeroIndexList.add(i);//0,2
            }
        }

        for (int j=0; j<A.length; j++) {//j=0,1,2,3,4
            if (zeroIndexList.contains(j)) {

            }
        }

        return oneCount;
    }
}
