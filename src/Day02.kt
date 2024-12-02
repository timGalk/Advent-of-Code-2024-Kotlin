fun main() {
    fun part1(input: List<List<Int>>): Int {
        val task1 = Task1()
        var safeCount = 0
        for (arr in input) {
            if (task1.isStringSafe(arr)) {
                safeCount++
            }
        }
        return safeCount
    }

    fun part2(input: List<List<Int>>): Int {
        val task2 = Task2()
        var safeCount = 0
        for (arr in input) {
            if (task2.isStringSafe(arr)) {
                safeCount++
            }
        }
        return safeCount
    }

    // Test cases (mock data for illustration)
    check(part1(listOf(listOf(3, 2, 1), listOf(1, 4, 7))) == 2) // Example test case for part1
    check(part2(listOf(listOf(3, 5, 1), listOf(1, 4, 7))) == 2) // Example test case for part2

    // Read input from file using the Reader class
    val reader = Reader()
    val testInput = reader.readFileToNestedArray("src/Day01_test.txt")
    val input = reader.readFileToNestedArray("src/Day01.txt")

    // Output results
    println(part1(input))
    println(part2(input))
}