package com.example.myapplication5_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication5_1.databinding.ItemDataBinding

class DataRVAdapter(private val dataList: ArrayList<Data>):RecyclerView.Adapter<DataRVAdapter.DataViewHolder>(){

    //viewholder 객체
    inner class DataViewHolder(private val viewBinding: ItemDataBinding):RecyclerView.ViewHolder(viewBinding.root){
        //호출될때의 함수
        fun bind(data:Data){
            viewBinding.tvTitle.text= data.title
            viewBinding.tvDesc.text=data.desc
        }
    }

    //viewholder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DataViewHolder(viewBinding)
    }

    //viewholder가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    //표현할 item의 총 갯수
    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}