#Implement a function void reverse(char* str) in c or c++ which
#reverses a null terminated string
#Done in python to serve as an example of how one would do it in python

def reverse(string):
    return string[::-1]


def reverse2(string):
    string = list(string)
    reversed_string = []
    for i in xrange(len(string), 0, -1):
        reversed_string.append(string[i - 1])
    return "".join(reversed_string)


def main():
    test = "hello"
    test2 = "Hello World"

    assert reverse(test) == "olleh"
    assert reverse(test2) == "dlroW olleH"
    assert reverse2(test) == "olleh"
    assert reverse2(test2) == "dlroW olleH"


if __name__ == '__main__':
    main()







