"""
# Definition for an Interval.
class Interval:
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""


class Solution:
    def employeeFreeTime(self, schedule: 'list<list<Interval>>') -> 'list<Interval>':
        schedule = sorted([s for p in schedule for s in p],
                          key=lambda x: x.start, reverse=True)
        schedule_ = []
        while len(schedule):
            t = schedule.pop()
            if len(schedule_) and schedule_[-1].end >= t.start:
                schedule_[-1].end = max(schedule_[-1].end, t.end)
            else:
                schedule_.append(t)
        ans = []
        for i in range(len(schedule_) - 1):
            ans.append(Interval(schedule_[i].end, schedule_[i + 1].start))
        return ans
