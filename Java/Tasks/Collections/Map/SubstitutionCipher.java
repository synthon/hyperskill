import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Character> dictDecode = new HashMap<>();
        Map<Character, Character> dictEncode = new HashMap<>();
        char[] alphabet = sc.nextLine().toCharArray();
        char[] symbols = sc.nextLine().toCharArray();
        char[] encode = sc.nextLine().toCharArray();
        char[] decode = sc.nextLine().toCharArray();

        for (int i = 0; i < alphabet.length; i++) {
            dictEncode.put(alphabet[i], symbols[i]);
            dictDecode.put(symbols[i], alphabet[i]);
        }

        for (int i = 0; i < encode.length; i++) {
            encode[i] = dictEncode.get(encode[i]);
        }

        for (int i = 0; i < decode.length; i++) {
            decode[i] = dictDecode.get(decode[i]);
        }

        System.out.println(encode);
        System.out.println(decode);
    }
}
