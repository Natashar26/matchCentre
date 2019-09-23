package uk.co.natashar26hotmail.matchcentre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(val context: Context, val list:ArrayList<MatchCommentary>):BaseAdapter() {
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val view:View=LayoutInflater.from(context).inflate(R.layout.list_layout,p2,false)
        val id=view.findViewById<TextView>(R.id.mid)
        val feedMatchId=view.findViewById<TextView>(R.id.mfeedMatchId)
        val homeTeamName=view.findViewById<TextView>(R.id.mhomeTeamName)
        val homeTeamId=view.findViewById<TextView>(R.id.mhomeTeamId)
        val homeScore=view.findViewById<TextView>(R.id.mhomeScore)
        val awayTeamName=view.findViewById<TextView>(R.id.mawayTeamName)
        val awayTeamId=view.findViewById<TextView>(R.id.mawayTeamId)
        val awayScore=view.findViewById<TextView>(R.id.mawayScore)
        val competitionId=view.findViewById<TextView>(R.id.mcompetitionId)
        val competition=view.findViewById<TextView>(R.id.mcompetition)
        val type=view.findViewById<TextView>(R.id.mtype)
        val comment=view.findViewById<TextView>(R.id.mcomment)
        val period=view.findViewById<TextView>(R.id.mperiod)

        id.text=list[p0].id.toString()
        feedMatchId.text=list[p0].feedMatchId.toString()
        homeTeamName.text=list[p0].homeTeamName.toString()
        homeTeamId.text=list[p0].homeTeamId.toString()
        homeScore.text=list[p0].homeScore.toString()
        awayTeamName.text=list[p0].awayTeamName.toString()
        awayTeamId.text=list[p0].awayTeamId.toString()
        awayScore.text=list[p0].awayScore.toString()
        competitionId.text=list[p0].competitionId.toString()
        competition.text=list[p0].competition.toString()
        type.text=list[p0].type.toString()
        comment.text=list[p0].comment.toString()
        period.text=list[p0].period.toString()

        return view


    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}