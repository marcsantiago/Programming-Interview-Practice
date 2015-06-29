from BaseTreeImplementation import Node, Tree

# Q3
# Given a sorted (increasing order) array with unique integer elements,
# write an algorithm to create a binary search tree with minimal height.
class TreeInitializer(object):
    def __init__(self):
        self.array = []

    def arr_to_tree(self, arr, start, end):
        # create a tree object
        # ensure that the array is empty before appending to it
        if self.array != []:
            self.array = []

        t = Tree()
        # create the node structure from the array
        structure = self._ordered_array_to_node(arr, start, end)
        # populate the global list according to the node structure
        self._pre_order_traversal(structure)
        # populate the tree using the global array
        for i in xrange(len(self.array)):
            t.add(self.array[i])

        # return the tree
        return t

    def _ordered_array_to_node(self, arr, start, end):
        # Start cannot be greater than end
        if start > end:
            return None

        mid = (start + end) / 2
        root = Node(arr[mid])
        # Populate the node structure
        root.left = self._ordered_array_to_node(arr, start, mid - 1)
        root.right = self._ordered_array_to_node(arr, mid + 1, end)

        return root

    def _pre_order_traversal(self, node):

        # recreate tree structure from passed in node
        # append that structure to the global array variable
        self.array.append(node.data)

        if node.left is not None:
            self._pre_order_traversal(node.left)

        if node.right is not None:
            self._pre_order_traversal(node.right)

def main():
    t = TreeInitializer()
    tree =  Tree()
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    tree = t.arr_to_tree(arr, 0, 9)

    print tree.in_order_traversal()
    print t.array


if __name__ == '__main__':
    main()