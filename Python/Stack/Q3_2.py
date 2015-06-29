#How would you design a stack which, in addition to push and pop, also has a
#function called min which returns the minimum element? Push, pop and min
#should all operate in O(1) time.
#note -> This implementation uses twice the space because two stacks are create
#of equal size, but it has O(1) access time, I can keep the space the same if I change the access time to O(n)

class Node(object):
    def __init__(self):
        self.data = None
        self.next = None

class Stack(object):
    top = Node()
    min_stack = Node()
    min_num = 9223372036854775807

    def pop(self):
        if self.top:
            item = self.top.data
            self.top = self.top.next
            self.min_stack = self.min_stack.next
            return item
        return None

    def push(self, item):
        new_node = Node()
        new_node.data = item
        new_node.next = self.top
        self.top = new_node

        if(self.top.data < self.min_num):
            self.min_num = item

        m = Node()
        m.data = self.min_num
        m.next = self.min_stack
        self.min_stack = m


    def get_min(self):
        return self.min_stack.data


def main():
    s = Stack()
    for i in xrange(0, 10):
        s.push(i)

    print s.pop()
    print s.pop()
    print s.get_min()
    print s.size()

if __name__ == '__main__':
    main()
