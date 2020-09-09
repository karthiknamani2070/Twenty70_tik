package com.videoplaylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Discover_People_Adapter(private val discover_list: List<Discover_List>, private val context: Context) : RecyclerView.Adapter<Discover_People_Adapter.MyViewHolder>() {

    //    public void filterList(List<Venues_list> filterdNames) {
    //        this.eventList1 = filterdNames;
    //        notifyDataSetChanged();
    //    }
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var discover_title_name: TextView

        var button_change: LinearLayout


        init {
            discover_title_name = view.findViewById<View>(R.id.discover_title_name) as TextView
            button_change =view. findViewById(R.id.btn_background) as LinearLayout;
            var button_background : Int = 1;

            button_change.setOnClickListener {
                if(button_background==2){
                    button_change.setBackgroundResource(R.drawable.bottom_navigation_background_normal);
                    button_background=1;
                } else if(button_background==1){
                    button_change.setBackgroundResource(R.drawable.bottom_navigation_background);
                    button_background=2;
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.discover_people_listitems_main, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val videos_user = discover_list[position]
        holder.discover_title_name.text = videos_user.discover_title_name



    }

    override fun getItemCount(): Int {
        return discover_list.size
    }
}