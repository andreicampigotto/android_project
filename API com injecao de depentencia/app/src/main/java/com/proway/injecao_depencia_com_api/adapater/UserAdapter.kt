package com.proway.injecao_depencia_com_api.adapater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.injecao_depencia_com_api.R
import com.proway.injecao_depencia_com_api.databinding.MainFragmentBinding
import com.proway.injecao_depencia_com_api.model.User

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var users = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.main_fragment, parent, false).apply {
            return UserViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        users[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = users.size

}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: MainFragmentBinding = MainFragmentBinding.bind(itemView)

    fun bind(user: User) {
        binding.textViewName.text = user.login

        user.avatar_url.let {
            Glide.with(itemView.context)
                .load(it)
                .into(binding.imageViewAvater)
        }

    }
}