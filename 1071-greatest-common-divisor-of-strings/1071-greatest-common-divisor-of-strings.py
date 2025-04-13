class Solution:
    def gcdOfStrings(self, a: str, b: str) -> str:
        # 적은 문자열의 반까지 한번 늘려가면서 대입해보기
        if a+b != b+a:
            return ""
        if len(a) == len(b):
            return a 
        if len(a)>len(b):
            return self.gcdOfStrings(b, a[len(b):])
        return self.gcdOfStrings(a, b[len(a):])
        