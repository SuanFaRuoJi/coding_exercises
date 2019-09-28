class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        l = []
        d = []
        for log in logs:
            id, content = log[:log.find(' ')], log[log.find(' ') + 1:]
            if content[0].isdigit():
                d.append(log)
            else:
                l.append((content, id))
        return [id + ' ' + content for content, id in sorted(l)] + d

