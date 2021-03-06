Time spent : 50 min(See others' solution)

GIVEN: a non-empty array of numbers

RETURNS: maximum result of ai XOR aj, where 0 <= i, j < n

EXAMPLES:

```
Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
```



**This algorithm’s idea is**:<br> to iteratively determine what would be each bit of the final result from left to right. And it narrows down the candidate group iteration by iteration. e.g. assume input are a,b,c,d,…z, 26 integers in total. In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit), so you are sure your final result’s MSB is set. Now in second iteration, you try to see if among a, d, e, h, u there are at least two numbers make the 2nd MSB differs, if yes, then definitely, the 2nd MSB will be set in the final result. And maybe at this point the candidate group shinks from a,d,e,h,u to a, e, h. Implicitly, every iteration, you are narrowing down the candidate group, but you don’t need to track how the group is shrinking, you only cares about the final result.

a ^ b == c

c ^ a == b

c ^ b == a

Reference : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049



[3, 10, 5, 25, 2, 8]

[11, 1010, 101, 11001, 10, 1000]

|  i   | mask  | 1 << i |                   set                    | temp  |  max  |
| :--: | :---: | :----: | :--------------------------------------: | :---: | :---: |
|  4   | 10000 | 10000  |              (10000, 00000)              | 10000 | 10000 |
|  3   | 11000 | 01000  |          (11000, 01000, 00000)           | 11000 | 11000 |
|  2   | 11100 | 00100  |       (11000, 01000, 00100, 00000)       | 11100 | 11100 |
|  1   | 11110 | 00010  |   (00010, 01010, 00100, 11000, 01000)    | 11110 | 11100 |
|  0   | 11111 | 00001  | (00011, 01010, 00101, 11001, 00010, 01000) | 11110 | 11100 |
|      |       |        |                                          |       |       |

