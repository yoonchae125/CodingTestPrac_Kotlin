package searching_algorithm

class BinarySearch {
    fun search(list: List<Int>, s: Int): Int {
        var low = 0
        var mid = 0
        var high = list.size - 1
        while (low <= high) {
            mid = (low + high) / 2
            when {
                s == list[mid] -> {
                    return mid
                }
                s < list[mid] -> {
                    high = mid - 1
                }
                else -> {
                    low = mid + 1
                }
            }
        }
        return -1
    }
}