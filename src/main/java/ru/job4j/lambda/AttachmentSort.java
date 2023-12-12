package ru.job4j.lambda;

import java.util.*;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator =  new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return Integer.compare(left.getSize(), right.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        System.out.println();
        Comparator<Attachment> namesComparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(attachments, namesComparator);
        System.out.println(attachments);
    }
}