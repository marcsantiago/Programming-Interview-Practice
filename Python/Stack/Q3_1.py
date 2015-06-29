from BaseImplementation import Stack


def array_to_three_stacks(arr):
    maxl = len(arr)
    # create 3 stacks
    fs = Stack()
    ss = Stack()
    ts = Stack()

    #create 3 arrays
    fa = arr[0: maxl / 3]
    sa = arr[maxl / 3: (2 * maxl) / 3]
    ta = arr[(2 * maxl) / 3: maxl]

    for i in fa:
        fs.push(i)
    for j in sa:
        ss.push(j)
    for k in ta:
        ts.push(k)

    return fs, ss, ts


arr_test = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]

a = array_to_three_stacks(arr_test)
print a[0].peek()
print a[1].peek()
print a[2].peek()