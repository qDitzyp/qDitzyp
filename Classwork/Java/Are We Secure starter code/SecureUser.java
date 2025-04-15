public class SecureUser extends User{
    
    private int attempts = 0;

public SecureUser(String username, String password){
super (username, password);
}
@Override public boolean authenticate(String inputPassword) {
    if(attempts >= 3 ){
        return false;
    }else if(super.authenticate(inputPassword) == false){
        attempts += 1;
        return super.authenticate(inputPassword);
    }else{
        attempts = 0;
        return super.authenticate(inputPassword);
    }
}

}
