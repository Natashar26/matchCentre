package uk.co.natashar26hotmail.matchcentre

import android.app.ProgressDialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {


    lateinit var pDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val url="https://feeds.incrowdsports.com/provider/opta/football/v1/matches/987597/commentary"
        AsyncTaskHandler().execute(url)
    }

    inner class AsyncTaskHandler:AsyncTask<String,String,String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            pDialog=ProgressDialog(this@MainActivity)
            pDialog.setMessage("Please Wait")
            pDialog.setCancelable(false)
            pDialog.show()
        }
        override fun doInBackground(vararg url: String?): String {

            val res:String
            val connection= URL(url[0]).openConnection()as HttpURLConnection
            try {
                connection.connect()
                res=connection.inputStream.use { it.reader().use { reader->reader.readText() } }

            }
            finally {
                connection.disconnect()

            }
            return res
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            jsonResult(result)
            if (pDialog.isShowing())
                pDialog.dismiss()
            jsonResult(result)
        }

        private fun jsonResult(jsonString:String?)
        {
            val jsonArray=JSONArray(jsonString)
            

            val list=ArrayList<MatchCommentary>()
            var i = 0
            while (i<jsonArray.length())
            {
               val jsonObject=jsonArray.getJSONObject(i)
                list.add(
                    MatchCommentary(
                    jsonObject.getInt(name:"id"),
                        jsonObject.getInt(name:"feedMatchId"),
                        jsonObject.getString(name:"homeTeamName"),
                        jsonObject.getInt(name:"homeTeamId"),
                        jsonObject.getInt(name:"homeScore"),
                        jsonObject.getString(name:"awayTeamName"),
                        jsonObject.getInt(name:"awayTeamId"),
                        jsonObject.getInt(name:"awayScore"),
                        jsonObject.getInt(name:"competitionId"),
                        jsonObject.getString(name:"competition"),
                        jsonObject.getString(name:"type"),
                        jsonObject.getString(name:"comment"),
                        jsonObject.getInt(name:"period")
                )
                )
                i++
            }
            val adapter=ListAdapter(this@MainActivity,list)
            mylist.adapter=adapter
        }

        }
    }




