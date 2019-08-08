package edu.imsa.andyt.smogsafe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.imsa.andyt.smogsafe.R
import edu.imsa.andyt.smogsafe.models.LocationWrapper

class LocationRecyclerViewAdapter(private val onClick: (Int) -> Unit) :
    ListAdapter<LocationWrapper, LocationViewHolder>(LocationDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_aqi, parent, false);
        return LocationViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.note = getItem(position)
    }

}

class LocationViewHolder(itemView: View, private val onClick: (Int) -> Unit): RecyclerView.ViewHolder(itemView) {
    var note: LocationWrapper? = null
        set(value) {
            field = value
            itemView.findViewById<TextView>(R.id.viewHolderTitle).text = note?.data?.city?.name
            itemView.findViewById<TextView>(R.id.aqi).text = note?.data?.aqi.toString()
            itemView.findViewById<TextView>(R.id.latitudeStore).text = note?.data?.city?.geo?.get(0).toString()
            itemView.findViewById<TextView>(R.id.longitudeStore).text = note?.data?.city?.geo?.get(1).toString()
            itemView.findViewById<TextView>(R.id.timestamp).text = "${note?.data?.time?.s} UTC${note?.data?.time?.tz}";
        }

    init {
        itemView.setOnClickListener { onClick(adapterPosition) }
    }
}

class LocationDiffCallback : DiffUtil.ItemCallback<LocationWrapper>() {

    override fun areItemsTheSame(oldItem: LocationWrapper, newItem: LocationWrapper): Boolean {
        return oldItem.data.city.name == newItem.data.city.name
    }

    override fun areContentsTheSame(oldItem: LocationWrapper, newItem: LocationWrapper): Boolean {
        return oldItem == newItem
    }
}