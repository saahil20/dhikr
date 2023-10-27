package com.saahil.dhikr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class CounterListAdapter : ListAdapter<Counter, CounterListAdapter.CounterViewHolder>(CounterComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CounterViewHolder {
        return CounterViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CounterViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }

    class CounterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val counterItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            counterItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): CounterViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return CounterViewHolder(view)
            }
        }
    }

    class CounterComparator : DiffUtil.ItemCallback<Counter>() {
        override fun areItemsTheSame(oldItem: Counter, newItem: Counter): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Counter, newItem: Counter): Boolean {
            return oldItem.id == newItem.id
        }
    }
}