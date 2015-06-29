# given a positive integer, print the next smallest and the next largest number
# that have the same number of 1 bits in their binary representation


def next_equal_bit_integers(num):
    if num != 1:
        bits = find_prev_next_bit(num)  # [0] = prev [1] = next

        prev_dis = num - bits[0]
        next_dis = bits[1] - num

        if prev_dis < next_dis:
            print bits[0], num
        else:
            print num, bits[1]

    else:
        print "1, 2"



def count_on_bits(num):
    bit_string = bin(num)[2:]
    return bit_string.count('1')


def find_prev_next_bit(num):
    prev = num - 1
    next = num + 1

    while count_on_bits(num) != count_on_bits(prev):
        prev -= 1

    while count_on_bits(num) != count_on_bits(next):
        next += 1

    return prev, next


def main():
    next_equal_bit_integers(18)


if __name__ in "__main__":
    main()
