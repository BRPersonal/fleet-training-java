package com.fleet.training.misc;

/**
 * Class that implements equals() and hashCode() ignoring numeric
 * characters
 */
public class NumberAgnosticToken
{
    private final String token;

    public NumberAgnosticToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberAgnosticToken that)) {
            return false;
        }
        return removeDigits(token).equals(that.removeDigits(that.token));
    }

    @Override
    public int hashCode() {
        return removeDigits(token).hashCode();
    }

    @Override
    public String toString() {
        return token;
    }

    private String removeDigits(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
           if (c >= '0' && c <= '9') {
               continue;
           }
           builder.append(c);
        }
        return builder.toString();
    }
}
