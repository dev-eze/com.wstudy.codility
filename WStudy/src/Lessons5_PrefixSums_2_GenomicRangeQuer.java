/**
 A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

 The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

 For example, consider string S = CAGCCTA and arrays P, Q such that:

 P[0] = 2    Q[0] = 4
 P[1] = 5    Q[1] = 5
 P[2] = 0    Q[2] = 6
 The answers to these M = 3 queries are as follows:

 The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 Write a function:

 class Solution { public int[] solution(String S, int[] P, int[] Q); }

 that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

 Result array should be returned as an array of integers.

 For example, given the string S = CAGCCTA and arrays P, Q such that:

 P[0] = 2    Q[0] = 4
 P[1] = 5    Q[1] = 5
 P[2] = 0    Q[2] = 6
 the function should return the values [2, 4, 1], as explained above.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [1..100,000];
 M is an integer within the range [1..50,000];
 each element of arrays P, Q is an integer within the range [0..N − 1];
 P[K] ≤ Q[K], where 0 ≤ K < M;
 string S consists only of upper-case English letters A, C, G, T.**/

import java.util.*;

/**
 * https://app.codility.com/demo/results/trainingXUTQCU-HNN/
 */
// https://mingmi-programming.tistory.com/64
    //https://funnelgarden.com/genomicrangequery-codility-solution/
    //https://rafal.io/posts/codility-genomic-range-query.html
    //https://stackoverflow.com/questions/19552754/java-codility-training-genomic-range-query
public class Lessons5_PrefixSums_2_GenomicRangeQuer {

    public int[] solution1(String S, int[] P, int[] Q) {
        S = "CAGCCTA";
        P = new int[]{2,5,0};
        Q = new int[]{4,5,6};

        String[] SArr = new String[P.length];
        List<Integer> minResultList = new ArrayList<>();
        int[] resultArr = new int[P.length];

        for (int i=0; i<P.length; i++) {
            SArr[i] = S.substring(P[i],Q[i]+1);
        }

        for (int i=0; i<P.length; i++) {
            switch (SArr[i]){
                case "A" :
                    minResultList.add(1);
                    break;
                case "C" :
                    minResultList.add(2);
                    break;
                case "G" :
                    minResultList.add(3);
                    break;
                case "T" :
                    minResultList.add(4);
                    break;
            }
            resultArr[i] = Collections.min(minResultList);
            minResultList.clear();
        }
        return resultArr;
    }

    public int[] solution2(String S, int[] P, int[] Q) {
        S = "CAGCCTA";
        P = new int[]{2,5,0};
        Q = new int[]{4,5,6};

        String[] SArr = new String[P.length];
        int[] minResultArr = new int[P.length];

        for (int i=0; i<P.length; i++) {
            SArr[i] = S.substring(P[i],Q[i]+1);
        }

        for (int i=0; i<P.length; i++) {
            if (SArr[i].indexOf("A") != -1) {
                minResultArr[i] = 1;
            } else if (SArr[i].indexOf("C") != -1) {
                minResultArr[i] = 2;
            } else if (SArr[i].indexOf("G") != -1) {
                minResultArr[i] = 3;
            } else {
                minResultArr[i] = 4;
            }
        }

        return minResultArr;
    }


    public int[] solution3(String S, int[] P, int[] Q) {
        S = "CAGCCTA";
        P = new int[]{2,5,0};
        Q = new int[]{4,5,6};

        int[] Aarr = new int[S.length()];
        int[] Carr = new int[S.length()];
        int[] Garr = new int[S.length()];
        int[] minResultArr = new int[P.length];
        int A = -1; int C = -1; int G = -1;


        for(int i = 0 ; i < S.length() ; i++){
            if(S.charAt(i) == 'A') A=i;
            if(S.charAt(i) == 'C') C=i;
            if(S.charAt(i) == 'G') G=i;
            Aarr[i] = A;
            Aarr[i] = C;
            Garr[i] = G;
        }

        for( int i = 0 ; i < P.length ; i++){
            minResultArr[i] = 4;
            if(Aarr[Q[i]] <= Q[i] && Aarr[Q[i]] >= P[i]){ minResultArr[i] = 1; continue;}
            if(Carr[Q[i]] <= Q[i] && Carr[Q[i]] >= P[i]){ minResultArr[i] = 2; continue;}
            if(Garr[Q[i]] <= Q[i] && Garr[Q[i]] >= P[i]){ minResultArr[i] = 3; continue;}
        }

        return minResultArr;
    }

