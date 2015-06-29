# Implement a MyQueue class which implements a queue using two stacks

class MyQueue(object):
    def __init__(self):
        self.new_stack = []
        self.old_stack = []

    def enqueue(self, item):
        self.new_stack.append(item)

    def old_to_new(self):
        while self.new_stack:
            self.old_stack.append(self.new_stack.pop())

    def dequeue(self):
        self.old_to_new()
        return self.old_stack.pop()


q = MyQueue()

for i in xrange(1, 10):
    q.enqueue(i)

print q.dequeue()
print q.dequeue()