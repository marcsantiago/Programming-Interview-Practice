class Node(object):
    def __init__(self, d=None):
        self.left = None
        self.right = None
        self.data = d


class Tree(object):
    def __init__(self):
        self.root = None

    # methods to add data to to the binary search tree
    def add(self, d):
        node_to_add = Node(d)
        if self.root is None:
            self.root = node_to_add
        self._traverse_and_add(self.root, node_to_add)

    def _traverse_and_add(self, node, new_node):
        if new_node.data < node.data:
            if node.left is None:
                node.left = new_node
            else:
                self._traverse_and_add(node.left, new_node)

        elif new_node.data > node.data:
            if node.right is None:
                node.right = new_node
            else:
                self._traverse_and_add(node.right, new_node)

    # methods to traverse
    # dfs
    def in_order_traversal(self):
        if self.root is not None:
            traversing_node = self.root
            if traversing_node.left is None and traversing_node.right is None:
                print traversing_node.data
            else:
                self._in_order_traversal(traversing_node)

    def _in_order_traversal(self, root_node):
        if root_node.left is not None:
            self._in_order_traversal(root_node.left)

        print root_node.data

        if root_node.right is not None:
            self._in_order_traversal(root_node.right)

    # bfs
    def breath_first_search(self):
        if self.root is not None:
            queue = []
            queue.insert(0, self.root)
            while queue:
                node = queue.pop()
                print node.data
                if node.left is not None:
                    queue.insert(0, node.left)
                if node.right is not None:
                    queue.insert(0, node.right)

    # methods to find data
    def find(self, d):
        new_node = Node(d)
        if self.root is not None:
            if self._find_node(self.root, new_node):
                return True
        return False

    def _find_node(self, search, n):
        if search is None:
            return None

        if search.data == n.data:
            return search

        else:
            return_node = self._find_node(search.left, n)
            if return_node is None:
                return_node = self._find_node(search.right, n)
            return return_node

    # Q1
    # Implement a function to check if a binary tree is balanced. For the purposes
    # of this question, a balance tree is defined to be a tree such that the height
    # of the two subtrees of any node never differ by more than one.

    def _get_depth(self, root):
        if self.root is None:
            return None
        return max(self._get_depth(root.left) if root.left else 0, self._get_depth(root.right) if root.right else 0) + 1

    def is_balanced(self):
        if self.root.data is None:
            return True
        height_difference = self._get_depth(self.root.left) - self._get_depth(self.root.right)
        if abs(height_difference) > 1:
            return False
        return True

    # Q2
    # given a directed graph, design an algorithm to find out whether there
    # is a route between to nodes.
    def is_path(self, first, second):
        # check to see if the root is empty
        if self.root is None:
            return None

        # check to see if first and second nodes are are either side of the root
        # if so there can be no path between second and first node
        if first < self.root.data and second > self.root.data:
            return False

        if first > self.root.data and second < self.root.data:
            return False

        # find where each node is on the tree
        # convert integer data into nodes
        fn = Node()
        fn.data = first

        sn = Node()
        sn.data = second

        first_node = self._find_node(self.root, fn)
        second_node = self._find_node(self.root, sn)

        # find the depth of each node
        # if the first and second node are located on the some level there can be no path
        # If the second node is not deeper than the first node then there can be no path , since this is a
        # directed graph, directions flow from top to bottom

        fnd = self._node_depth(self.root, first_node)
        snd = self._node_depth(self.root, second_node)

        if fnd != snd:
            if fnd > snd:
                return False
            return self._modified_inorder_traversal(first_node, second_node)
        return False

    def _node_depth(self, root, target):
        # check to make sure root isn't none or target node is the root
        if root is None or root.data == target.data:
            return 0

        if target.data < root.data:
            return max(self._node_depth(root.left, target) if root.left else 0, 0) + 1
        return max(self._node_depth(root.right, target) if root.right else 0, 0) + 1

    def _modified_inorder_traversal(self, new_root, target):
        found_it = False
        if new_root.left is not None:
            found_it = self._modified_inorder_traversal(new_root.left, target)
            if found_it:
                return True

        if new_root == target:
            return True

        if new_root.right is not None:
            found_it = self._modified_inorder_traversal(new_root.right, target)
            if found_it:
                return True

        return False


def main():
    t = Tree()
    t.add(10)
    t.add(2)
    t.add(11)
    t.add(12)
    t.add(13)

    #t.traverse()
    t.breath_first_search()
    #print t.is_balanced()
    #print t.is_path(10, 2)

if __name__ == '__main__':
    main()