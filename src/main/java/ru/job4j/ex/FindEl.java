package ru.job4j.ex;

import java.util.Objects;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (Objects.equals(value[i], key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("cannot find the key: " + key);
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        boolean isWordGood = true;
        String badWord = null;
        for (String abuse : abuses) {
            if (Objects.equals(abuse, value)) {
                badWord = abuse;
                isWordGood = false;
                break;
            }
        }
        if (!isWordGood) {
            throw new ElementAbuseException("found bad word " + badWord);
        }
        return isWordGood;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        }
    }

    public static void main(String[] args) {
        process(new String[] {"one", "two", "three", "poxyi", "three"}, "poxyi", new String[] {"one, two", "poxyi"});
    }
}
