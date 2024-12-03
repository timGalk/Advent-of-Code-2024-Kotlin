import java.io.File

fun main() {

    fun part1 (input: String): Int {

        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

        // Find all matches and calculate the sum of their products
        val result = regex.findAll(input)
            .map { matchResult ->
                val (x, y) = matchResult.destructured
                x.toInt() * y.toInt() // Perform multiplication
            }
            .sum() // Sum up the products

        return result

    }

    fun part2 (input: String): Int {
        val instructionRegex = Regex("""(do\(\)|don't\(\)|mul\((\d+),(\d+)\))""")
        val mulRegex = Regex("""mul\((\d+),(\d+)\)""")
        var isMulEnabled = true // mul instructions are enabled by default
        var result = 0

        // Find and process all valid instructions in the input
        instructionRegex.findAll(input).forEach { matchResult ->
            val instruction = matchResult.value

            when {
                instruction == "do()" -> {
                    isMulEnabled = true // Enable mul instructions
                }
                instruction == "don't()" -> {
                    isMulEnabled = false // Disable mul instructions
                }
                instruction.startsWith("mul") && isMulEnabled -> {
                    val mulMatch = mulRegex.matchEntire(instruction)
                    if (mulMatch != null) {
                        val (x, y) = mulMatch.destructured
                        result += x.toInt() * y.toInt() // Add product to result if mul is enabled
                    }
                }
            }
        }

        return result


    }
    // Part 1
    val pathToFile = "src/main/resources/Day3p1.txt"
    var input = ""
    try {
        input = File(pathToFile).readText()
    } catch (e: Exception) {
        println("Error reading file: $e")
    }

    val resultOfFirstPart = part1(input)
    println("Part 1: $resultOfFirstPart")

    // Part 2
    var input2 = ""
    try {
        input2 = File("src/main/resources/Day3p2.txt").readText()
    } catch (e: Exception) {
        println("Error reading file: $e")
    }
    val resultOfSecondPart = part2(input2)
    println("Part 2: $resultOfSecondPart")




}