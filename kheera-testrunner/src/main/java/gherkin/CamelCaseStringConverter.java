package gherkin;

import java.util.regex.Pattern;

/**
 * Based on a similar class from cucumber.io
 */
public class CamelCaseStringConverter {

    private static final String WHITESPACE = " ";
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");

    public String map(String string) {
        String[] splitted = normalizeSpace(string).split(WHITESPACE);
        splitted[0] = uncapitalize(splitted[0]);
        for (int i = 1; i < splitted.length; i++) {
            splitted[i] = capitalize(splitted[i]);
        }
        return join(splitted);
    }

    private String join(String[] splitted) {
        StringBuilder sb = new StringBuilder();
        for (String s : splitted) {
            sb.append(s);
        }
        return sb.toString();
    }

    private String normalizeSpace(String originalHeaderName) {
        return WHITESPACE_PATTERN.matcher(originalHeaderName.trim()).replaceAll(WHITESPACE);
    }

    private String capitalize(String string) {
        return new StringBuilder(string.length()).append(Character.toTitleCase(string.charAt(0)))
                .append(string.substring(1)).toString();
    }

    private String uncapitalize(String string) {
        return new StringBuilder(string.length()).append(Character.toLowerCase(string.charAt(0)))
                .append(string.substring(1)).toString();
    }

}
