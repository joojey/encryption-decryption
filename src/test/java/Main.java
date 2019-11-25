public class Main {
    public static String encrypt(String plainText) {
        int shift = 4;
        String cipherText = "";

        if(shift>26) {
            shift = shift%26;
        }
        else if(shift<0) {
            shift = (shift%26)+26;
        }

        int length = plainText.length();
        for(int i=0;i<length;i++) {
            char ch = plainText.charAt(i);
            if(Character.isLetter(ch)) {
                if(Character.isLowerCase(ch)){
                    char c = (char)(ch+shift);
                    if(c>'z'){
                        cipherText += (char)(ch - (26-shift));
                    }
                    else{
                        cipherText += c;
                    }
                }
                else if(Character.isUpperCase(ch)){
                    char c = (char)(ch+shift);
                    if(c>'Z'){
                        cipherText += (char)(ch - (26-shift));
                    }
                    else{
                        cipherText += c;
                    }
                }
            }
            else {
                cipherText += ch;
            }
        }
        return cipherText;
    }

    public static void main(String[] args) {
        String text = "Lets encrypt this text";
        String cipher = encrypt(text);
        System.out.println(cipher);
    }
}