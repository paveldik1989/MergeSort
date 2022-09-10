package ru.paveldik.merge_sort.sorters;

import ru.paveldik.merge_sort.arguments.Arguments;

import java.util.Scanner;

public class IntegersSorter extends Sorter<Integer> {
    public IntegersSorter(Arguments arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean hasNext(Scanner scanner) {
        return scanner.hasNextLine();
    }

    @Override
    public Integer takeNext(Scanner scanner, String inputFileName) {
        try {
            String lineToParse = scanner.nextLine();

            if (lineToParse.matches(".*\\s.*")) {
                System.err.println("File " + inputFileName + " contains a line with space symbol.");
                String[] strings = lineToParse.split("\\s");
                return Integer.parseInt(strings[0]);
            }

            return Integer.parseInt(lineToParse);
        } catch (NumberFormatException e) {
            System.err.println("File " + inputFileName + " contains a line with not an integer.");
            return null;
        }
    }
}