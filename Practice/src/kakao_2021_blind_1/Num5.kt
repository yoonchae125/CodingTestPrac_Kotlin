package kakao_2021_blind_1

class Num5 {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        var answer: String = ""

        val pTimes = play_time.split(":")
        val pTime = Time(pTimes[0].toInt(),pTimes[1].toInt(),pTimes[2].toInt())
        val aTimes = adv_time.split(":")
        val aTime = Time(aTimes[0].toInt(),aTimes[1].toInt(),aTimes[2].toInt())

        if(pTime == aTime) {
            return Time(0, 0, 0).toString()
        }

        var starts = ArrayList<Time>()
        starts.add(Time(0,0,0))

        var clips = arrayOf<Clip>()
        for(log in logs){
            val time = log.split("-")
            val sTime = time[0].split(":")
            val eTime = time[1].split(":")

            val start = Time(sTime[0].toInt(),sTime[1].toInt(),sTime[2].toInt())
            val end = Time(eTime[0].toInt(),eTime[1].toInt(),eTime[2].toInt())

            clips += Clip(start, end)
            starts.add(start)
            println(start)
            if(end.minus(aTime)>Time(0,0,0)){
                starts.add(end.minus(aTime))
            }
        }
        var maxTime = Time(0,0,0)
        var ansTime = Time(0,0,0)
        starts.forEach {
//            println(it)
            val adClip = Clip(it,if(it.plus(aTime)>pTime) pTime;else it.plus(aTime))
            var time = Time(0,0,0)

            clips.forEach { clip->
                time=time.plus(adClip.overlapped(clip))
            }
            println("t:$time")
            if(time>maxTime){
                maxTime = time
                ansTime = it
            }
        }
        println(starts.size)

        return ansTime.toString()
    }
    data class Clip( val start:Time, val end:Time){
        fun overlapped(clip:Clip):Time{
            val s = if(this.start > clip.start) this.start; else clip.start
            val e = if(this.end < clip.end) this.end; else clip.start
            val overlapped = e.minus(s)
            if(overlapped.HH<0){
                return Time(0,0,0)
            }
            return overlapped
        }
    }
    data class Time(val HH: Int, val MM: Int, val SS: Int) {

        fun plus(time: Time): Time {
            var h = this.HH + time.HH
            var m = this.MM + time.MM
            var s = this.SS + time.SS
            if (s >= 60) {
                s -= 60
                m += 1
            }
            if (m >= 60) {
                m -= 60
                h += 1
            }
            return Time(h, m, s)
        }
        fun minus(time:Time):Time{
            var h = this.HH - time.HH
            var m = this.MM - time.MM
            var s = this.SS - time.SS
            if (s < 0) {
                s += 60
                m -= 1
            }
            if (m < 0) {
                m += 60
                h -= 1
            }
            return Time(h, m, s)
        }
        override fun toString(): String {
            return "${if (HH / 10 == 0) "0$HH"; else "$HH"}:${if (MM / 10 == 0) "0$MM"; else "$MM"}:${if (SS / 10 == 0) "0$SS"; else "$SS"}"
        }

        override fun equals(other: Any?): Boolean {
            val time = other as Time
            return this.HH == time.HH && this.MM == time.MM && this.SS == this.SS
        }
//        override fun compare(o1: Time, o2: Time): Int {
//            if(o1.minus(o2).HH<0){
//                return -1
//            }else if(o1 == o2){
//                return 0
//            }else{
//                return 1
//            }
//        }

        operator fun compareTo(t2: Time): Int {
            if(this.minus(t2).HH<0){
                return -1
            }else if(this == t2){
                return 0
            }else{
                return 1
            }
        }
    }
}