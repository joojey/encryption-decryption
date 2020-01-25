public class Unicode implements Algorithm {
    String output = "";

    public String decrypt(String data, int key) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item - key);
            output += shiftItem;
        }
        return output;
    }

    public String encrypt(String data, int key) {
        for (char item : data.toCharArray()) {
            char shiftItem = (char) (item + key);
            output += shiftItem;
        }
        return output;
    }
}