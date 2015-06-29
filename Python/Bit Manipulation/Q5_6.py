def swapbits(a):
    bitarr = list(bin(a)[2:])
    for i in xrange(0, len(bitarr), 2):
        if i < len(bitarr) - 1:
            temp = bitarr[i]
            bitarr[i] = bitarr[i + 1]
            bitarr[i + 1] = temp
    print "".join(bitarr)


def main():
    swapbits(123)

if __name__ in "__main__":
    main()