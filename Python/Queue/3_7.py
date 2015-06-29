# Create a data structure to maintain the Animal Shelter system and implement operations
#such as enqueue, dequeueAny, dequeueCat, deQueueDog. You may use the built-in
#LinkList data structure

class AnimalShelter(object):
    def __init__(self):
        self.dog = []
        self.cat = []
        self.both = []
        self.CATID = 0
        self.DOGID = 0

    def enqueue(self, animal_type):
        if animal_type.upper() == "CAT":
            self.cat.insert(0, "Cat " + str(self.CATID))
            self.both.insert(0, "Cat " + str(self.CATID))
            self.CATID += 1
        elif animal_type.upper() == "DOG":
            self.dog.insert(0, "Dog " + str(self.DOGID))
            self.both.insert(0, "Dog " + str(self.DOGID))
            self.DOGID += 1
        else:
            print "We only accept animals of type dog or cat, please try again"

    def dequeue_cat(self):
        data = self.cat.pop()
        self.both.remove(data)
        return data

    def dequeue_dog(self):
        data = self.dog.pop()
        self.both.remove(data)
        return data

    def dequeue_any(self):
        data = self.both.pop()
        if data.startswith("C"):
            self.cat.remove(data)
        else:
            self.dog.remove(data)
        return data


a = AnimalShelter()

a.enqueue("cat")
a.enqueue("dog")
a.enqueue("cat")
print a.dequeue_cat()
print a.dequeue_any()
print a.dequeue_cat()



