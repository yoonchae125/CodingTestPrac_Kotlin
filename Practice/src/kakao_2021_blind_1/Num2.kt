package kakao_2021_blind_1

class Num2 {
    lateinit var courses: Array<MutableMap<String, Int>>
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        courses = Array(course[course.lastIndex] + 1) { mutableMapOf<String, Int>() }
//        orders.forEach {str->
//            val chars = str.toList().sorted()
//            str = chars.toString()
//        }
        for((idx, str) in orders.withIndex()){
            val chars = str.toList().sortedBy { it }
//            println(chars)
            val new = StringBuffer()
            chars.forEach {
                new.append(it)
            }
            orders[idx] = new.toString()
        }
        orders.forEach { order ->
//            course.forEach { num ->
//                if (order.length < num) {
//                    // do nothing
//                } else {
            val foods = order.toList()
            makeCourse("", 0, 0, course, foods)
            makeCourse(foods[0].toString(), 0, 1, course, foods)
//                }
//            }
        }
//        courses.forEach { c ->
//            c.forEach {
//                println("${it.key}, ${it.value}")
//            }
//        }
        courses.forEach { course ->
            val it = course.iterator()
            while (it.hasNext()) {
                val course = it.next()
                if (course.value < 2) {
                    it.remove()
                }
            }
        }

        var array = arrayOf(mapOf<String, Int>())
        courses.forEach { course ->
            val comparator1 = compareByDescending<Pair<String, Int>> { it.second }
            val c = course.toList().sortedWith(comparator1.thenBy { it.first }).toMap()
//            c.forEach {
//                println("${it.key}, ${it.value}")
//            }
            if (c.size != 0)
                array = array.plus(c)
        }

        array.forEach { course ->
            var m = -1
            course.forEach {
                if (it.value >= m) {
                    m=it.value
                    answer = answer.plus(it.key)
                }
            }
        }
        answer.sort()
        return answer
    }

    fun makeCourse(now: String, idx: Int, count: Int, num: IntArray, foods: List<Char>) {
        if (idx >= foods.lastIndex) {
            if (num.contains(count)) {
                if (courses[count][now] == null) {
                    courses[count][now] = 1
                } else {
                    courses[count][now] = courses[count][now]!! + 1
                }
            }
            return
        }
        makeCourse(now, idx + 1, count, num, foods)
        makeCourse(now + foods[idx + 1], idx + 1, count + 1, num, foods)
    }
}