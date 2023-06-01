package com.example.cube.ui.fragments.noteapp.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cube.App
import com.example.cube.R
import com.example.cube.data.model.NoteModel
import com.example.cube.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.textConfirmNote.setOnClickListener {
            val title = binding.detailEt.text.toString()
            if (title.isNotEmpty()) {
                App.getDataIntense()?.getNoteDao()?.insert(NoteModel(title))
                findNavController().navigateUp()
            }else{
                Toast.makeText(requireContext(), "Введите текст", Toast.LENGTH_SHORT).show()
            }
        }
    }
}