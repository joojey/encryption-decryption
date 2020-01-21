public class Shift implements Algorithm {

    char a = 'a';
    char z = 'z';
    char A = 'A';
    char Z = 'Z';
    int size = 26;

    public String encrypt (String data, int key, String output, String out, String alg) {
        char[] chars = data.toCharArray();

        for (char item : chars) {
            if (item >= a && item <= z) {
                char shiftItem = (char) (((item - a + key) % size) + a);
                output += shiftItem;

            } else if (item >= A && item <= Z) {
                char shiftItem = (char) (((item - A + key) % size) + A);
                output += shiftItem;

            } else {
                output += item;
            }
        }
        return output;
    }

    public String decrypt (String data, int key, String  output, String out, String alg) {
        char[] chars = data.toCharArray();

        for (char item : chars) {
            if (item >= a && item <= z) {
                char shiftItem = (char) (((item - a - key) % size) + a);
                output += shiftItem;

            } else if (item >= A && item <= Z) {
                char shiftItem = (char) (((item - A - key) % size) + A);
                output += shiftItem;

            } else {
                output += item;
            }
        }
        return output;
    }
}