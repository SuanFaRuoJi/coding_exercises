class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        res = []
        
        def check(s):
            t = 0
            r = 0
            w = 0
            for i in s:
                if i == '(':
                    t += 1
                elif i == ')':
                    if t == 0:
                        r += 1
                    else:
                        t -= 1
                else:
                    w += 1
            r += t
            return (len(s) - r - w) // 2
        
        def dfs(s, l, r, i, ans, last):
            if i == len(s) and l == 0 and r == 0:
                res.append(ans)
                return
            elif i == len(s):
                return
            if l > r or r < 0 or l < 0:
                return
            if s[i] == '(':
                dfs(s, l, r, i + 1, ans, '(')
                if last != '(':
                    dfs(s, l - 1, r, i + 1, ans + '(', '')
            elif s[i] == ')':
                dfs(s, l, r, i + 1, ans, ')')
                if last != ')':
                    dfs(s, l, r - 1, i + 1, ans + ')', '')
            else:
                dfs(s, l, r, i + 1, ans + s[i], '')
              
        l = check(s)
        r = l        
        dfs(s, l, r, 0, '', '')
        return res

