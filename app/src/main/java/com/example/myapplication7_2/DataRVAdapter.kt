package com.example.myapplication7_2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication7_2.databinding.ItemDataBinding
import com.bumptech.glide.Glide

class DataRVAdapter(private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdapter.DataViewHolder>() {

    private lateinit var binding: ItemDataBinding

    //viewholder 객체
    inner class DataViewHolder(private val viewBinding: ItemDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        //호출될때의 함수
        fun bind(data: Data) {
            viewBinding.tvSong.text = data.song
            viewBinding.tvSinger.text = data.singer
            Glide.with(binding.iv)
                .load(data.image)
                .into(binding.iv)
        }
    }

    //viewholder 만들어질 때 실행할 동작
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    //viewholder가 실제로 데이터를 표시해야 할 때 호출되는 함수
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    //표현할 item의 총 갯수
    override fun getItemCount(): Int = dataList.size
}