    /**
     * https://app.codility.com/demo/results/training75B5QW-EM9/
     * @param S
     * @param P
     * @param Q
     * @return
     */
    public int[] solution4(String S, int[] P, int[] Q) {
        S = "CAGCCTA";
        P = new int[]{2,5,0};
        Q = new int[]{4,5,6};

        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0; i<S.length(); i++) {
            String[] arr = S.split("");

            switch(arr[i]) {
                case "A":
                    map.put(i,1);
                    break;
                case "C":
                    map.put(i,2);
                    break;
                case "G":
                    map.put(i,3);
                    break;
                case "T":
                    map.put(i,4);
                    break;
            }
        }

        Iterator it = this.sortByValue(map).iterator();

        int[] resultArr = new int[P.length];

        for (int i=0; i<P.length; i++) {
            resultArr[i] = map.get(P[i]) < map.get(Q[i]) ? map.get(P[i]) : map.get(Q[i]);
        }

        return resultArr;
    }

    public static List sortByValue(final Map map) {

        List<String> list = new ArrayList();
        list.addAll(map.keySet());

        Collections.sort(list,new Comparator() {
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                return ((Comparable) v2).compareTo(v1);
            }
        });

        Collections.reverse(list); // 주석시 오름차순
        return list;
    }

    /**
     * https://app.codility.com/demo/results/trainingF3A882-RNX/
     * @param S
     * @param P
     * @param Q
     * @return
     */
    public int[] solution5(String S, int[] P, int[] Q) {
        System.out.println("@@@@@@@");
        S = "CAGCCTA";
        P = new int[]{2,5,0};
        Q = new int[]{4,5,6};

        int[] minFactors = new int[P.length];
        int[][] prefixSums = new int[S.length()+1][4];

        //calculate prefix sums
        //Added prefix[0] for calculating the first character in the sequence
        for(int i=1; i < S.length()+1; i++){
            prefixSums[i][0] = prefixSums[i-1][0];
            prefixSums[i][1] = prefixSums[i-1][1];
            prefixSums[i][2] = prefixSums[i-1][2];
            prefixSums[i][3] = prefixSums[i-1][3];
            if(S.charAt(i-1) == 'A'){
                prefixSums[i][0]++;
            }else if(S.charAt(i-1) == 'C'){
                prefixSums[i][1]++;
            }else if(S.charAt(i-1) == 'G'){
                prefixSums[i][2]++;
            }else{
                prefixSums[i][3]++;
            }
            //System.out.println(Arrays.toString(prefixSums[i]));
        }

        for (int i=0; i<P.length; i++) {
            int fromIndex = P[i];
            int toIndex = Q[i]+1;

            //System.out.println(toIndex + " " + fromIndex);
            //System.out.println(prefixSums[toIndex][1] + " " + prefixSums[fromIndex][1]);
            if (prefixSums[toIndex][0] - prefixSums[fromIndex][0] > 0) {
                minFactors[i] = 1;
            } else if (prefixSums[toIndex][1] - prefixSums[fromIndex][1] > 0) {
                minFactors[i] = 2;
            } else if (prefixSums[toIndex][2] - prefixSums[fromIndex][2] > 0) {
                minFactors[i] = 3;
            } else {
                minFactors[i] = 4;
            }
        }
        return minFactors;
    }
}
