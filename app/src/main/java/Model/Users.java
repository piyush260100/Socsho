package Model;

public class Users {

    String profilepic,Username,Email,Password,userId,lastmsg;

    public Users(String profilepic, String username, String email, String password, String userId, String lastmsg) {
        this.profilepic = profilepic;
        Username = username;
        Email = email;
        Password = password;
        this.userId = userId;
        this.lastmsg = lastmsg;
    }

    // empty constructor
    public Users(){}

    //signup constructor
    public Users(String username, String email, String password) {
        Username = username;
        Email = email;
        Password = password;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastmsg() {
        return lastmsg;
    }

    public void setLastmsg(String lastmsg) {
        this.lastmsg = lastmsg;
    }
}
