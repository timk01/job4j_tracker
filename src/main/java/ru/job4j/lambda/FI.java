package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        Arrays.sort(attachments, comparator);

        Comparator<String> namesAscComparator =
                (left, right) -> left.compareTo(right);

        Comparator<String> namesLengthDescComparator =
                (left, right) -> Integer.compare(
                        right.length(), left.length()
                );
    }

}