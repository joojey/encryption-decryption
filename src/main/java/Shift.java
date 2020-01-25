public class Shift implements Algorithm {

    private final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encrypt (String data, int key) {
        StringBuilder result = new StringBuilder();

        for (char chars: data.toCharArray()) {
            int indexLowercase = LOWERCASE_ALPHABET.indexOf(chars);
            int indexUppercase = UPPERCASE_ALPHABET.indexOf(chars);

            if (indexLowercase > -1) {
                char replacement = LOWERCASE_ALPHABET.charAt((indexLowercase + key) % LOWERCASE_ALPHABET.length());
                result.append(replacement);
            } else if (indexUppercase > -1) {
                char replacement = UPPERCASE_ALPHABET.charAt((indexUppercase + key) % UPPERCASE_ALPHABET.length());
                result.append(replacement);
            } else {
                result.append(chars);
            }
        }
        return result.toString();
    }

    public String decrypt (String data, int key) {
        StringBuilder result = new StringBuilder();

        for (char chars: data.toCharArray()) {
            int indexLowercase = LOWERCASE_ALPHABET.indexOf(chars);
            int indexUppercase = UPPERCASE_ALPHABET.indexOf(chars);

            if (indexLowercase > -1) {
                int replacementKey = (indexLowercase - key) % LOWERCASE_ALPHABET.length();

                if (replacementKey < 0) {
                    replacementKey = LOWERCASE_ALPHABET.length() + replacementKey;
                } else if (replacementKey > LOWERCASE_ALPHABET.length()) {
                    replacementKey = replacementKey - LOWERCASE_ALPHABET.length();
                }
                char replacement = LOWERCASE_ALPHABET.charAt((replacementKey) % LOWERCASE_ALPHABET.length());
                result.append(replacement);

            } else if (indexUppercase > -1) {
                int replacementKey = (indexUppercase - key) % UPPERCASE_ALPHABET.length();

                if (replacementKey < 0) {
                    replacementKey = UPPERCASE_ALPHABET.length() + replacementKey;
                } else if (replacementKey > UPPERCASE_ALPHABET.length()) {
                    replacementKey = replacementKey - UPPERCASE_ALPHABET.length();
                }
                char replacement = UPPERCASE_ALPHABET.charAt((replacementKey) % UPPERCASE_ALPHABET.length());
                result.append(replacement);

            } else {
                result.append(chars);
            }
        }
        return result.toString();
    }
}