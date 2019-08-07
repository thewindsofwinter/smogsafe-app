package edu.imsa.andyt.smogsafe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.imsa.andyt.smogsafe.R
import edu.imsa.andyt.smogsafe.models.UserLocation

class LocationRecyclerViewAdapter(private val onClick: (Int) -> Unit) : ListAdapter<UserLocation, LocationViewHolder>(LocationDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_aqi, parent, false);
        return LocationViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.note = getItem(position)
    }

}

class LocationViewHolder(itemView: View, private val onClick: (Int) -> Unit): RecyclerView.ViewHolder(itemView) {
    var note: UserLocation? = null
        set(value) {
            field = value
            itemView.findViewById<TextView>(R.id.viewHolderTitle).text = note?.city
            itemView.findViewById<TextView>(R.id.aqi).text = note?.aqi.toString()
            itemView.findViewById<TextView>(R.id.latitudeStore).text = note?.latitude.toString()
            itemView.findViewById<TextView>(R.id.longitudeStore).text = note?.longitude.toString()
            itemView.findViewById<TextView>(R.id.timestamp).text = note?.timeStamp.toString()
        }

    init {
        itemView.setOnClickListener { onClick(adapterPosition) }
    }
}

class LocationDiffCallback : DiffUtil.ItemCallback<UserLocation>() {

    override fun areItemsTheSame(oldItem: UserLocation, newItem: UserLocation): Boolean {
        return oldItem.timeStamp == newItem.timeStamp
    }

    override fun areContentsTheSame(oldItem: UserLocation, newItem: UserLocation): Boolean {
        return oldItem == newItem
    }
}