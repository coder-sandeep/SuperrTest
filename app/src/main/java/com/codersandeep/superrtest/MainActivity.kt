package com.codersandeep.superrtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codersandeep.superrtest.models.Card
import com.codersandeep.superrtest.models.Data

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_tool_bar))
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val rvParent = findViewById<RecyclerView>(R.id.rv_parent)


        val parentAdapter = ParentAdapter(giveData(),this)
        rvParent.layoutManager = LinearLayoutManager(this)
        rvParent.adapter = parentAdapter
        parentAdapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun giveData() : ArrayList<Data>{
        val list = ArrayList<Data>()

        val card1 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/ky8kea9ncsenqljc33dt.png","#0D165C",1,"Staying Safe online","https://app.7taps.com/NNPmuDD4FD")
        val card2 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/sls1oxk4vrjeuxnmeijl.png","#088294",2,"Boosting school performance","")
        val card3 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/wljthik71fu3bwel1wlj.png","#56A332",3,"Master what Matters","")

        val card4 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/aveduqd7zcnsl8dyk6p7.png","#9A6600",4,"Morning starter","")
        val card5 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/zqbtbuxkwa3uygxdlwfl.png","#594545",5,"After school essential","")
        val card6 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/bqmiv6a0cejtlgi83ile.png","#4F185C",6,"Excel progress","")

        val card7 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/vyitb14syjwkoip9bepe.png","#0D165C",7,"Relationships","")
        val card8 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/pvlpxzt5cf96fka9cog4.png","#004B97",8,"Pet care","")
        val card9 = Card("https://res.cloudinary.com/dprfbnqlh/image/upload/v1697648578/hyzm5xkhkfok7azyhr92.png","#088294",9,"House security","")

        val cardList1 = arrayListOf(card1,card2,card3)
        val cardList2 = arrayListOf(card4,card5,card6)
        val cardList3 = arrayListOf(card7,card8,card9)

        list.add(Data(cardList1,"Learn things that will help you get better at the things that matter","Evolve",1))
        list.add(Data(cardList2,"From miracle mornings to bedtime routines, make your day easy, peasy, breazy!","Essentials",2))
        list.add(Data(cardList3,"How to make parent happy? Read on!","Household",3))

        return list
    }
}