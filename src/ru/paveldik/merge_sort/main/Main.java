package ru.paveldik.merge_sort.main;

import ru.paveldik.merge_sort.arguments.Arguments;
import ru.paveldik.merge_sort.sorters.IntegersSorter;
import ru.paveldik.merge_sort.sorters.StringsSorter;

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