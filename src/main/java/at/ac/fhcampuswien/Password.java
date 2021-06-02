package at.ac.fhcampuswien;

public class Password {

    public static boolean checkPassword(String pw) {
        boolean length = checkLength(pw);
        boolean capitals = checkCapitals(pw);
        boolean digits = checkDigits(pw);
        boolean special = checkSpecialCharacters(pw);
        boolean increase = checkIncrease(pw);
        boolean continuous = checkContinuous(pw);
        return length && capitals && digits && special && increase && continuous;
    }

    public static boolean checkLength(String pw){
        //Checks if pw is the right length
        return pw.length() >= 8 && pw.length() <= 25;
    }

    public static boolean checkCapitals(String pw){
        //Checks if pw contains Upper Case and Lower Case digits
        char[] pwArray = pw.toCharArray();
        int up = 0, down = 0;
        for (char c : pwArray) {
            if (Character.isUpperCase(c)) {
                up++;
            } else if (Character.isLowerCase(c)){
                down++;
            }
        }
        return up > 0 && down > 0;
    }

    public static boolean checkDigits(String pw){
        //Checks if pw contains digits
        char[] chars = pw.toCharArray();
        for(char c : chars){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkSpecialCharacters(String pw){
        //Checks if pw contains special characters
        final String VALID_SPECIAL = "[()#$?!%/@]";
        char[] chars = pw.toCharArray();
        for(char c : chars){
            if(Character.toString(c).matches(VALID_SPECIAL)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkIncrease(String pw){
        //Check if pw contains increasing numbers
        char[] chars = pw.toCharArray();
        for (int i = 0; i < pw.length() - 2; i++) {
            if(Character.isDigit(chars[i])) {
                if(chars[i] == chars[i+1] - 1 && chars[i] == chars[i+2] - 2){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkContinuous(String pw){
        //Checks if pw contains continuous numbers
        int cont = 0;
        char[] chars = pw.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])){
                for (int j = i + 1; j < chars.length; j++) {
                    if(Character.isDigit(chars[j])){
                        if(cont < 3){
                            if(Character.getNumericValue(chars[i]) == Character.getNumericValue(chars[j])){
                                cont++;
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
