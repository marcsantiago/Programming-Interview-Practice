from BaseTreeImplementation import Node
# Implement a function to check if a binary tree is a binary search tree

temp = []


def is_binary_search_tree(root):
    in_order(root)
    for i in xrange(len(temp)):
        if i + 1 < len(temp):
            if temp[i] > temp[i + 1]:
                return False
    return True


def in_order(root):
    if root.left is not None:
        in_order(root.left)

    temp.append(root.data)

    if root.right is not None:
        in_order(root.right)


def main():
    root = Node(10)
    root.left = Node(9)
    root.right = Node(5)

    print is_binary_search_tree(root)
    print

if __name__ == '__main__':
    main()