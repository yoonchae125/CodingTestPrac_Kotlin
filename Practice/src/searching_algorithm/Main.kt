package searching_algorithm

fun main(args:Array<String>){
    val list = listOf(5, 11, 13, 19, 22, 38, 42)
    val binarySearch = BinarySearch()
    println("binary search: ${binarySearch.search(list, 19)}")
}