package tests.utilities;

public class Utilities {
    public int getIntFromString(String str){
        String num = "";
        for(int i = 0; i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                num+=""+str.charAt(i);
            }
        }

        return Integer.parseInt(num);
    }
}
