package com.videoplaylist

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MainActivity : AppCompatActivity() {

    private val video_list: MutableList<Video_List> = ArrayList()
    private val discover_list: MutableList<Discover_List> = ArrayList()
    var like_btn: TextView? = null
    var linear_layout: LinearLayout? = null
    private var recyclerView_videos: RecyclerView? = null

    private var recyclerView_discover: RecyclerView? = null
    private var videoAdapter: Video_Screen_Adapter? = null
    var button_background : Int = 1;

    private var discoverAdapter: Discover_People_Adapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView_videos = findViewById<View>(R.id.recycler_view) as RecyclerView
        like_btn = findViewById<View>(R.id.video_like_image) as TextView
        linear_layout = findViewById<View>(R.id.layout_like) as LinearLayout

        linear_layout!!.setOnClickListener {
//            like_btn!!.setBackgroundResource(R.drawable.heart_red_32);
            if(button_background==2){
                like_btn!!.setBackgroundResource(R.drawable.heart_32);
                button_background=1;
            } else if(button_background==1){
                like_btn!!.setBackgroundResource(R.drawable.like_pink);
                button_background=2;
            }
        }
        videoAdapter = Video_Screen_Adapter(video_list, this)
        val videos_LayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView_videos!!.layoutManager = videos_LayoutManager
        recyclerView_videos!!.itemAnimator = DefaultItemAnimator()
        recyclerView_videos!!.adapter = videoAdapter

        recyclerView_discover = findViewById<View>(R.id.recycler_view1) as RecyclerView
        discoverAdapter = Discover_People_Adapter(discover_list, this)

        val discover_LayoutManager = LinearLayoutManager(applicationContext)
        discover_LayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        recyclerView_discover!!.layoutManager = discover_LayoutManager
        recyclerView_discover!!.itemAnimator = DefaultItemAnimator()
        recyclerView_discover!!.adapter = discoverAdapter

        preparevideos()
        discoverlist()

    }

    private fun discoverlist() {

        var discover_people = Discover_List("For You")
        discover_list.add(discover_people)
        discover_people = Discover_List("Haha Tv")
        discover_list.add(discover_people)
        discover_people = Discover_List("Beats")
        discover_list.add(discover_people)
        discover_people = Discover_List("Filmistan")
        discover_list.add(discover_people)
        discover_people = Discover_List("Following")
        discover_list.add(discover_people)
        discover_people = Discover_List("Wow")
        discover_list.add(discover_people)
        discover_people = Discover_List("Bhakti")
        discover_list.add(discover_people)
        discover_people = Discover_List("Roposo Stars")
        discover_list.add(discover_people)
        discover_people = Discover_List("Covid-19")
        discover_list.add(discover_people)

    }

    private fun preparevideos() {

        var video1 = Video_List(R.color.red,"23","nice video",R.drawable.plus,"15",R.drawable.img3)
        video_list.add(video1)
        video1 = Video_List(R.color.red,"23","nice video",R.drawable.plus,"15",R.drawable.img1)
        video_list.add(video1)
        video1 = Video_List(R.color.red,"23","nice video",R.drawable.plus,"15",R.drawable.img2)
        video_list.add(video1)
        video1 = Video_List(R.color.red,"23","nice video",R.drawable.plus,"15",R.drawable.img3)
        video_list.add(video1)
        video1 = Video_List(R.color.red,"23","nice video",R.drawable.plus,"15",R.drawable.img4)
        video_list.add(video1)

    }
}