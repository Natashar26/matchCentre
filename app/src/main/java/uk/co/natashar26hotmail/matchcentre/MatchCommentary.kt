package uk.co.natashar26hotmail.matchcentre

data class MatchCommentary(
    val id:Int,
    val feedMatchId: Int,
    val homeTeamName:String,
    val homeTeamId:Int,
    val homeScore:Int,
    val awayTeamName:String,
    val awayTeamId:Int,
    val awayScore:Int,
    val competitionId:Int,
    val competition:String,
    val type:String,
    val comment:String,
    val period:Int
)