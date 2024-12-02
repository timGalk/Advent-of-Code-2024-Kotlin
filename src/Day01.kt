fun main() {
    fun part1(input: List<List<Int>>): Int {
        var left = arrayOf<Int>()
        var right = arrayOf<Int>()

        for (elem in input) {
            left = left.plus(elem[0])
            right = right.plus(elem[1])
        }

        var sum = 0
        for (i in 0 until left.size) {
            sum += Math.abs(left[i] - right[i])
        }
        return sum
    }

    fun part2(input: List<List<Int>>): Int {
        var left = arrayOf<Int>()
        var right = arrayOf<Int>()

        for (elem in input) {
            left = left.plus(elem[0])
            right = right.plus(elem[1])
        }

        val map = mutableMapOf<Int, Int>()
        for (number in right) {
            map[number] = map.getOrDefault(number, 0) + 1
        }

        var sumOfMulti = 0
        for (number in left) {
            if (map.containsKey(number)) {
                sumOfMulti += number * (map[number] ?: 0)
            }
        }
        return sumOfMulti
    }

    // Test cases (using mock data as an example)
    check(part1(listOf(listOf(3, 2), listOf(1, 4))) == 4) // Example test case for part1
    check(part2(listOf(listOf(3, 2), listOf(1, 4))) == 0) // Example test case for part2

    // Read input from file using the Reader class
    val reader = Reader()
    val testInput = reader.readFileToNestedArray("src/Day01_test.txt")
    val input = reader.readFileToNestedArray("src/Day01.txt")


    // Output results
    println(part1(input))
    println(part2(input))
}
