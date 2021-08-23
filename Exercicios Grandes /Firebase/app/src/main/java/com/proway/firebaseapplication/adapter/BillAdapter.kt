package com.proway.firebaseapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import com.proway.firebaseapplication.R
import com.proway.firebaseapplication.model.Bill

class BillAdapter(): RecyclerView.Adapter<BillViewHolder>() {

    private var billsList: MutableList<Bill> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bill, parent,false)
        return BillViewHolder(view)
    }

    override fun onBindViewHolder(holder: BillViewHolder, position: Int) {
        billsList[position].apply {
            holder.bind(this)
            //holder.itemView.setOnClickListener{ onItemClick(this)}
        }
    }

    override fun getItemCount(): Int = billsList.size

    fun refresh(newList: List<Bill>){
        billsList = arrayListOf()
        billsList.addAll(newList)
        notifyDataSetChanged()
    }

}
class BillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(bill: Bill){
        setData(bill.uid, R.id.uidTextView)
        setData(bill.name, R.id.textViewBillName)
        setData(bill.price.toString(), R.id.textViewBillPrice)
    }

    fun setData(value: String?, @IdRes componentId: Int){
        itemView.findViewById<TextView>(componentId).apply {
            text = value
        }
    }
}