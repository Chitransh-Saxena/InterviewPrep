package com.DSA.DP;

public class WordBreakDP {

    class Solution {
        /*

            traverse wordDict
                -> pick a word
                    -> check if this string exists in string s
                        -> If yes, we move on to next word in the dictionary

            catsandog
            -> search for cats
                -> we get it, remove this from 's'
                -> s = andog
                    -> search for dog
                        -> we get, so remove this from 's'
                        -> s = an
                            -> Continue iteration of the dictionary and search for 'an'
                                -> Since not found, return false

            c a t s a n d d o g


            Backtracking
            -> generate substrings from string s
            -> decide on how to choose the word



            DP
            leetcode

                l   e   e   t   c   o   d   e
            l   F   F   F   T   F   F   F   T
            e       F   F   F   F   F   F   F
            e           F   F   F   F   F   F
            t               F   F   F   F   F
            c                   F   F   F   T
            o                       F   F   F
            d                           F   F
            e                               F


            One main fundamental concept in this problem which I am not able to understand is this
            If we check some subtring, and if that substring is not in dictionary, we have to check the further splits formed by the substring
            If, in any of the combinations all the splits of the words are in dictionary, we say that the word is part of dictionary


            So, by this logic, if we find the word, well and good. If not, then we have to check for each combination of the word and see in any condition
            each of the split is part of dicitonary.

            Here, one question can arise, how do we know how many splits to be formed. And how do we form those splits?
            Via classic array traversal, this would have been done in O(N) time. But with DP, it can be easier. (O(N))

            How?
            If we have some substring say "catsand" and we have some dictionary [cat, s, and]

            We will start by splitting from first character and rest of the string (two splits)
            c, atsand
            Is 'c' part of dictionary? No
            If above is No, then no need to check other half. Because even if it is true, we still cannot take it (all the splits have to be part of dictionary)

            We now move the pointer one position ahead, and check for "ca" and "tsand"
                -> Here also same logic, "ca" is not part of dictionary.
                    -> But this time, we check for "c" as well as "a"
                    -> So, now here is the contradictory part which I was not able to understand
                    -> That even if "ca" is not part of dictionary, but if "c" and "a" are part of dictionary, we will mark "ca" as true (part of dictionary)
                -> Here it is not the case, so we move the pointer ahead

            "cat"
            Is it part of dictionary? Yes
            Then we check the second half, "sand", is it part of dictionary?
            No, but we check the subparts
            we split from s and rest of the string
            Is "s" part of dictionary? Yes
            So, we check the second half of dictionary.
            Is "and" part of  dictionary? Yes.

            So, our final answer is yes




            NOTE to me:
            Even after having clarity on the approach, it was a little tough to code it out.
            I think it still means that somewhere I do not understand the solution properly.
            The subproblem concept and approaching it via code was not very clear to me


        */
        public boolean wordBreak(String s, List<String> wordDict) {

            boolean DP[][] = new boolean[s.length()+1][s.length()+1];

            int n = s.length();
            Set<String> set = new HashSet<>();

            for(String str: wordDict) {
                set.add(str);
            }

            for(int len = 1; len<=n; len++) {

                int i = 1;
                for(int j = len; j<=n; j++) {
                    String tmp = s.substring(i-1, i-1+len);
                    if(set.contains(tmp)) {
                        DP[i][j] = true;
                    }
                    else {

                        // We try to solve for subproblem for as long as possible
                        boolean flag = false;
                        for(int k = i; k<j; k++) {
                            if(DP[i][k] && DP[k+1][j]) {

                                flag = true;
                                break;
                            }
                        }

                        DP[i][j] = flag;
                    }

                    i+=1;
                }
            }

//         for(int i = 0; i<=n; i++) {
//             for(int j = 0; j<=n; j++) {
//                 System.out.print(DP[i][j] + "   ");
//             }

//             System.out.println();
//         }

            return DP[1][n];

        }
    }
}
