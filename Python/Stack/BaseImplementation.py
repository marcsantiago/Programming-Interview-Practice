class Node(object):
    def __init__(self):
        self.data = None
        self.next = None


class Stack(object):
    top = Node()

    def pop(self):
        if self.top:
            item = self.top.data
            self.top = self.top.next
            return item
        return None

    def push(self, data):
        t = Node()
        t.data = data
        t.next = self.top
        self.top = t

    def peek(self):
        return self.top.data
