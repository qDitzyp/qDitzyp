public class Main {

    public static void main(String[] args) {
        
        User user1 = new User("Michelle", "12345");
        System.out.println("1. " + user1.isValidPassword()); // false -- less than 8 characters

        User user2 = new User("Michelle", "12345Michelle");
        System.out.println("2. " + user2.isValidPassword()); // false -- contains username

        User user3 = new User("Michelle", "12345678");
        System.out.println("3. " + user3.isValidPassword()); // true

        System.out.println("4. " + user2.authenticate("ABCDE")); // false -- incorrect password
        System.out.println("5. " + user2.authenticate("12345Michelle")); // true 

        System.out.println("6. " + user3.authenticate("12345678")); // true
    
        SecureUser su = new SecureUser("Michelle", "hello123");
        System.out.println("7. " + su.isValidPassword());
        SecureUser su2 = new SecureUser("Michell", "Hello123");

        System.out.println("8." + su.authenticate("hello"));
        System.out.println("9." + su.authenticate("hello12"));
        System.out.println("10." + su.authenticate("hello123"));
        System.out.println("11." + su.authenticate("hello123"));
        System.out.println("12." + su.authenticate("hello"));
        System.out.println("13." + su.authenticate("hello12"));
        System.out.println("14." + su.authenticate("hello123"));
        System.out.println("15." + su.authenticate("hello123"));
        System.out.println("16." + su.authenticate("hello"));
        System.out.println("17." + su.authenticate("hello12"));
        System.out.println("18." + su.authenticate("Hello123"));
        System.out.println("19." + su.authenticate("hello123"));
        System.out.println("20." + su2.authenticate("Hello123"));
        
    }

}
