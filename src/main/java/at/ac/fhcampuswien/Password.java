package at.ac.fhcampuswien;

public class Password {

    public static boolean checkPassword(String pw){
        char[] pwArr = pw.toCharArray();
        if(pwArr.length< 7 || pwArr.length > 24){
            return false;
        }
        return true;
    }
}
