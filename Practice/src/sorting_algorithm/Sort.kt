package sorting_algorithm

import java.util.*


class Sort {
    fun selectionSort(list: IntArray) {
        for (i in list.indices) {
            var minIdx = i
            for (j in i + 1..list.lastIndex) {
                if (list[minIdx] > list[j]) {
                    minIdx = j
                }
            }
            var temp = list[i]
            list[i] = list[minIdx]
            list[minIdx] = temp
        }
    }

    fun insertionSort(list: IntArray) {
        for (i in 1..list.lastIndex) {
            var temp = list[i]
            var aux = i - 1
            while (aux >= 0 && list[aux] > temp) {
                list[aux + 1] = list[aux]
                aux--
            }
            list[aux + 1] = temp
        }
    }

    fun bubbleSort(list: IntArray) {
        for (i in list.indices) {
            for (j in 0 until list.lastIndex-i) {
                if (list[j] > list[j + 1]) {
                    val temp = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = temp
                }
            }
        }
    }

    fun merge(list: IntArray, left: Int, mid: Int, right: Int) {
        var i = left
        var j = mid + 1
        var k = left
        val sorted = IntArray(list.size)
        while (i <= mid && j <= right) {
            if (list[i] < list[j]) {
                sorted[k++] = list[i++]
            } else {
                sorted[k++] = list[j++]
            }
        }
        while (i <= mid) {
            sorted[k++] = list[i++]
        }
        while (j <= right) {
            sorted[k++] = list[j++]
        }
        for (i in left..right) {
            list[i] = sorted[i]
        }
    }

    fun mergeSortTopDown(list: IntArray, left: Int, right: Int) {
        var mid: Int
        if (left < right) {
            mid = (left + right) / 2
            mergeSortTopDown(list, left, mid)
            mergeSortTopDown(list, mid + 1, right)
            merge(list, left, mid, right)
        }
    }


    fun partition(list: IntArray, left: Int, right: Int): Int {
        val pivot = list[left]
        var i = left
        var j = right
        while (i < j) {
            while (list[i] < pivot && i < j)
                i++
            while (list[j] > pivot && i < j)
                j--
            if (i < j) {
                val temp = list[i]
                list[i] = list[j]
                list[j] = temp
            }
        }
        return i
    }
    fun quickSort(list: IntArray, left: Int, right: Int) {
        if (left < right) {
            val pivotNewIndex = partition(list, left, right);
            quickSort(list, left, pivotNewIndex - 1);
            quickSort(list, pivotNewIndex + 1, right);
        }

    }
}

fun main(args: Array<String>) {
    var list = intArrayOf(9, 6, 7, 8, 5)
    val sort = Sort()

    sort.selectionSort(list)
    print("Selection Sort: ")
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.insertionSort(list)
    print("Insertion Sort: ")
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.bubbleSort(list)
    print("Bubble Sort: ")
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.mergeSortTopDown(list, 0, list.lastIndex)
    print("Merge Sort: ")
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.quickSort(list, 0, list.lastIndex)
    print("Quick Sort: ")
    printList(list)

}

fun printList(list: IntArray) {
    list.forEach {
        print("$it ")
    }
    println()
}