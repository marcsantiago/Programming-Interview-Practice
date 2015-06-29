class Queue(object):
    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def enqueue(self, v):
        self.items.insert(0, v)

    def dequeue(self):
        return self.items.pop()

    def size(self):
        return len(self.items)


q = Queue()
q.enqueue(1)

print q.dequeue()
