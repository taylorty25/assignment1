public class CaesarCipher{
        public static void main(String[] args){
            
            System.out.println("This program encrypts and decrypts messages using the Caesar Cipher.");
            String res1 = args[0];
            String res2 = args[1];
            if (res1.equals("encode")) {
                encode(res2);
            }
            else if (res1.equals("decode")){
                decode(res2);
            }
            else
                System.out.println("You did not enter \"encode\" or \"decode\"");
                
        }

    
        public static void encode(String str){
        int base = (int) 'a';
        base -= 1;
        int end = (int) 'z';
        int strLength = str.length();
            for (int n= 0; n <=25; n++) {
                char[] code = str.toCharArray();
                for (int i = 0; i < strLength; i++) {
                    int temp;
                    temp = (int) str.charAt(i);
                    
                    if (temp + n <=end) {
                        temp = temp + n;
                    }
                    else {
                        temp = ((temp + n ) % end);
                        temp = temp + base;
                    }
                    code[i] = (char) temp;
                }
                System.out.println("n = " + n + ": " + new String(code));
        }
    }

        public static void decode(String str){
        int base = (int) 'a';
        int end = (int) 'z';
        end += 1;
        int strLength = str.length();
            for (int n= 0; n <=25; n++) {
                char[] code = str.toCharArray();
                for (int i = 0; i < strLength; i++) {
                    int temp;
                    temp = (int) str.charAt(i);
                    
                    if (temp - n >= base) {
                        temp = temp - n;
                    }
                    else {
                        temp = (base -(temp - n));
                        temp = end - temp;
                    }
                    code[i] = (char) temp;
                }
                System.out.println("n = " + n + ": " + new String(code));
        }
    }
}
