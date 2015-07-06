# Design a musical jukebox using object oriented design


class CD(object):
    def __init__(self, cd_name=None, *songs):
        self.cd_name = cd_name
        self.songs = songs


class CDPlayer(object):
    def __init__(self):
        self.max_number_of_cds = 10
        self.cd_list = []

    def add_cd(self, cd_name, *songs):
        if len(self.cd_list) < 10:
            self.cd_list.append(CD(cd_name, songs))
        else:
            print "CD Player is full, try removing a cd first"

    def remove_cd(self, cd_name):
        for i in xrange(len(self.cd_list)):
            try:
                cd_obj = self.cd_list[i]
                if cd_name == cd_obj.cd_name:
                    del self.cd_list[i]
            except IndexError:
                pass

    def clear_cd_list(self):
        self.cd_list = []

    def get_cd_list(self):
        return self.cd_list


class User(CDPlayer):
    def __init__(self, name, user_id):
        super(User, self).__init__()
        self.name = name
        self.ID = user_id
        self.users = [self.name + self.ID]

    def get_users(self):
        return self.users

    def add_user(self, name, user_id):
        self.users.append(name + user_id)

    def delete_user(self, name, user_id):
        self.users.remove(name + user_id)


class JukeBox(User):
    def __init__(self, name, user_id):
        super(JukeBox, self).__init__(name, user_id)
        self.default_user = User.get_users(self)[0]
        self.save_state = {}

    def change_user(self, name, user_id):
        u = User.get_users(self)
        for i in xrange(len(u)):
            if name + user_id == u[i]:
                self.default_user = u[i]
        CDPlayer.clear_cd_list(self)

    def save_user_music_list(self):
        self.save_state[self.default_user] = CDPlayer.get_cd_list(self)

    def display_user_information(self):
        values = self.save_state[self.default_user]
        print "user: " + self.default_user
        for i in values:
            print "Album:", i.cd_name, ", Song List:", \
                str(i.songs).replace("(", "").replace(")", "").replace("[", "").replace("]", "").rstrip(",")


    # Other things I might add
    # def -> the ability to change cds next and prev

def main():
    jb = JukeBox("John", "123")
    jb.add_cd("Kenny Bloom", ["burn burn burn", "train", "grey hat"])
    jb.add_cd("Betsy Land", ["I love candy", "objects are great", "please inherit me"])
    jb.save_user_music_list()
    jb.display_user_information()

    jb.add_user("Doe", "115")
    jb.change_user("Doe", "115")
    jb.add_cd("Benny Boo", ["falling asleep", "tip toe", "walking to town"])
    jb.add_cd("Mikey Kite", ["ding dong", "flying through walls", "faking it"])
    jb.save_user_music_list()
    jb.display_user_information()
    print


if __name__ in "__main__":
    main()