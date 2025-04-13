class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        a_len=len(word1)
        b_len=len(word2)
        max_len = max(a_len, b_len)
        answer=""
        for i in range(max_len):
            if(i<a_len):
                answer+=word1[i]
            if(i<b_len):
                answer+=word2[i]
        return answer