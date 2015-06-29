# write a function to determine the number of bits you would need to flip
# to convert integer A to integer B.
# Example
# input: 29 (or: 11101), 15 (or: 01111)
# output: 2


def bit_difference(num1, num2):
    bstring1 = bin(num1)[2:]
    bstring2 = bin(num2)[2:]
    diff = 0

    len_dif = abs(len(bstring1) - len(bstring2))
    if len(bstring1) > len(bstring2):
        bstring2 = "0" * len_dif + bstring2

    elif len(bstring1) < len(bstring2):
        bstring1 = "0" * len_dif + bstring1

    for i in xrange(len(bstring1)):
        if bstring1[i] != bstring2[i]:
            diff += 1

    return diff


def num_of_swaps_req(a, b):
    count = 0
    c = a ^ b
    while c != 0:
        c &= c - 1
        count += 1

    return count


def main():
    print bit_difference(29, 15)
    print num_of_swaps_req(29, 15)

if __name__ in "__main__":
    main()