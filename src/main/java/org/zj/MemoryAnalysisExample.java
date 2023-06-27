package org.zj;

import java.util.ArrayList;
import java.util.List;

public class MemoryAnalysisExample {

    // 内存泄漏示例
    private static List<Integer> leakedList = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> {
            simulateMemoryLeak();
        }, "simulateMemoryLeak").start();
        // 内存泄漏示例


        // 内存溢出示例

        new Thread(() -> {
            simulateOutOfMemoryError();
        }, "simulateOutOfMemoryError").start();


    }

    private static void simulateMemoryLeak() {
        for (int i = 0; i < 100000; i++) {
            leakedList.add(i);
        }
    }

    private static void simulateOutOfMemoryError() {
        List<String> stringList = new ArrayList<>();
        while (true) {
            stringList.add("This is a string that will cause OutOfMemoryError");
        }
    }


}



