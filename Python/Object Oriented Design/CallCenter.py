# Image you have a call center with three levels of employees: respondent, manager, and director.
# An in coming call must first be allocated to a respondent who is free.  If the respondent can't handle the call
# he or she must escalate the call to a manager.  If the manager is not free or not able to handle it, then the call
# should be escalated to the director.  Design the classes and data structures for this problem.  Implement a method
# dispatch_call() which assigns a call to the first available employee.

from random import randint


class Employee(object):
    def __init__(self):
        # represents basic information about employees
        self.name = None
        self.age = None
        self.busy = False


class Respondent(Employee):
    def __init__(self):
        super(Respondent, self).__init__()
        self.level = 1


class Manager(Employee):
    def __init__(self):
        super(Manager, self).__init__()
        self.level = 2


class Director(Employee):
    def __init__(self):
        super(Director, self).__init__()
        self.level = 3


class CallCenter(object):
    def __init__(self, num_respondents=0, num_mangers=0, num_directors=0):
        self.respondents = []
        self.mangers = []
        self.directors = []
        self.num_busy = 0
        # create employee objects
        for i in xrange(num_respondents):
            self.respondents.append(Respondent())

        for i in xrange(num_mangers):
            self.mangers.append(Manager())

        for i in xrange(num_directors):
            self.directors.append(Director())

    def dispatch_call(self):
        # test arbitrary number of calls
        calls = randint(1, 10)
        while calls != 0:
            while self.respondents:
                obj = self.respondents[0]
                if obj.busy:
                    self.respondents.pop(0)
                else:
                    print obj, "can take the call"
                    obj.busy = True
                    self.respondents.insert(0, obj)
                    calls -= 1

            while self.mangers:
                obj = self.mangers[0]
                if obj.busy:
                    self.mangers.pop(0)
                else:
                    print obj, "can take the call"
                    obj.busy = True
                    self.mangers.insert(0, obj)
                    calls -= 1

            while self.directors:
                obj = self.directors[0]
                if obj.busy:
                    self.directors.pop(0)
                else:
                    print obj, "can take the call"
                    obj.busy = True
                    self.directors.insert(0, obj)
                    calls -= 1

            if calls != 0:
                if self._all_busy():
                    print "All persons are busy please try again later"
                    return

    def _all_busy(self):
        for i in self.respondents:
            if not i.busy:
                return False

        for j in self.mangers:
            if not j.busy:
                return False

        for k in self.directors:
            if not k.busy:
                return False

        return True


def main():
    cc = CallCenter(3, 4, 3)
    cc.dispatch_call()
    print

if __name__ in "__main__":
    main()