package com.example.myproject2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myproject2.databinding.ListItemUserBinding

class UserAdapter(val context: Context, val UserList:ArrayList<User>): BaseAdapter() {
    private var mBinding: ListItemUserBinding? = null
    private val binding get() = mBinding!!

    override fun getView(position: Int, covertView: View?, parent: ViewGroup?): View {

        mBinding = ListItemUserBinding.inflate(LayoutInflater.from(context))

        val profile = binding.imageIcon
        val name = binding.textId
        val title = binding.textTitle

        val user = UserList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        title.text = user.title

        return mBinding!!.root
    }
    override fun getItem(position: Int): Any {
        return UserList[position]
    }
    override fun getCount(): Int {
        return UserList.size
    }
    override fun getItemId(position: Int): Long {
        return 0
    }
}