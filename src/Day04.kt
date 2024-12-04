import java.io.File

fun main () {
    // Part 1
    part1()
    // Part 2
    part2()

}

// Part 1 Functions

fun  part1 (){
    val path = "src/main/resources/Day04p1.txt"
    var string = listOf<String>()
    try {
        string = File(path).readText().split("\n")
    } catch (e: Exception) {
        println("Error reading or writing file: $e")
    }

    var sortedString = string.filter { it.isNotEmpty() }

    println("${countWordOccurrences(sortedString, "XMAS")}")


}
fun part2 (){

    val path = "src/main/resources/Day04p2.txt"
    var string = listOf<String>()
    try {
        string = File(path).readText().split("\n")
    } catch (e: Exception) {
        println("Error reading or writing file: $e")
    }

    var sortedString = convertToCharMatrix(string.filter { it.isNotEmpty() })

    println("${part2(sortedString)}")
}
fun countWordOccurrences(grid: List<String>, word: String): Int {
    // Check if grid is empty or has rows of unequal lengths
    if (grid.isEmpty() || grid.any { it.length != grid[0].length }) {
        throw IllegalArgumentException("Grid must not be empty, and all rows must have the same length.")
    }

    val rows = grid.size
    val cols = grid[0].length
    val directions = listOf(
        Pair(0, 1),   // Right
        Pair(1, 0),   // Down
        Pair(1, 1),   // Down-Right (Main Diagonal)
        Pair(1, -1),  // Down-Left (Anti-Diagonal)
        Pair(0, -1),  // Left (Backwards Horizontal)
        Pair(-1, 0),  // Up (Backwards Vertical)
        Pair(-1, -1), // Up-Left (Backwards Main Diagonal)
        Pair(-1, 1)   // Up-Right (Backwards Anti-Diagonal)
    )

    fun isValid(x: Int, y: Int) = x in 0 until rows && y in 0 until cols

    fun findWord(x: Int, y: Int, dx: Int, dy: Int): Boolean {
        for (i in word.indices) {
            val nx = x + i * dx
            val ny = y + i * dy
            if (!isValid(nx, ny) || grid[nx][ny] != word[i]) return false
        }
        return true
    }

    var count = 0

    for (x in 0 until rows) {
        for (y in 0 until cols) {
            for ((dx, dy) in directions) {
                if (findWord(x, y, dx, dy)) count++
            }
        }
    }

    return count
}


// Part 2 Functions

fun convertToCharMatrix(data: List<String>): List<List<Char>> {
    return data.map { it.toList() }
}


fun part2(data: List<List<Char>>): Int {
    val rows = data.size
    val cols = data[0].size
    var count = 0

    val set = setOf('M', 'S')

    // Find 'A' as the center of the cross, then check the diagonals
    for (r in 1 until rows - 1) {
        for (c in 1 until cols - 1) {
            if (data[r][c] == 'A') {
                if (setOf(data[r - 1][c - 1], data[r + 1][c + 1]) == set &&
                    setOf(data[r - 1][c + 1], data[r + 1][c - 1]) == set) {
                    count++
                }
            }
        }
    }

    return count
}
