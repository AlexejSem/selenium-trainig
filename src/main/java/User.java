public class User {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private int state;
    private String postcode;
    private String mobilePhone;

    public User(String email, String firstName, String lastName, String password, String address,
                String city, int state, String postcode, String mobilePhone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getState() {
        return state;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }
}
