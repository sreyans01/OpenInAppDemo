package com.assign.openinapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.assign.openinapp.R
import com.assign.openinapp.databinding.ItemLinksCardBinding
import com.assign.openinapp.model.LinkDetails
import com.assign.openinapp.viewholder.ItemLinkViewHolder
import com.google.gson.Gson
import com.google.gson.JsonObject




class LinksAdapter (context: Context, links: ArrayList<LinkDetails>) :
    RecyclerView.Adapter<ItemLinkViewHolder>() {
    private val context: Context
    private val links: ArrayList<LinkDetails>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLinkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemLinksViewholderBinding: ItemLinksCardBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_links_card, parent, false)
        return ItemLinkViewHolder(itemLinksViewholderBinding)
    }

    override fun getItemCount(): Int {
        return this.links.size
    }

    fun setList(list: ArrayList<LinkDetails>) {
        this.links.clear()
        this.links.addAll(list)
    }

    init {
        this.links = links
        this.context = context
    }

    override fun onBindViewHolder(holder: ItemLinkViewHolder, position: Int) {

        (holder as ItemLinkViewHolder).onBind(context, links[position])
    }
}