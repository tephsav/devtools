package ru.mentee.power;

public class ProgressDemo {
    public static void main() {
        MenteeProgress progress = new MenteeProgress("Alexandr", 1, 6);
        System.out.println(progress.summary());
        if (progress.readyForSprint()) {
            System.out.println("Status: sprint ready");
        } else {
            System.out.println("Status: backlog first");
        }
    }
}
