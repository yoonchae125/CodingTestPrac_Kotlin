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
            for (j in 0 until list.lastIndex) {
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
                sorted[k] = list[i]
                i++
            } else {
                sorted[k] = list[j]
                j++
            }
            k++
        }
        while (i <= mid) {
            sorted[k] = list[i]
            i++
            k++
        }
        while (j <= right) {
            sorted[k] = list[j]
            j++
            k++
        }
        for (i in left..right) {
            list[i] = sorted[i]
        }
    }

    fun mergeSort(list: IntArray, left: Int, right: Int) {
        var mid: Int
        if (left < right) {
            mid = (left + right) / 2
            mergeSort(list, left, mid)
            mergeSort(list, mid + 1, right)
            merge(list, left, mid, right)
        }
    }

    fun quickSort(list: IntArray, left: Int, right: Int) {
        var pivot :Int
        var i:Int
        var j:Int
        if (left < right) {
            i = left
            j = right
            pivot = list[left]
            while(i<j){
                while (i<=left && list[i] < pivot) i++
                while (i < j && list[j] > pivot) j--

                val temp = list[i]
                list[i] = list[j]
                list[j] = list[i]
            }
            quickSort(list, left, i)
            quickSort(list, i+1, right)
        }
    }
}

fun main(args: Array<String>) {
    var list = intArrayOf(9, 6, 7, 8, 5)
    val sort = Sort()

    sort.selectionSort(list)
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.insertionSort(list)
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.bubbleSort(list)
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.mergeSort(list, 0, list.lastIndex)
    printList(list)

    list = intArrayOf(9, 6, 7, 8, 5)
    sort.quickSort(list, 0, list.lastIndex)
    printList(list)

}

fun printList(list: IntArray) {
    list.forEach {
        print("$it ")
    }
    println()
}