class Task2 {



    fun isStringSafe(arr: List<Int>): Boolean {
        // If the array has less than 2 elements, it's trivially safe
        if (arr.size < 2) return true

        // Check if the array is already safe
        if (isSafe(arr)) return true

        // Try removing each level one by one and check if the sequence becomes safe
        for (i in arr.indices) {
            val modifiedArr = arr.toMutableList().apply { removeAt(i) }
            if (isSafe(modifiedArr)) {
                return true
            }
        }

        // If no valid sequence was found, it's not safe
        return false
    }

    // Helper function to check if the sequence is safe according to the original rules
    private fun isSafe(arr: List<Int>): Boolean {
        // The levels are either all increasing or all decreasing.
        // Any two adjacent levels differ by at least one and at most three.
        for (i in 0 until arr.size - 1) {
            if (arr[0] > arr[1]) {  // Decreasing sequence
                if ((arr[i] - arr[i + 1]) !in 1..3) {
                    return false
                }
            } else {  // Increasing sequence
                if ((arr[i + 1] - arr[i]) !in 1..3) {
                    return false
                }
            }
        }
        return true
    }
}