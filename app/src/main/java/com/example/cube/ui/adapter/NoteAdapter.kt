package com.example.cube.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cube.R
import com.example.cube.data.inteface.OnClickListener
import com.example.cube.data.model.NoteModel
import com.example.cube.databinding.ItemNoteBinding

class NoteAdapter(
    private var list: List<NoteModel>,
    private val onClickListener: OnClickListener,
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemNoteBinding.bind(item)
        fun onBind(model: NoteModel, listener: OnClickListener) {
            binding.tvTodoTitle.text = model.title
            binding.checkbox.isChecked = model.isChecked
            toggleStrikeThrough(binding.tvTodoTitle, model.isChecked)
            binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(binding.tvTodoTitle, isChecked)
                model.isChecked = !model.isChecked

                binding.delete.setOnClickListener {
                    if (model.isChecked) {
                        listener.onClickListener(model)
                    } else {
                        return@setOnClickListener
                    }
                }
            }
        }

        private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
            if (isChecked) {
                tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                tvTodoTitle.paintFlags =
                    tvTodoTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position], onClickListener)
    }

    override fun getItemCount(): Int = list.size
}