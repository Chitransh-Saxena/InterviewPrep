package com.DSA.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreak {

     /*
    Backtracking solution (Internet)
            -> Try to partition at each possible partition point
                -> How to decide where to create a partition
                -> Start traversing from index 0 and check at which point can we form a substring which can found in the dictionary
                    -> Isn't this process gonna take O(N^2)
                -> We will use recursion for this
                    -> We will use the standard pick and not pick approach for the characters, but in a substring manner, not in a subsequence manner
                        -> This means, if we are at character 2, and we decide to not choose it, then we cannot carry forward character 1
                            -> We will consider fresh string starting from character 3
                        -> Although in other recursion cycles, we would be moving forward with all character 1, 2 and 3
                -> Time complexity for this?
                    -> In the worst case, all the characters of the string A would be present in the dictionary B.
                        -> In that case, we would end up creating partition at each point
                        -> For a string of length N, N partitions could be created.
                            -> Now, in case of recursion, we decide to choose or not choose a character.
                                -> Since in each case we have 2 choices, the size of search space would be around 2^N

    We can add memoization
        -> We can use some map to store the end pointer of the valid string once we get it.
            -> Example, if we are at i = 2, and after checking if we know that we get some valid string at i = 7
                -> We can store it like 2,7 in the map.
                    -> Now, if any of the recursion tree will search for i = 2, they have an answer and thus a lot of processing is saved.
                        -> Exactly how much processing is saved?
                            -> How to calculate?
        -> With above optimization, the time complexity will reduce to O(N^2) * O(N)
            -> O(N) for the substring function

    Optimization in backtracking approach
        -> On a pen paper, if we make the recursion tree of the characters in string A, we will notice that many combinations of the word are repeating.
            -> How can we leverage this?
                -> This is what DP is all about. Storing the repeated data, and look up it's result instead of doing all the calculations again
                -> What do we store? How do we store? How do we leverage it?
        -> So, when do we use DP?
            -> When we can break the problem in some sort of subproblem
                -> If we have solution for some smaller subproblem, then we can build solution for the bigger problem
            -> When we can notice repeating subproblems

            -> After applying recursion for the above solution



    */

    public boolean canBreak(String s, int pos, Set<String> dictionary, Map<Integer, Integer> map) {

        // If we reach the end of the string, we return true. Because this means we were able to create valid paritions until this point.
        if(pos == s.length()) {
            return true;
        }

        if(map.containsKey(pos)) {

            return canBreak(s, map.get(pos), dictionary, map);
        }

        for(int i = pos; i<s.length(); ++i) {

            // At each index, we check if sequentially we can make a valid string. (Which is present in dictionary)
            if(dictionary.contains(s.substring(pos, i+1))) {

                // If it is present in dictionary, then we check for further points
                // Note that in recursive call i+1 is passed and not pos.
                // This is because we want to start the recursive call from the starting of next possible valid word
                // So, when the current valid string ends (which is present in the dictionary), we start the recursive call from it's next character.
                if(canBreak(s, i+1, dictionary, map)) {
                    map.put(pos, i);
                    return true;
                }
            }
        }

        return false;


    }

    public int wordBreak(String A, ArrayList<String> B) {

//        Set<String> dictionary = new HashSet<>();
//
//        for(String string: B) {
//
//            dictionary.add(string);
//        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        return canBreak(A, 0, dictionary, map) == true ? 1 : 0;




        // We need to memoize that if at any index we found some answers or not.
        // We can try to store index of those pos where we found some num.
        Set<Integer> set = new HashSet<>();
        // return canBreak(A, 0, dictionary, set) == true ? 1 : 0;

        /*
         * After applying the recursion method above, I can see that the problem can be broken into subproblems
         * This goes like this. We had a full string "myinterviewtrainer"
         * At each point, we were checking if it is a valid substring.
         * We did this by creating substrings using recursion
         * We added optimization on two levels, one was that once we find that current substring is part of dictionary, then we proceed
         * and check for the rest of the string recursively
         * This means, once we know "my" is part of dictionary, we do this for "interviewtrainer"
         * And then, we added a map, which was storing the ending index of the valid word.
         * Example, if we find a valid word like my or trainer, we store the startIndex, endIndex as K,V in map
         * This way, if any of the recursion tree calls for K, they have V and can proceed further.
         *
         *
         * Since the problem could be broken into subproblems, we can apply DP here
         * We can build a DP table for our string "myinterviewtrainer"
         * In our recursion call also we were expecting that each index could be a parition point, and thus moved forward with that.
         * THE MAIN PRINCIPLE HERE IS, IF THE ITEM IS PRESENT IN DICTIONARY, THEN NO NEED TO SPLIT IT, JUST MOVE ON
         * Here also, we will do the same thing.
         * We will start a sliding from size 1. (Single character)
         * Check if that character is present in the dictionary, and populate the DP table with that info.
         * Now, we start a sliding window of size 2
         * again, we check if the substring is present in dictionary, if the word is present, we mark true ther
         * BUT IF THE WORD IS NOT PRESENT, WE HAVE TO CHECK FOR SUBPROBLEMS (smaller paritions)
         * Here, we can take DP table help. Example: "my" was present in dictionary, so we marked true.
         * "in" (second word of size 2), is not present in the dictionary, so we have to check for subproblems
         * What we will do here, check for 'i' and check for 'n'. Why? Because, there is a possibility that subproblem might return true.
         *
         *
         * Above video solution was a little confusing
         * Watching Tuashar Roy's video now - https://www.youtube.com/watch?v=WepWFGxiwRs
         */


        return 1;
    }
}
