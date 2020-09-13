package kakao_2020_blind

class ColumnAndRow{
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()

        answer = build_frame.copyOf()
        val frames = Array(n){IntArray(n)} // 0 empty, 1 기둥, 2 보, 3 둘다
        build_frame.forEach { build ->
            // ( x, y, a, b)
            // -> a: 0 기둥, 1 보
            // -> b: 0 삭제, 1 설치
            val x = build[0]
            val y = build[1]
            val a = build[2]
            val b = build[3]

            when(b){
                0->{ // 삭제
                    if(a == 0){ // 기둥 삭제

                    }else { // 보 삭제

                    }
                }
                1->{ // 설치
                    if(a == 0){ // 기둥 설치
                        if(x == n-1){ // 바닥에서 시작
                            frames[x][y] += 1
                        }

                        // 좌우에 보있는지
                        if(y-1>=0) {
                            if (frames[x][y - 1] >= 2){
                                frames[x][y] += 1
                            }
                        }
                        if(y+1<n){
                            if (frames[x][y + 1] >= 2){
                                frames[x][y] += 1
                            }
                        }
                        // 위에 기둥있는지
                        if(x-1 >= 0){
                            if (frames[x - 1][y] == 1 || frames[x - 1][y] == 3){
                                frames[x][y] += 1
                            }
                        }
                    }else { // 보 설치
                        // 좌우 모두에 보
                        if(y-1>=0 && y+1<n) {
                            if (frames[x][y - 1] >= 2 && frames[x][y + 1] >= 2){
                                frames[x][y] += 2
                            }
                        }
                        // 좌우에 기둥
                        if(y-1>=0) {
                            if (frames[x][y - 1] == 1 || frames[x][y - 1] == 3){
                                frames[x][y] += 2
                            }
                        }
                        if(y+1<n){
                            if (frames[x][y + 1] == 1 || frames[x][y + 1] == 3){
                                frames[x][y] += 2
                            }
                        }
                    }
                }
            }
        }

        return answer
    }
    fun isBoExist(x:Int, y:Int){

    }
}