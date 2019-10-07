class Solution:
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if not len(s):
            return ''
        tt = t
        t = collections.Counter()
        for l in tt:
            t[l] += 1
        total = len(t)
        cur = collections.Counter()
        cur_total = 0
        if s[0] in t:
            cur[s[0]] += 1
            if t[s[0]] == cur[s[0]]:
                cur_total += 1
        ans = s + ' '
        i = 0
        j = 1
        while True:
            if cur_total < total:
                if j == len(s):
                    break
                if t[s[j]] > 0:
                    cur[s[j]] += 1
                    if cur[s[j]] == t[s[j]]:
                        cur_total += 1
                j += 1
            else:
                if j - i < len(ans):
                    ans = s[i:j]
                if s[i] in t:
                    cur[s[i]] -= 1
                    if cur[s[i]] < t[s[i]]:
                        cur_total -= 1
                i += 1
            if j > len(s):
                break
        return ans if len(ans) <= len(s) else ''
