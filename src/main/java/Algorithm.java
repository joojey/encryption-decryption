public interface Algorithm {
    String decrypt(String data, int key);
    String encrypt(String data, int key);
}