public class Member {

    final private String name;
    private String address;
    private String phoneNumber;
    final private int memberId;
    private static int addMemberId;

    public Member(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.memberId = ++addMemberId;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "This member has name: " + name +
                ", lives on address: " + address +
                ", with phone number: " + phoneNumber +
                ", and has ID: " + memberId;
    }

}
