public class VigenereCipher {

  public static void main(String[] args) {

    System.out.println("This program encrypts and decrypts messages using the Vigenere Cipher");
    String res1 = args[0];
    String res2 = args[1];
    String res3 = args[2];

    if (res1.equals("encode")) {
      encode(res2, res3);
    } else if (res1.equals("decode")) {
      decode(res2, res3);
    } else {
      System.out.println("You did not enter \"encode\" or \"decode\"");
    }
  }



  public static void charChange(String str, String key, int start, int length, char[] code) {
    int base = (int) 'a';
    int addbase = base - 1;
    int end = (int) 'z';
    String st1 = str;
    String ky1 = key;
    int j;
    for (j = start; j < length; j++) {
      int temp1 = (int) (st1.charAt(j));
      temp1 -= base;
      int temp2 = (int) (ky1.charAt(j % ky1.length()));
      temp2 -= base;
      if (temp1 + temp2 <= end - base) {
        temp1 = temp1 + temp2 + base;
      } else {
        temp1 = (temp1 + temp2) % (end - base);
        temp1 = temp1 + addbase;
      }
      code[j] = (char) temp1;
    }
  }

  public static void deCharChange(String str, String key, int start, int length, char[] code) {
    int base = (int) 'a';
    int end = (int) 'z';
    end++;
    String st1 = str;
    String ky1 = key;
    int j;
    for (j = start; j < length; j++) {
      int temp1 = (int) (st1.charAt(j));
      int temp2 = (int) (ky1.charAt(j % ky1.length()));
      temp2 -= base;
      if (temp1 - temp2 >= base) {
        temp1 = temp1 - temp2;
      } else {
        temp1 = (base - (temp1 - temp2));
        temp1 = end - temp1;
      }
      code[j] = (char) temp1;
    }
  }


  public static void encode(String str, String key) {
    int strLength = str.length();
    int keyLength = key.length();
    if (strLength <= keyLength) {
      char[] code = str.toCharArray();
      charChange(str, key, 0, strLength, code);
      System.out.println(new String(code));
    } else if (strLength % keyLength == 0) {
      char[] code = str.toCharArray();
      int multiples = strLength / keyLength;
      int i = 0;
      while (i < multiples) {
        int count = i * keyLength;
        charChange(str, key, count, (i * keyLength) + keyLength, code);
        ++i;
      }
      System.out.println(new String(code));
    } else {
      char[] code = str.toCharArray();
      int multiples = strLength / keyLength;
      int i = 0;
      while (i < multiples) {
        int count = i * keyLength;
        charChange(str, key, count, (i * keyLength) + keyLength, code);
        ++i;
      }
      charChange(str, key, multiples * keyLength, strLength, code);
      System.out.println(new String(code));
    }
  }

  public static void decode(String str, String key) {
    int strLength = str.length();
    int keyLength = key.length();
    if (strLength <= keyLength) {
      char[] code = str.toCharArray();
      deCharChange(str, key, 0, strLength, code);
      System.out.println(new String(code));
    } else if (strLength % keyLength == 0) {
      char[] code = str.toCharArray();
      int multiples = strLength / keyLength;
      int i = 0;
      while (i < multiples) {
        int count = i * keyLength;
        deCharChange(str, key, count, (i * keyLength) + keyLength, code);
        ++i;
      }
      System.out.println(new String(code));
    } else {
      char[] code = str.toCharArray();
      int multiples = strLength / keyLength;
      int i = 0;
      while (i < multiples) {
        int count = i * keyLength;
        deCharChange(str, key, count, (i * keyLength) + keyLength, code);
        ++i;
      }
      deCharChange(str, key, multiples * keyLength, strLength, code);
      System.out.println(new String(code));
    }
  }
}

