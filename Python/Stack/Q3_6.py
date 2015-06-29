# write a program to sort a stack in ascending order (with biggest items on self.top)
#you may use at most one additional stack to hold items, you may not copy elements
#into any other data structure (such as an array), the stack supports the following
#push, pop, peek, isEmpty


class Node(object):
    def __init__(self):
        self.data = None
        self.next = None


class Stack(object):
    top = Node()

    def push(self, item):
        n = Node()
        n.data = item
        n.next = self.top
        self.top = n

    def pop(self):
        if self.top:
            item = self.top.data
            self.top = self.top.next
            return item
        return None

    def peek(self):
        return self.top.data

    def is_empty(self):
        return self.top.data is None


#solution
def sort(s):
    r = Stack()
    while not s.is_empty():  # continue while we haven't popped all the data from s
        temp = s.pop()
        # if r is empty we can't pop from it so check and if the top number is in r
        # is greater than temp pop it and push it back in s
        # Otherwise push temp in r
        while not r.is_empty() and r.peek() > temp:
            s.push(r.pop())
        r.push(temp)
    return r


s = Stack()
s.push(3)
s.push(8)
s.push(2)
s.push(1)
s.push(7)
s.push(0)

n = sort(s)

print n.pop()
print n.pop()
print n.pop()
print n.pop()
print n.pop()
print n.pop()



