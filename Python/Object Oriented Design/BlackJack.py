from random import shuffle


class Deck(object):
    suits = ["Hearts", "Spades", "Clubs", "Diamonds"]
    cards = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Ace", "Jack", "King", "Queen"]
    deck = []

    def __init__(self):
        for i in xrange(0, 52):
            self.deck.append(self.cards[i % 13] + " of " + self.suits[i % 4])
        shuffle(self.deck)


class BlackJack(object):
    my_deck = Deck()
    card_index = 0

    computer_hand = []
    computer_points = 0
    computer_init_card = None
    stay = False

    player_hand = []
    player_points = 0
    player_name = ""

    def __init__(self):
        self._game()

    def _game(self):
        hit = True
        print "Please enter a name below"
        self.player_name = raw_input()
        print "Welcome " + self.player_name
        print "Drawing Cards..."
        self._draw_two()
        print "The computer has drawn two cards, one is face down the other is " + self.computer_init_card
        print self.player_name + " drew two cards as well. " \
                                 "Your cards are " + self.my_deck.deck[2] + " " \
                                 "and " + self.my_deck.deck[3] + " your total points are " + str(self.player_points)

        while hit:
            print "Hit? [y, n]"
            if raw_input() == "y":
                self._player_draw()
                print "Score: " + str(self.player_points)
            else:
                hit = False

            if self.player_points == 21:
                print self.player_name + " Wins"
                print "Computer score: " + str(self.computer_points) + " " + \
                      self.player_name + "'s score: " + str(self.player_points)
                return

            if self.player_points > 21:
                print "Bust!"
                print "Computer score: " + str(self.computer_points) + " " + \
                      self.player_name + "'s score: " + str(self.player_points)
                return

        while not self.stay:
            self._computer_draw()
            if self.computer_points > 21:
                print "Computer Loses!"
                print "Computer score: " + str(self.computer_points) + " " + \
                      self.player_name + "'s score: " + str(self.player_points)
                return

        if self.computer_points > self.player_points:
            print self.player_name + " loses!"
            print "Computer score: " + str(self.computer_points) + " " + \
                  self.player_name + "'s score: " + str(self.player_points)

        elif self.computer_points < self.player_points:
            print self.player_name + " wins!!"
            print "Computer score: " + str(self.computer_points) + " " + \
                  self.player_name + "'s score: " + str(self.player_points)

        elif self.computer_points == self.player_points:
            print "bust"
            print "Computer score: " + str(self.computer_points) + " " + \
                  self.player_name + "'s score: " + str(self.player_points)

    def _draw_two(self):
        self.computer_init_card = self._computer_draw()
        self._computer_draw()
        self._player_draw()
        self._player_draw()

    def _computer_draw(self):

        if 17 <= self.computer_points < 22 or self.computer_points > 21:
            self.stay = True

        if not self.stay:
            card = self.my_deck.deck[self.card_index]

            if card[0] == "J" or card[0] == "K" or card[0] == "Q":
                self.computer_hand.append(10)
            elif card[0] == "A":
                self.computer_hand.append(11)
            elif card.startswith("10"):
                self.computer_hand.append(10)
            else:
                self.computer_hand.append(int(card[0]))

            self.computer_points = self._sum(self.computer_hand)
            self.card_index += 1
            return card

        return

    def _player_draw(self):
        card = self.my_deck.deck[self.card_index]

        if card[0] == "J" or card[0] == "K" or card[0] == "Q":
            self.player_hand.append(10)
        elif card[0] == "A":
            self.player_hand.append(11)
        elif card.startswith("10"):
            self.player_hand.append(10)
        else:
            self.player_hand.append(int(card[0]))

        self.player_points = self._sum(self.player_hand)
        self.card_index += 1
        print "Player drew the " + card
        return card

    def _sum(self, hand):
        count = 0
        have_ace = False
        for i in xrange(len(hand)):
            if hand[i] == 11:
                have_ace = True
            count += hand[i]

        if have_ace and count > 21:
            count -= 10

        return count


def main():
    bj = BlackJack()


if __name__ in "__main__":
    main()