package com.example.naturemagnet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.naturemagnet.R
import com.example.naturemagnet.event_activity
import com.example.naturemagnet.viewModel.EventViewModel

class eventAdapter(private val activity: List<event_activity>) : RecyclerView.Adapter<eventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_event_activity, parent, false)
        return EventViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val currentActivity = activity[position]
        holder.backgroundSneakPeek.setImageResource(currentActivity.backgroundSneakPeek)
        holder.iconImage.setImageResource(currentActivity.iconImage)
        holder.cardTitle.text = currentActivity.cardTitle
        holder.cardParticipants.text = currentActivity.cardParticipants
    }

    override fun getItemCount() = activity.size

    // Holds the views for adding it to image and text
    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backgroundSneakPeek: ImageView = itemView.findViewById(R.id.card_background_activity)
        val iconImage: ImageView = itemView.findViewById(R.id.card_icon_activity)
        val cardTitle: TextView = itemView.findViewById(R.id.card_desc_title)
        val cardParticipants: TextView = itemView.findViewById(R.id.card_desc_participants)
    }
}