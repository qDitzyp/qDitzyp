import java.util.ArrayList;
import java.util.Scanner;


public class Vsmidterm {
    public static void main(String[] args) throws Exception {
        
        boolean isGood = false;

        boolean hasSymbol = false;

        boolean hasEight = false;

        boolean hasUp = false;

        String password;

        ArrayList<Character> chars = new ArrayList<Character>();

        int passLeng;

        int ups = 0;

        Scanner input = new Scanner(System.in);



        while(isGood == false){

            ups = 0;
            
            hasSymbol = false;

            hasEight = false;

            hasUp = false;
            
            chars.clear();
            
            System.out.print("Enter password: ");

            password = input.next();

            passLeng = password.length();

            for (int i = 0; i < passLeng; i++){



                if(Character.isUpperCase(password.charAt(i))){

                    ups++;

                }


                chars.add(password.charAt(i));

            
            }

            if(chars.contains('!') || chars.contains('?')){

                hasSymbol = true;

            }

            if(passLeng >= 8){

                hasEight = true;

            }

            if(ups >= 2){

                hasUp = true;

            }

            if(hasEight == true && hasSymbol == true && hasUp == true){

                isGood = true;

            }

           System.out.println(ups);

            System.out.println(chars);

            System.out.println (hasEight);

            System.out.println(hasSymbol);

            System.out.println(hasUp);
        }

        input.close();

        System.exit(0);

    }
}
