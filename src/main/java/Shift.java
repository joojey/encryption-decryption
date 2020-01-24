public class Shift implements Algorithm{

    private final String lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private final String uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt (String data, int key, String output) {
        StringBuilder result = new StringBuilder();

        for (char chars: data.toCharArray()) {
            int indexLowercase = lowercaseAlphabet.indexOf(chars);
            int indexUppercase = uppercaseAlphabet.indexOf(chars);

            if (indexLowercase > -1) {
                char replacement = lowercaseAlphabet.charAt((indexLowercase + key) % lowercaseAlphabet.length());
                result.append(replacement);
            } else if (indexUppercase > -1) {
                char replacement = uppercaseAlphabet.charAt((indexUppercase + key) % uppercaseAlphabet.length());
                result.append(replacement);
            } else {
                result.append(chars);
            }
        }
        return result.toString();
    }

    public String decrypt (String data, int key, String  output) {
        StringBuilder result = new StringBuilder();

        for (char chars: data.toCharArray()) {
            int indexLowercase = lowercaseAlphabet.indexOf(chars);
            int indexUppercase = uppercaseAlphabet.indexOf(chars);

            if (indexLowercase > -1) {
                int replacementKey = (indexLowercase - key) % lowercaseAlphabet.length();

                if (replacementKey < 0) {
                    replacementKey = lowercaseAlphabet.length() + replacementKey;
                } else if (replacementKey > lowercaseAlphabet.length()) {
                    replacementKey = replacementKey - lowercaseAlphabet.length();
                }
                char replacement = lowercaseAlphabet.charAt((replacementKey) % lowercaseAlphabet.length());
                result.append(replacement);

            } else if (indexUppercase > -1) {
                int replacementKey = (indexUppercase - key) % uppercaseAlphabet.length();

                if (replacementKey < 0) {
                    replacementKey = uppercaseAlphabet.length() + replacementKey;
                } else if (replacementKey > uppercaseAlphabet.length()) {
                    replacementKey = replacementKey - uppercaseAlphabet.length();
                }
                char replacement = uppercaseAlphabet.charAt((replacementKey) % uppercaseAlphabet.length());
                result.append(replacement);

            } else {
                result.append(chars);
            }
        }
        return result.toString();
    }
}