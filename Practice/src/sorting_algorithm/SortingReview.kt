package sorting_algorithm

class Sorting {
    fun selection(list: IntArray) {
        for (i in list.indices) {
            var minIdx = i
            for (j in i + 1..list.lastIndex) {
                if (list[j] < list[minIdx]) {
                    minIdx = j
                }
            }
            val temp = list[i]
            list[i] = list[minIdx]
            list[minIdx] = temp
        }
    }

    fun insert(list: IntArray) {
        for (i in 1..list.lastIndex) {
            var j = 0
            while (j < i && list[i] > list[j]) j++
            val temp = list[i]
            for (k in i downTo j + 1) {
                list[k] = list[k - 1]
            }
            list[j] = temp
        }
    }

    fun bubble(list: IntArray) {
        for (i in list.indices) {
            for (j in 0 until list.lastIndex - i) {
                if (list[j] > list[j + 1]) {
                    val temp = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = temp
                }
            }
        }
    }

    fun merge(list: IntArray, left: Int, mid: Int, right: Int) {
        val tempList = IntArray(list.size)
        var i = left
        var j = mid + 1
        var k = left
        while (i <= mid && j <= right) {
            if (list[i] < list[j]) {
                tempList[k++] = list[i++]
            } else {
                tempList[k++] = list[j++]
            }
        }
        while (i <= mid) {
            tempList[k++] = list[i++]
        }
        while (j <= right) {
            tempList[k++] = list[j++]
        }
        for (idx in left..right) {
            list[idx] = tempList[idx]
        }
    }

    fun mergeSort(list: IntArray, left: Int, right: Int) {
        if (left < right) {
            val mid = (left + right) / 2
            mergeSort(list, left, mid)
            mergeSort(list, mid + 1, right)
            merge(list, left, mid, right)
        }
    }

    fun partition(list: IntArray, left: Int, right: Int): Int {
        val pivot = list[left]
        var i = left
        var j = right

        while (i < j) {
            while (i < j && list[i] < pivot)
                i++
            while (i < j && list[j] > pivot)
                j--
            if (i < j) {
                val temp = list[i]
                list[i] = list[j]
                list[j] = temp
            }
        }

        return i
    }

    fun quick(list: IntArray, left: Int, right: Int) {
        if (left < right) {
            val pivotIdx = partition(list, left, right)
            quick(list, left, pivotIdx - 1)
            quick(list, pivotIdx + 1, right)
        }
    }
}

fun main(args: Array<String>) {
    val sort = Sorting()
    var list: IntArray

    list = intArrayOf(2, 5, 9, 4, 7, 1)
    sort.selection(list)
    printList(list)

    list = intArrayOf(2, 5, 9, 4, 7, 1)
    sort.insert(list)
    printList(list)

    list = intArrayOf(2, 5, 9, 4, 7, 1)
    sort.bubble(list)
    printList(list)

    list = intArrayOf(2, 5, 9, 4, 7, 1)
    sort.mergeSort(list, 0, list.lastIndex)
    printList(list)

    list = intArrayOf(2, 5, 9, 4, 7, 1)
    sort.quick(list, 0, list.lastIndex)
    printList(list)
}