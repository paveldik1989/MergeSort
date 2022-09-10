# Сортировка файлов слиянием

Программа предназначена для сортировки файлов слиянием. Файлы должны состоять из  
столбца целых чисел либо строк, каждая новая строка - новый элемент. Пробельные  
символы не допускаются. Содержимое файлов должны быть предварительно отсортировано в соответствии  
с желаемой сортировкой итогового файла.

## Параметры программы

Пареметры программы задаются при запуске через аргументы командной строки, по порядку:

1. Режим сортировки по возрастанию или убыванию (-a или -d), необязательный, по умолчанию сортирует  
   по возрастанию
2. Тип данных строка либо целое число (-s или -i), обязательный
3. Имя выходного файла, обязательное
4. Остальные параметры – имена входных файлов, не менее одного

## Инструкция по запуску

1. Создать или скопировать файлы для сортировки в папку проекта MergeSort
2. Запустить командную строку
3. Перейти в командной строке в папку проекта MergeSort
4. Запустить исполняемый файл MergeSort.jar.  
   _Можно запускать файлы и не из папки проекта, но в этом случае нужно вводить путь к файлам_

### Примеры запуска из командной строки:

* _java -jar MergeSort.jar -i out.txt in1.txt in2.txt_ - сортировка целых чисел по возрастанию
* _java -jar MergeSort.jar -d -i out.txt in1.txt in2.txt_ - сортировка целых чисел по убыванию
* _java -jar MergeSort.jar -a -s out.txt in1.txt in2.txt_ - сортировка строк по возрастанию
* _java -jar MergeSort.jar -d -s out.txt in1.txt in2.txt_ - сортировка строк по убыванию  
  Примеры приведены для случая, когда пользователь находится в командной строке в папке с исполняемым  
  файлом MergeSort.jar и исходными файлами in1.txt и in2.txt. В результате выполнения программы создается  
  или перезаписывается файл out.txt

### ПО использованное для разработки:

* Java 17.0.2
* IntelliJ IDEA 2021.3.2

### Обработка ошибок

* Если введены неверные, то параметры программа останавливается и выдает сообщение о том,  
  какие параметры были введены неверно
* Если отсутствует файл с исходными данными, то программа останавливается и выдается сообщение о том,  
  какой файл не удалось найти
* Если порядок сортировки содержимого исходного файла не соответствует заданному, то сортировка данного файла  
  прекращается, выдается соответствующее сообщение, а сортировка других файлов продолжается
* Если строка в файле содержит пробельный символ, для сортировки используется первый элемент до пробельного символа,
  сортировка продолжается со следующей строки, а также выдается сообщение об ошибке.
* Если выбран тип сортировки целых чисел, а элемент для сортировки не является числом, то сортировка данного файла  
  прекращается, выдается соответствующее сообщение, а сортировка других файлов продолжается

### Создание исполняемого JAR файла с помощью IntelliJ IDEA

1. Открыть проект MergeSort в IntelliJ IDEA
2. Зайти в меню File
3. Зайти в Project Structure
4. Выбрать Artifacts
5. Нажать на + в меню
6. Выбрать JAR
7. Выбрать From modules with dependencies
8. Выбрать Main файл
9. Нажать Apply, Ok
10. Зайти в меню Build
11. Выбрать Build Artifacts
12. Выбрать Артифакт, нажать Build
13. Исполняемый файл будет находиться в MergeSort\out\artifacts\MergeSort_jar