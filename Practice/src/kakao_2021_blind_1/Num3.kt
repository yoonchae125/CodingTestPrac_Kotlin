package kakao_2021_blind_1

class Num3 {
    fun solution(info: Array<String>, querys: Array<String>): IntArray {
        var answer = IntArray(querys.size)

        val featureMap = mutableMapOf<String, IntArray>()
        var scores = intArrayOf()
        for ((id, infoStr) in info.withIndex()) {
            val features = infoStr.split(" ")
            features.forEach { feature ->
                if (featureMap[feature] == null) {
                    featureMap[feature] = intArrayOf(id + 1)
                } else {
                    featureMap[feature] = featureMap[feature]!!.plus(id + 1)
                }
                if (!feature[0].isLetter())
                    scores += feature.toInt()
            }
        }
        scores.sort()

//        featureMap.forEach{
//            println(it.key)
//            printList(it.value)
//        }
        for ((q, query) in querys.withIndex()) {
            var count = 0
            var list = IntArray(info.size)
            for (i in list.indices) {
                list[i] = i + 1
            }
            val qe = query.replace(" and", "")
            val conditions = qe.split(" ")
            for ((idx, condition) in conditions.withIndex()) {
//                println("aa $condition")
                if (condition == "-")
                    continue
                var list2 = intArrayOf()
                var remains = intArrayOf()

                if (idx == 4) { // check score
                    for (score in scores) {
                        if (score < condition.toInt())
                            continue
                        list2 += featureMap[score.toString()]!!
                    }
                } else {
                    list2 += featureMap[condition]!!
                }
//                printList(list2)
                list.forEach {
                    if (list2.contains(it)) {
                        remains += it
                    }
                }
                if (remains.isEmpty()) {
                    list = remains
                    break
                }
//                print("remains: ")
//                printList(remains)
                list = remains
            }
            answer[q] = list.size
        }

        return answer
    }
}