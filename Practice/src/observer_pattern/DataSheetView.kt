package observer_pattern

import java.lang.Integer.min


class DataSheetView(var scoreRecord: ScoreRecord, var viewCount: Int) : Observer {
    override fun update() {
        val record = scoreRecord.getScoreRecord()
        displayScores(record, viewCount)
    }

    fun displayScores(record: List<Int>, viewCount: Int) {
        print("List of $viewCount entries ")

        for (i in 0 until min(viewCount, record.size)) {
            print("${record[i]} ")
        }

        println()
    }
}