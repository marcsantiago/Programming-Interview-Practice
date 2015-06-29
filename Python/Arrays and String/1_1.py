# Implement an algorithm to determine if a string has unique characters.
# What if you cannot use additional data structures?

#Short method to check whether string is unique or not
#The problem with this method is that it requires that a another list
#is created doubling the programs space
def isstringunique(string):
    arr = []
    for ch in string:
        if ch not in arr:
            arr.append(ch)
        elif ch == " ":
            arr.append(ch)
    return "".join(arr) == string


#solution that doesn't require that a new list be made
#This solution is 2 steps
#STEP 1 - sort the list
def sort_string(string):
    return sorted(string.lower().replace(" ", ""))  # String must be converted to lowercase


#STEP2  -check adjacent list items
def is_string_unique(string):
    string_length = len(string)
    for i in range(string_length):
        j = i + 1
        if j < string_length:
            if string[i] == string[j]:
                return False
    return True


def main():
    #method 1
    assert isstringunique("abc") == True
    assert isstringunique("abB") == True
    assert isstringunique("cgcb") == False
    assert isstringunique("this is a test") == False

    #method2
    string = "aba"
    string = sort_string(string)
    assert is_string_unique(string) == False


if __name__ == '__main__':
    main()