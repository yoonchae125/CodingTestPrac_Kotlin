package observer_pattern

class MinMaxView(val scoreRecord: ScoreRecord) : Observer {
    override fun update() {
        val record = scoreRecord.getScoreRecord()
        displayScore(record)
    }

    fun displayScore(record: List<Int>) {
        println("Min: ${record.min()}, Max: ${record.max()}")
    }
}