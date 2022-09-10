package ru.paveldik.merge_sort.arguments;

import java.util.Arrays;

public record Arguments(SortingMode sortingMode, DataType dataType, String outputFileName,
                        String[] inputFileNames) {

    public static Arguments parse(String[] args) {
        SortingMode sortingMode = SortingMode.ASCENDING;
        DataType dataType = null;
        String outputFileName;

        if (args.length < 3) {
            throw new IllegalArgumentException(System.lineSeparator() + "Amount of arguments must be >= 3. "
                    + "The amount of arguments is " + args.length);
        }

        boolean hasSortingModeArgument = false;
        int outputFileArgumentIndex = 1;

        switch (args[0]) {
            case "-d" -> {
                sortingMode = SortingMode.DESCENDING;
                outputFileArgumentIndex = 2;
                hasSortingModeArgument = true;
            }
            case "-a" -> {
                hasSortingModeArgument = true;
                outputFileArgumentIndex = 2;
            }
            case "-i" -> dataType = DataType.INTEGER;
            case "-s" -> dataType = DataType.STRING;
            default -> throw new IllegalArgumentException(System.lineSeparator()
                    + "The first argument is expected to be: -d, -a, -s, -i. The first argument entered is " + args[0]);
        }

        if (hasSortingModeArgument) {
            switch (args[1]) {
                case "-i" -> dataType = DataType.INTEGER;
                case "-s" -> dataType = DataType.STRING;
                default -> throw new IllegalArgumentException(System.lineSeparator() +
                        "The second argument is expected to be: -s, -i. Second argument entered is " + args[1]);
            }
        }

        outputFileName = args[outputFileArgumentIndex];
        String[] inputFileNames = Arrays.copyOfRange(args, outputFileArgumentIndex + 1, args.length);

        if (inputFileNames.length == 0) {
            throw new IllegalArgumentException("No input files has been entered.");
        }

        return new Arguments(sortingMode, dataType, outputFileName, inputFileNames);
    }

    public enum SortingMode {ASCENDING, DESCENDING}

    public enum DataType {STRING, INTEGER}
}