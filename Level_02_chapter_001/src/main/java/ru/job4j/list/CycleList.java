package ru.job4j.list;

/**
 * Зацикленный список.
 */
public class CycleList {

    /**
     * Алгоритм, определяющий, что список содержит замыкания.
     * @param first - первый узел списка.
     * @return - Истина - список содержит замыкания, Ложь - не содержит.
     */
    boolean hasCycle(Node first) {
        boolean result = false;
        boolean continueSearch = true;
        if (first != null) {
            Node begin = first;
            Node end = first.next;
            while (continueSearch) {
                if (end == null) {
                    result = false;
                    break;
                }
                while (begin != end) {
                    if (end.next == begin) {
                        result = true;
                        continueSearch = false;
                        break;
                    } else {
                        begin = begin.next;
                    }
                }
                end = end.next;
                begin = first;
            }
        }
        return result;
    }

    class Node<T> {
        public Node(T value) {
            this.value = value;
        }
        T value;
        Node<T> next;
    }
}
