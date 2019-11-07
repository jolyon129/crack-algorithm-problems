package com.leetcode.jolyon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC1055ShortestWaytoFormString {
    public int shortestWay(String source, String target) {
        char[] sourceCharArr = source.toCharArray(), ts = target.toCharArray();
        int res = 1;
        List<Integer>[] invertedIdx = new List[26];
        for (int i = 0; i < 26; i++) invertedIdx[i] = new ArrayList<>();
        for (int i = 0; i < sourceCharArr.length; i++) invertedIdx[sourceCharArr[i] - 'a'].add(i);
        int offsetIdxinSource = 0;
        for (int i = 0; i < ts.length; ) {
            List<Integer> tar = invertedIdx[ts[i] - 'a'];
            if (tar.isEmpty()) return -1;
            int k = Collections.binarySearch(tar, offsetIdxinSource);
            if (k < 0) k = -k - 1;
            if (k == tar.size()) {
                res++;
                // The next possible offset index should start with 0
                offsetIdxinSource = 0;
            } else {
                // The next possible offset index should start with the
                // current one plus one
                offsetIdxinSource = tar.get(k) + 1;
                i++;
            }

        }
        return res;
    }

    public int shortestWay2(String source, String target) {
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int M = s.length;
        int N = t.length;

        // Build inverted index for source

        // dict[i]['a'] denotes the index of the closest occurrence of 'a'
        // starting from index i
        int[][] listOfDict = new int[M][26];

        Arrays.fill(listOfDict[M - 1], -1); // -1 represents no occurrence of the character

        listOfDict[M - 1][s[M - 1] - 'a'] = M - 1;
        for (int x = M - 2; x >= 0; --x) {
            listOfDict[x] = Arrays.copyOf(listOfDict[x + 1], 26);
            listOfDict[x][s[x] - 'a'] = x;
        }

        int ans = 0;
        int idx = 0;
        // Go through target and account for each character
        for (char c : t) {
            // If there are no occurrences of c with index greater than 0
            // then it doesn't occur at all. Hence, we cannot get that letter from
            // a subsequence of source.
            if (listOfDict[0][c - 'a'] == -1) return -1;

            // If there are no c's left in source that occur >= idx
            // but there are c's from earlier in the subsequence
            // add 1 to subsequence count and reset idx of source to 0.
            if (listOfDict[idx][c - 'a'] == -1) {
                // we need one more source string to build the target.
                ++ans;
                idx = 0;
            }

            // Then continue taking letters from the subsequence
            idx = listOfDict[idx][c - 'a'] + 1;

            // In this case, we've matched the end of the source string
            if (idx == M) {
                ++ans;
                idx = 0;
            }
        }
        /***
         * At the end, the check for (idxOfS == 0? 0 : 1) represents whether or not we were in the
         * middle of matching another subsequence. If we were in the middle of matching it,
         * then we would need an extra subsequence count of 1 since it was never accounted for.
         */
        return ans + (idx == 0 ? 0 : 1);
    }
}
