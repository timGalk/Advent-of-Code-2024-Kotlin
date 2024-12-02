
class Task1 {

    fun isStringSafe(arr: List<Int>): Boolean {
        // The levels are either all increasing or all decreasing.
        //Any two adjacent levels differ by at least one and at most three.

        for (i in 0 until arr.size - 1) {
            if (arr[0] > arr[1]) {
                if ((arr[i] - arr[i + 1]) !in 1..3) {
                    return false

                }
            } else {
                if ((arr[i + 1] - arr[i]) !in 1..3) {
                    return false

                }

            }

        }
        return true
    }

}