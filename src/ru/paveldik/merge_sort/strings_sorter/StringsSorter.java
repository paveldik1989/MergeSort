package ru.paveldik.merge_sort.strings_sorter;

import ru.paveldik.merge_sort.arguments.Arguments;
import ru.paveldik.merge_sort.sorter.Sorter;

import java.util.Scanner;

public class StringsSorter extends Sorter<String> {
    public StringsSorter(Arguments arguments) {
        this.arguments = arguments;
    }

    @Override
    public boolean hasNext(Scanner scanner) {
        return scanner.hasNextLine();
    }

    @Override
    public String takeNext(Scanner scanner, String inputFileName) {
        String lineToParse = scanner.nextLine();
        if (lineToParse.matches(".*\\s.*")) {
            System.err.println("File " + inputFileName + " contains a line with space symbol.");
            String[] strings = lineToParse.split("\\s");
            return strings[0];
        }

        return lineToParse;
    }
}