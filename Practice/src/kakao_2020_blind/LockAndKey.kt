package kakao_2020_blind

class LockAndKey {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        var answer = false
        var rKey = key
        for(i in 0..3){
            println(i+1)
            if(check(rKey, getLockPad(lock) ,lock.size)) return true
            rKey = getRotatedKey(rKey)
        }
        return answer
    }
    fun check(key: Array<IntArray>, lockPad: Array<IntArray>, n:Int):Boolean{
        val result = false
        val offset = lockPad.size - n
        var copyLockPad = copyPad(lockPad)

        for(i in 0..offset){
            for(j in 0..offset){
                for(ki in key.indices){
                    for(kj in key[ki].indices){
                        copyLockPad[i+ki][j+kj] = copyLockPad[i+ki][j+kj] xor key[ki][kj]
                    }
                }
//                printMap(copyLockPad)
//                println()
                if(isUnlocked(copyLockPad, n))
                    return true
                copyLockPad = copyPad(lockPad)
            }
        }
        return result
    }
    fun copyPad(old:Array<IntArray>):Array<IntArray>{
        var new = Array(old.size) {IntArray(old.size)}

        for(i in new.indices){
            for(j in new[i].indices){
                new[i][j] = old[i][j]
            }
        }
        return new
    }
    fun isUnlocked(lockPad: Array<IntArray>, n:Int):Boolean{
        var result = true
        for(i in n-1..2*n-2){
            for(j in n-1..2*n-2){
                if(lockPad[i][j] == 0)
                    return false
            }
        }
        return result
    }

    fun getRotatedKey(key: Array<IntArray>):Array<IntArray> {
        var rotatedKey = Array(key.size) { IntArray(key[0].size) }
        val n = rotatedKey.size
        // 시계 반대 방
        for(i in rotatedKey.indices){
            for(j in rotatedKey[i].indices){
                rotatedKey[i][j] = key[j][n-1-i]
            }
        }
        return rotatedKey
    }
    fun getLockPad(lock: Array<IntArray>):Array<IntArray>{
        val n = lock.size
        var lockPad =  Array(n*3 - 2) {IntArray(n*3 - 2)}
        for(i in lock.indices){
            for(j in lock[i].indices){
                lockPad[i+n-1][j+n-1] = lock[i][j]
            }
        }
        return lockPad
    }
    fun printMap(map:Array<IntArray>){
        map.forEach {
            it.forEach {value->
                print("$value ")
            }
            println()
        }
    }

}