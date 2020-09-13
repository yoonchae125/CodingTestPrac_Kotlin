package line_2020

class Num3 {
    var answer = IntArray(2)

    fun solution(n: Int): IntArray {
        if(n/10==0)
            return intArrayOf(0,n)
        val num = n.toString()
        answer[0] = Int.MAX_VALUE
        for(i in 0 until num.lastIndex){
            var a = num.substring(0,i+1)
            val b = num.substring(i+1, num.length)
            if(b[0]=='0'&&b.length!=1) continue
            val n = (a.toInt() + b.toInt()).toString()
            search(n,1)
        }
        return answer
    }
    fun search(num:String, count:Int){
        // idx: + 넣을곳 count: +횟수
        if(num.length == 1) {
            if(count<answer[0]){
                answer[0] = count
                answer[1] = num.toInt()
            }
            return
        }

        for(i in 0 until num.lastIndex){
            var a = num.substring(0,i+1)
            val b = num.substring(i+1, num.length)
            if(b[0]=='0'&&b.length!=1) continue
            val n = (a.toInt() + b.toInt()).toString()
            search(n,count+1)
        }
    }
}