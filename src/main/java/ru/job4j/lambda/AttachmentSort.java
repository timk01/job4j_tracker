package ru.job4j.lambda;

import java.util.*;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> sizeComparator = (left, right) -> {
            return Integer.compare(left.getSize(), right.getSize());
        };
        attachments.sort(sizeComparator);
        System.out.println(attachments);

        System.out.println();
        Comparator<Attachment> namesAscComparator =
                (left, right) -> left.getName().compareTo(right.getName());
        Collections.sort(attachments, namesAscComparator);
        System.out.println(attachments);

        Comparator<Attachment> lengthStringDescComparator =
                (left, right) -> Integer.compare(
                        right.getName().length(), left.getName().length()
                );
    }
}