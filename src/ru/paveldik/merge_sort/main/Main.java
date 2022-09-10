package ru.paveldik.merge_sort.main;

import ru.paveldik.merge_sort.arguments.Arguments;
import ru.paveldik.merge_sort.integers_sorter.IntegersSorter;
import ru.paveldik.merge_sort.strings_sorter.StringsSorter;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arguments arguments = Arguments.parse(args);

        System.out.println("SortingMode: " + arguments.sortingMode());
        System.out.println("DataType: " + arguments.dataType());
        System.out.println("OutputFileName: " + arguments.outputFileName());
        System.out.println("InputFileNames: " + Arrays.toString(arguments.inputFileNames()));

        if (arguments.dataType() == Arguments.DataType.INTEGER) {
            IntegersSorter sortIntegers = new IntegersSorter(arguments);
            sortIntegers.MergeSortAbstract();
        } else {
            StringsSorter stringsSorter = new StringsSorter(arguments);
            stringsSorter.MergeSortAbstract();
        }
    }
}