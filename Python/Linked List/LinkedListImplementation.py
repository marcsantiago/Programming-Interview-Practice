from math import floor


class Node(object):
    def __init__(self):
        self.data = None # contains the data
        self.next = None # contains the reference to the next node


class LinkedList(object):
    def __init__(self):
        self.cur_node = None

    def add(self, data):
        new_node = Node() # create a new node
        new_node.data = data
        new_node.next = self.cur_node # link the new node to the 'previous' node.
        self.cur_node = new_node #  set the current node to the new one.

    #write a method that appends to the tail instead of the head
    def append(self, data):
        new_node = Node()
        new_node.data = data
        node = self.cur_node
        while node.next:
            node = node.next
        node.next = new_node

    def delete_node(self, data):
        node = self.cur_node
        if node.data == data:
            node.data = node.next.data
            node.next = node.next.next
            return

        while node.next:
            if node.next.data == data:
                node.next = node.next.next
                return
            node = node.next

    def list_print(self):
        node = self.cur_node # cant point to ll!
        while node:
            print node.data, 
            node = node.next

    # answer to question 2_1
    # Write code to remove duplicates from an unsorted linked list
    def remove_dup(self):
        lset = set()
        previous = Node()
        node = self.cur_node
        while node:
            if node.data in lset:
                previous.next = node.next
            else:
                lset.add(node.data)
                previous = node
            node = node.next

    # answer to question 2_1
    # Implement an algorithm to find the kth to last element of a singly linked list

    #METHOD1
    #Method 1 ->Find the size of the linked list
    #MEthod 2 ->Use the size of the list -> size() - k == position of k

    def size(self):
        count = 0
        node  = self.cur_node
        while node:
            node = node.next
            count += 1
        return count

    # def search_k_from_end(self, k):
    #     if k <= 0 or k > self.size():
    #         return None

    #     element_location = self.size() - k
    #     node = self.cur_node
    #     for i in xrange(element_location):
    #         node = node.next

    #     return node.data


    #Method 2
    #Have 2 pointers, p1 and p2, p2 is set to length of k
    #run both pointers at the same time.  When p2 reaches the end, p1 should be at the right node

    def search_k_from_end(self, k):
        if k <= 0:
            return None

        p1 = self.cur_node
        p2 = self.cur_node

        for i in xrange(k - 1):
            if p2 == None:
                return None
            p2 = p2.next

        if p2 == None:
            return None

        while p2.next:
            p1 = p1.next
            p2 = p2.next

        return p1.data   


    #answer to question 2_3 Implement an algorithm to delete a node in 
    #the middle of a singly linked list given only access to that node
    #Implement an algorithm to find the kth to last element in a singly linked list
    
    #Method 1 find the size of the list using a the size method created above,
    #The size of the list / 2, floored, minus 1 gives us two nodes before the actually middle
    #Iterate to that node, set node.next == node.next.next (skipping middle node)

    def delete_middle_node(self):
        middle = int(floor(self.size() / 2) - 1)
        node = self.cur_node
        for i in xrange(middle):
            node = node.next
        node.next = node.next.next



    #answer to question 2_4 write code to partition a linked list around a value x
    #such that all nodes lower than x are on the left and all nodes equal to or greater
    #than x are on the right

    #Method 1, create two list
    #Add numbers lower than x to left else right
    #Combine those list and remove them
    #create a new Node
    #add values to new node

    def sortbyx(self, x):
        left = []
        right = []
        node = self.cur_node
        new_linked_list = LinkedList() #create a new linked list
        while node: #don't use node.next here, don't want to skip data
            if node.data >= x:
                right.append(node.data)
            else:
                left.append(node.data)
            node = node.next 
        
        merged_list =  left + right
        # empty list to release memory
        left = []
        right = []

        #add the head to the new linked list
        new_linked_list.add(merged_list[0])
        for i in xrange(1, len(merged_list)):
            new_linked_list.append(merged_list[i])
        
        return new_linked_list 



    #2_5 you have to numbers representation by a linked list, where each node
    #contains a single digit.  The digits are stored in reverse order, such that
    #the 1st digit is at the head of the list. Write a function that adds the numbers
    #and returns the sum(reversed) as a linkedlist
    #e.g (7->1->6) + (5->9->2) = 617 + 295
    #    (2->1->9)            == 912
    #Method 1
    #Build two linkedlist

    def build_data_list(self, linkedlist):
        arr = []
        n = linkedlist.cur_node
        while n:
            arr.append(n.data)
            n = n.next

        return arr[::-1]


    def reverse_add(self, list1, list2):

        l1 = self.build_data_list(list1)
        l2 = self.build_data_list(list2)

        result = int("".join([str(i) for i in l1])) + int("".join([str(i) for i in l2]))
        
        final_ll = LinkedList()
        final_ll.add(result % 10)
        result = result / 10

        while result > 0:
            final_ll.append(result % 10)
            result /= 10

        return final_ll


    #2_7 implement an function to check if a linked list is a palindrome
    #Method 1 (See Method 2 in book)
    def is_palindrome(self):
        fh = []
        sh = []
        count = 0
        skip = True
        n = self.cur_node

        while n:
            if self.size() % 2 == 0:
                if count < self.size() / 2:
                    fh.append(n.data)
                else:
                    sh.append(n.data)
            else: 
                if count < self.size() / 2:
                    fh.append(n.data)
                else:
                    if skip:
                        n = n.next
                    skip = False
                    sh.append(n.data)
            count += 1
            n = n.next

        sh = sorted(sh)

        for i in xrange(len(fh)):
            if fh[i] != sh[i]:
                return False

        return True


# ll = LinkedList()
# ll.add(1) # give list a head
# ll.append(3)
# ll.append(7)
# ll.append(20)
# ll.append(10)

f = LinkedList()
f.add(3)
f.append(7)
f.append(7)
f.append(3)
#f.append(2)


print f.is_palindrome()





