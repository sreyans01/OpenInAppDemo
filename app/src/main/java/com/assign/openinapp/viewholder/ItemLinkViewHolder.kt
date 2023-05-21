package com.assign.openinapp.viewholder

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Build
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.assign.openinapp.R
import com.assign.openinapp.databinding.ItemLinksCardBinding
import com.assign.openinapp.model.LinkDetails
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

class ItemLinkViewHolder(binding: ItemLinksCardBinding) :
    RecyclerView.ViewHolder(binding.root) {
    var binding: ItemLinksCardBinding
    private val context: Context? = null

    fun onBind(context: Context, linkDetails: LinkDetails) {

        Picasso.get().load(linkDetails.imageUrl).into(binding.image)
        binding.linkName.setText(linkDetails.title)
        val createdAtOriginalString = linkDetails.createdAt
        val createdAtDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse(createdAtOriginalString)
        val dateFormated = SimpleDateFormat("dd MMM yyyy").format(createdAtDate)
        binding.date.setText(dateFormated)
        binding.totalClicks.setText(linkDetails.totalClicks.toString())
        binding.link.setText(linkDetails.smartLink)
        binding.buttonCopy.setOnClickListener {
            val clipboardManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText(
                "link",
                linkDetails.smartLink
            )
            clipboardManager.setPrimaryClip(clipData)
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2)
                Toast.makeText(context, context.getString(R.string.link_copied_to_clipboard), Toast.LENGTH_SHORT).show()
        }

    }

    init {
        this.binding = binding as ItemLinksCardBinding
        binding.lifecycleOwner = context as LifecycleOwner?
    }


}

