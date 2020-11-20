package com.syafii.crudapireqres.controller.listuser

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.syafii.crudapireqres.R
import com.syafii.crudapireqres.model.listuser.DataItem
import kotlinx.android.synthetic.main.item_list_users.view.*

class ListUserAdapter (private var context: Context) : RecyclerView.Adapter<ListUserAdapter.viewHolder>() {

    private lateinit var dataItem: List<DataItem>

    fun setListUserData(dataItem: List<DataItem>){
        this.dataItem = dataItem
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListUserAdapter.viewHolder {
        return viewHolder(LayoutInflater.from(context).inflate(R.layout.item_list_users, parent, false))
    }

    override fun getItemCount(): Int = dataItem.size

    override fun onBindViewHolder(holder: ListUserAdapter.viewHolder, position: Int) {
        val item : DataItem = dataItem[position]
        holder.bindData(item)
    }

    class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        private val img = itemView.img_avatar

        @SuppressLint("SetTextI18n")
        fun bindData(dataItem: DataItem){
            Picasso.get().load(dataItem.avatar).error(R.drawable.ic_default_profile).into(img)
            itemView.tv_fullName.text = "${dataItem.firstName} ${dataItem.lastName}"
            itemView.tv_firstName.text = dataItem.firstName
            itemView.tv_lastName.text = dataItem.lastName
            itemView.tv_email.text = dataItem.email
        }
    }

}