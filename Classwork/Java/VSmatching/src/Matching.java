public class Matching {
    
    public static boolean nestParen(String n){
        if(n.length() == 0){
            return true;
        }else if(n.charAt(0) == '(' && n.charAt(n.length()-1) == ')'){
            n = n.substring(1, n.length()-1);
            if(n.length() == 0){
                return true;
            }else{
                return nestParen(n);
            }
        }else{
            return false;
        }
    }
}
