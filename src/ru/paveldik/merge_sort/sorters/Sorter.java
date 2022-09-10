package ru.paveldik.merge_sort.sorters;

import ru.paveldik.merge_sort.arguments.Arguments;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Sorter<T extends Comparable<T>> {
    public Arguments arguments;

    public abstract boolean hasNext(Scanner scanner);

    public abstract T takeNext(Scanner scanner, String inputFileName);

    public void MergeSortAbstract() {
        int inputFilesAmount = arguments.inputFileNames().length;
        ArrayList<T> currentElements = new ArrayList<>(inputFilesAmount);
        ArrayList<T> previousElements = new ArrayList<>(inputFilesAmount);

        Scanner[] scanners = new Scanner[inputFilesAmount];
        PrintWriter writer = null;

        for (int i = 0; i < inputFilesAmount; i++) {
            previousElements.add(i, null);
        }

        try {
            for (int i = 0; i < inputFilesAmount; i++) {
                scanners[i] = new Scanner(new FileInputStream(arguments.inputFileNames()[i]));
            }

            writer = new PrintWriter(arguments.outputFileName());

            for (int i = 0; i < inputFilesAmount; i++) {
                if (hasNext(scanners[i])) {
                    currentElements.add(i, takeNext(scanners[i], arguments.inputFileNames()[i]));
                } else {
                    currentElements.add(i, null);
                }
            }

            while (hasNotNullElement(currentElements)) {
                int elementToAddIndex = getElementIndexToAdd(currentElements, arguments.sortingMode());
                writer.println(currentElements.get(elementToAddIndex));

                if (hasNext(scanners[elementToAddIndex])) {
                    previousElements.set(elementToAddIndex, currentElements.get(elementToAddIndex));
                    currentElements.set(elementToAddIndex, takeNext(scanners[elementToAddIndex],
                            arguments.inputFileNames()[elementToAddIndex]));
                } else {
                    previousElements.set(elementToAddIndex, currentElements.get(elementToAddIndex));
                    currentElements.set(elementToAddIndex, null);
                }

                if (currentElements.get(elementToAddIndex) != null
                        && !isSortedInputFile(currentElements.get(elementToAddIndex),
                        previousElements.get(elementToAddIndex), arguments.sortingMode())) {
                    System.err.println("Sorting order in file " + arguments.inputFileNames()[elementToAddIndex]
                            + " has an error.");
                    currentElements.set(elementToAddIndex, null);
                }
            }

            writer.flush();
            System.out.println("Merge sort has been successfully completed.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
            for (Scanner scanner : scanners) {
                if (scanner != null) {
                    scanner.close();
                }
            }
        }
    }

    private boolean hasNotNullElement(ArrayList<T> elements) {
        for (T e : elements) {
            if (e != null) {
                return true;
            }
        }
        return false;
    }

    private int getElementIndexToAdd(ArrayList<T> elements, Arguments.SortingMode sortingMode) {
        int index = -1;

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) != null) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < elements.size(); i++) {
            if (sortingMode == Arguments.SortingMode.DESCENDING) {
                if (elements.get(i) != null && (elements.get(i).compareTo(elements.get(index)) > 0)) {
                    index = i;
                }
            } else {
                if (elements.get(i) != null && (elements.get(i).compareTo(elements.get(index)) < 0)) {
                    index = i;
                }
            }
        }

        return index;
    }

    private boolean isSortedInputFile(T currentElement, T previousElement, Arguments.SortingMode sortingMode) {
        if (sortingMode == Arguments.SortingMode.DESCENDING) {
            return currentElement != null && (currentElement.compareTo(previousElement) <= 0);

        } else {
            return currentElement != null && (currentElement.compareTo(previousElement) >= 0);
        }
    }
}