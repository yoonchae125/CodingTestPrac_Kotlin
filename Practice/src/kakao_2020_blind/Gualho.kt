package kakao_2020_blind

import java.util.*

class Gualho {
    fun solution(p: String): String {
        var answer = ""
        if (p.isEmpty())
            return p
        answer = change(p)
        return answer
    }

    fun change(str: String): String {
        if(str.isEmpty()) return str
        val splited = split(str)
        if (isRight(splited.first)) {
            return splited.first + change(splited.second)
        } else {

            return "(" + change(splited.second) + ")" + deleteAndChange(splited.first)
        }
    }

    fun deleteAndChange(str: String): String {
        if (str.isEmpty())
            return str
        val s = str.substring(1, str.lastIndex)
        var answer = ""
        s.forEach {
            answer +=
                if (it == '(') ')'
                else '('
        }
        return answer
    }

    fun split(s: String): Pair<String, String> {
        var u = ""
        var v = ""
        val queue: Queue<Char> = LinkedList<Char>()
        queue.add(s[0])
        for ((idx, ch) in s.withIndex()) {
            if (idx == 0) continue
            if (queue.isEmpty()) {
                u = s.substring(0, idx)
                v = s.substring(idx, s.length)
                break
            }
            if (isPair(queue.peek(), ch))
                queue.poll()
            else queue.add(ch)
        }
        if (u == "" && v == "") {
            u = s
        }
        return Pair(u, v)
    }

    fun isPair(a: Char, b: Char): Boolean {
        var result = false
        if (a == '(' && b == ')')
            result = true
        if (a == ')' && b == '(')
            result = true
        return result
    }

    fun isRightPair(a: Char, b: Char): Boolean {
        var result = false
        if (a == '(' && b == ')')
            result = true
        return result
    }

    fun isRight(s: String): Boolean {
        var result = true
        val queue: Queue<Char> = LinkedList<Char>()
        queue.add(s[0])
        for ((idx, ch) in s.withIndex()) {
            if (idx == 0) continue

            if (isRightPair(queue.peek(), ch))
                queue.poll()
            else queue.add(ch)
        }
        if (!queue.isEmpty())
            result = false
        return result
    }
}