public interface Algorithm {
    String decrypt(String data, int key, String output, String out, String alg);
    String encrypt(String data, int key, String output, String out, String alg);
}
