//package com.example.b00729310.dndcompanion
//
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//
//class CharacterRecyclerViewAdapter(private val dataset: Array<Character>) :
//        RecyclerView.Adapter<CharacterRecyclerViewAdapter.CharacterViewHolder>() {
//
//    class CharacterViewHolder(v: View) : RecyclerView.ViewHolder(v) {
//        private var view: View = v
//        private var image: ImageView? = null
//        private var characterName: TextView? = null
//    }
//
//    override fun getItemCount(): Int {
//        return dataset.size
//    }
//
//    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CharacterViewHolder {
//        val viewHolder = LayoutInflater.from(p0.context).inflate(R.layout.character_view_holder, p0, false) as ViewGroup
//
//        return CharacterViewHolder(viewHolder)
//    }
//
//    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int, payloads: MutableList<Any>) {
//
//    }
//}