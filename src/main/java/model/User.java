package model;

public class User {
    private int UserID;
    private String name;
    private String address;


    public int getUSerId() {
        return UserID;
    }

    public void setUserId(int UserID) {
        this.UserID = UserID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + UserID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User developer = (User) o;

        if (UserID != developer.UserID) return false;
        if (!name.equals(developer.name)) return false;
        return address.equals(developer.address);
    }

    @Override
    public int hashCode() {
        int result = UserID;
        result = 31 * result + name.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}
