from BaseTreeImplementation import Node
# Given a binary tree, design an algorithm which creates a linked list
# of all the nodes at each depth.


def tree_to_linked_list(node):
    if node is not None:
        linked_list = []
        queue = []
        queue.insert(0, node)
        while queue:
            node = queue.pop()
            linked_list.append(node.data)
            if node.left is not None:
                queue.insert(0, node.left)

            if node.right is not None:
                queue.insert(0, node.right)


        return linked_list
    return None


def main():
    t = Node(10)
    t.left = Node(2)
    t.left.left = Node(1)
    t.left.right = Node(3)
    t.right = Node(20)
    t.right.right = Node(40)

    x = tree_to_linked_list(t)
    print x

if __name__ == '__main__':
    main()