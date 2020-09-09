package com.videoplaylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class Video_Screen_Adapter(private val video_lists: List<Video_List>, private val context: Context) : RecyclerView.Adapter<Video_Screen_Adapter.MyViewHolder>() {

    //    public void filterList(List<Venues_list> filterdNames) {
    //        this.eventList1 = filterdNames;
    //        notifyDataSetChanged();
    //    }
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var comments_current_video: TextView
        var like_video: TextView
        var share_btn: TextView
        var profile_current_video: CircleImageView
        var add_current_profile: CircleImageView
        var image_full: ImageView

        init {
            comments_current_video = view.findViewById<View>(R.id.comments_current_video_btn) as TextView
            profile_current_video = view.findViewById<View>(R.id.profilePic) as CircleImageView

            image_full = view.findViewById<View>(R.id.video_image) as ImageView
            like_video = view.findViewById<View>(R.id.like_video) as TextView
            add_current_profile = view.findViewById<View>(R.id.iv_add) as CircleImageView
            share_btn = view.findViewById<View>(R.id.share_btn) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_screen_listitems_main, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val videos_user = video_lists[position]
        holder.comments_current_video.text = videos_user.current_video_comment
        holder.profile_current_video.setImageResource(videos_user.profile_current_video)
        holder.add_current_profile.setImageResource(videos_user.add_profile_current_video)

        holder.image_full.setImageResource(videos_user.image_full)
        holder.like_video.text = videos_user.current_video_likes
        holder.share_btn.text = videos_user.current_video_share

    }

    override fun getItemCount(): Int {
        return video_lists.size
    }
}

