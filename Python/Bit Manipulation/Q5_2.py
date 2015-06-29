# Given a real number  between 0 and 1 that is passed in as a double, print the
# binary representation accurately in binary with at most 32 characters, else print
# ERROR


def float_to_binary(number):
    if number > 1.0 or number < 0.0:
        print "Error"
        return

    bin_str = []
    while number > 0.0:
        number *= 2
        if number >= 1.0:
            bin_str.append('1')
            number -= 1
        else:
            bin_str.append('0')

        if len(bin_str) > 32:
            print "Error"

    print "".join(bin_str)


def main():
    float_to_binary(.8125)

if __name__ in "__main__":
    main()
