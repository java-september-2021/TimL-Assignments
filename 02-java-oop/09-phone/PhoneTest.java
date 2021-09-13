public class PhoneTest {
    public static void main(String[] args) {
        Galaxy note20 = new Galaxy("Note 20", 95, "AT&T", "Canon on D");
        IPhone iPhone12 = new IPhone("IPhone 12", 89, "Sprint", "Waterfall");

        note20.displayInfo();
        System.out.println(note20.unlock());

        iPhone12.displayInfo();
        System.out.println(iPhone12.unlock());
    }
}