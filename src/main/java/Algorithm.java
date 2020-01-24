public interface Algorithm {
    String decrypt(String data, int key, String output);
    String encrypt(String data, int key, String output);
}