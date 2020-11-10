package programmers_practice.level3


fun main(args: Array<String>) {
//    val routes = arrayOf(intArrayOf(-20,15), intArrayOf(-14,-5), intArrayOf(-18,-13), intArrayOf(-5,-3))
//    val num1 = Camera().solution(routes)
//    println(num1)

//    val num2 = ExpressWithN().solution(5, 12)
//    println(num2)

//    val lines = arrayOf("2016-09-15 01:00:04.002 2.0s",
//    "2016-09-15 01:00:07.000 2s")
//    val num3 = ChuseokTraffic().solution(lines)
//    println(num3)

//    val triangle = arrayOf(intArrayOf(7), intArrayOf(3, 8), intArrayOf(8, 1, 0), intArrayOf(2, 7, 4, 4), intArrayOf(4, 5, 2, 6, 5))
//    val num4 = IntTriangle().solution(triangle)
//    println(num4)

//    val a = intArrayOf(9,-1,-5)
//    val num5 = Balloon().solution(a)
//    println(num5)

//    val operations = arrayOf("I 7","I 5","I -5","D -1")
//    val num6 = PriorityQueue().solution(operations)
//    printList(num6)

//    val times = intArrayOf(7,10)
//    val num7 = Epkuksimsa().solution(6, times)
//    println(num7)

//    val genres = arrayOf("classic", "pop", "classic", "classic", "pop")
//    val plays = intArrayOf(500, 600, 150, 800, 2500)
//    val num8 = BestAlbum().solution(genres, plays)
//    printList(num8)

//    val puddles = arrayOf(intArrayOf(2, 2))
//    val num9 = WayToSchool().solution(4, 3, puddles)
//    println(num9)

//    val tickets = arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND"))
//    val tickets = arrayOf(arrayOf("ICN", "A"), arrayOf("ICN", "B"), arrayOf("B", "ICN"))
//    val tickets = arrayOf(arrayOf("ICN", "A"), arrayOf("A", "C"), arrayOf("A", "D"), arrayOf("D", "B"), arrayOf("B", "A"))
//    val tickets = arrayOf(arrayOf("ICN", "SFO"), arrayOf("ICN", "ATL"), arrayOf("SFO", "ATL"),
//            arrayOf("ATL", "ICN"), arrayOf("ATL","SFO"))
//    val num10 = TravelPath().solution(tickets)
//    printList(num10)

//    val costs = arrayOf(intArrayOf(0,1,1),intArrayOf(0,2,2),intArrayOf(1,2,5),
//            intArrayOf(1,3,1),intArrayOf(2,3,8))
//    val num11 = LinkIsland().solution(4, costs)
//    println(num11)

//    val num12 = BestSet().solution(2,9)
//    printList(num12)

//    val num13 = Hanoi().solution(3)
//    for(array in num13){
//        printList(array)
//    }

//    val teamA = intArrayOf(5,1,3,7)
//    val teamB = intArrayOf(2,2,6,8)
//    val num14 = NumberGame().solution(teamA, teamB)
//    println(num14)

//    val computers = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
//    val num15 = Network().solution(3, computers)
//    println(num15)

//    val cityMap = arrayOf(intArrayOf(0, 2, 0, 0, 0, 2), intArrayOf(0, 0, 2, 0, 1, 0), intArrayOf(1, 0, 0, 2, 2, 0))
//    val num16 = HeavenOfPedestrian().solution(3,6,cityMap)
//    println(num16)

//    val jobs = arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))
//    val num17 = DiskController().solution(jobs)
//    println(num17)

//    val results = arrayOf(intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2),
//            intArrayOf(1, 2), intArrayOf(2, 5))
//    val num18 = Rank().solution(5, results)
//    println(num18)

//    val vertex  = arrayOf(intArrayOf(3, 6), intArrayOf(4, 3), intArrayOf(3, 2),
//            intArrayOf(1, 3), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(5, 2))
//    val num19 = MostFarNode().solution(6, vertex)
//    println(num19)

    val num20 = LongestPalindrome().solution("abcdcba")
    println(num20)
}

fun printList(list: IntArray) {
    list.forEach {
        print("$it ")
    }
    println()
}

fun printList(list: Array<String>) {
    list.forEach {
        print("$it ")
    }
    println()
}

fun printList(list: List<String>) {
    list.forEach {
        print("$it ")
    }
    println()
}