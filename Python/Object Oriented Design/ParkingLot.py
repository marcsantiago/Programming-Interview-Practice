# Design a parking lot using object oriented design
# The statement never states what kind of parking lot...is it a parking lot with many floors?
# Is a parking lot that you have to pay for (toll)

# This parking lot will have one level with limited spots and have some sort of toll


class ParkingSpaces(object):
    def __init__(self, number_of_spaces):
        self.number_of_spaces = number_of_spaces
        self.spaces_used = 0

    def update_spaces(self):
        self.spaces_used += 1

    def get_max_number_of_spaces(self):
        return self.number_of_spaces

    def get_spaces_used(self):
        return self.spaces_used


class Toll(ParkingSpaces):
    def __init__(self, number_of_spaces):
        super(Toll, self).__init__(number_of_spaces)
        ParkingSpaces(number_of_spaces)
        self.toll_amount = 1.50


    def pay_toll(self):
        if ParkingSpaces.get_spaces_used(self) < ParkingSpaces.get_max_number_of_spaces(self):
            ParkingSpaces.update_spaces(self)
        else:
            print "Parking lot is full"

    def get_toll_amount(self):
        return self.toll_amount


class ParkingLot(Toll):
    def __init__(self, number_of_spaces):
        super(ParkingLot, self).__init__(number_of_spaces)
        self.parking = Toll(number_of_spaces)
        #self.number_of_cars_parked = 0
        self.money_made = 0


    def pay_toll(self):
        Toll.pay_toll(self)
        #self.number_of_cars_parked += 1
        #self.money_made = Toll.get_toll_amount(self) * self.number_of_cars_parked
        self.money_made = Toll.get_toll_amount(self) * ParkingSpaces.get_spaces_used(self)

    def get_number_of_cars_parked(self):
        #return self.number_of_cars_parked
        return ParkingSpaces.get_spaces_used(self)

    def get_money_made(self):
        return str(self.money_made) + "$"


# If I wanted to convert this to a multi level parking lot I would create a new class
# and make it a sub class of ParkingLot
# class MultiLevel(ParkingLot)


def main():
    pl = ParkingLot(10)
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    pl.pay_toll()
    print pl.get_money_made()
    print

if __name__ in "__main__":
    main()






