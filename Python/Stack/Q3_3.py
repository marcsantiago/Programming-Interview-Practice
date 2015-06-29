# Implement a data structure called SetOfStacks that mimics this.  SetOfStacks should
# be composed of several stacks and should create a new stack once the previous
#one exceeds capacity.  Push and pop should act as if there is just one stack

class Node(object):
    def __init__(self):
        self.data = None
        self.next = None


class SetOfStacks(object):
    # not really necessary, nodes just make it messy, pythons list can do the work,
    # but the problem said to make a stack structure
    top = Node()
    capacity = 10
    count = 0
    stacks = list()
    s = list()

    def pop(self):
        if len(self.s) is None or len(self.stacks) is None:
            return None
        if len(self.s):
            v = self.s.pop()
            return v
        else:
            v = self.stacks[self.get_last_stack()].pop()
            return v

    def pop_at(self, index):
        if self.get_last_stack() is None or index > self.get_last_stack():
            return None
        if self.s != [] and index == 0 and self.get_last_stack() is None:
            return self.s.pop()
        else:
            return self.stacks[index].pop()


    def push(self, item):
        n = Node()
        n.data = item

        if not self.is_full():
            self.top = n
            self.s.append(self.top.data)
        else:
            self.stacks.append(self.s)
            self.reset_stack()
            self.s = []
        self.count += 1


    def peek(self):
        if len(self.s) is None or len(self.stacks) is None:
            return None
        if len(self.s):
            return self.s[-1]
        else:
            v = self.stacks[self.get_last_stack()]
            return v[-1]

    def is_empty(self):
        return self.top.data is None

    def is_full(self):
        return self.capacity == self.count

    def reset_stack(self):
        self.count = 0

    def get_last_stack(self):
        if (len(self.stacks)) == 0:
            return None
        return len(self.stacks) - 1


