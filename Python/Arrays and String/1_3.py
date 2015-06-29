# Given two strings, write a method to decide if one is a permutation of the other

#Sort the strings
#Convert string to lowercase
#Remove white spaces
def sortstring(string):
    return sorted(string.lower().replace(" ", ""))


def ispermutation(string1, string2):
    string1 = sortstring(string1)
    string2 = sortstring(string2)

    #If the strings aren't the same length they can't be permutations of each other
    if len(string1) != len(string2):
        return False

    #Iterate to see if there is a difference
    for i in range(len(string1)):
        if string1[i] != string2[i]:
            return False

    return True


def main():
    assert ispermutation("hello", "hello") == True
    assert ispermutation("hello", "world") == False
    assert ispermutation("hello", "hell") == False
    assert ispermutation("I AM LORD VOLDEMORT", "Tom Marvolo Riddle") == True


if __name__ == '__main__':
    main()