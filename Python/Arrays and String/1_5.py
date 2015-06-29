# Implement a method to perform basic string compression using
#the counts of repeated characters. For example, the string
#aabcccccaaa would be a2b1c5a3. If the compressed string would not
#be smaller than the string, return the string


def stringcompression(string):
    compressedstring = []
    counter = 1
    for i in range(len(string)):
        j = i + 1
        if j < len(string):
            if (string[i] == string[j]):
                counter += 1
            else:
                compressedstring.append(string[i])
                compressedstring.append(str(counter))
                counter = 1
            if len(compressedstring) >= len(string):  #this can be fixed
                return string
    #grab the last chain
    compressedstring.append(string[i])
    compressedstring.append(str(counter))
    return "".join(compressedstring)


stringcompression("aabcccccaaa")  #prints a2b1c5a3