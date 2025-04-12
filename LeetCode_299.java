
Code


Testcase
Test Result
Test Result
299. Bulls and Cows
Solved
Medium
Topics
Companies
You are playing the Bulls and Cows game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

 

Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"
Example 2:

Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.
 

Constraints:

1 <= secret.length, guess.length <= 1000
secret.length == guess.length
secret and guess consist of digits only.



Solution:
class Solution {
    public String getHint(String s, String g) {
        HashMap<Character,Integer>hm = new HashMap<>();
        int b=0,c=0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i)))
            {
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }
            else
            {
                hm.put(s.charAt(i),1);
            }
             if(s.charAt(i)==g.charAt(i)){
                hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
                b++;
            }
           
        }
        for(int i=0;i<g.length();i++){
            if(s.charAt(i)!=g.charAt(i)){
                if(hm.containsKey(g.charAt(i)) ){
                    if(hm.get(g.charAt(i))>0){
                    hm.put(g.charAt(i),hm.get(g.charAt(i))-1);
                    c++;
                    }
                    }
                
            }
        }
        System.out.println(hm);
        String ans = "";
        ans+=Integer.toString(b);
        ans+="A";
        ans+=Integer.toString(c);
        ans+="B";
        return ans;
    }
}
