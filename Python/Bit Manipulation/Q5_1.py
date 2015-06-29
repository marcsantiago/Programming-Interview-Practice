# you are given two 32 bit integers, N and M, and bit positons j and i.
# write a method to insert m into n such that m starts at j and ends at bit i.
# you can assume that bits j through i have enough space to fit all of M.
# Example
# N = 10000000000
# M = 10011
# i = 2
# j = 6
# output = 10001001100

def insert_bits(num, chunk, start, end):
    # create a mask of all ones
    ones = ~0
    # add zeros to the right and push the ones to the left
    left = ones << (end + 1)
    # pad the right side with ones
    right = (1 << start) - 1
    # combine left and right
    mask = left | right

    # clear the section that chunk will be added to
    num_cleared = num & mask
    #shift chunk over to match the cleared section above
    chunk_shifted = chunk << start
    # combine and return the answer
    return bin(num_cleared | chunk_shifted)


def main():
    print insert_bits(1024, 19, 2, 6)

if __name__ in "__main__":
    main()