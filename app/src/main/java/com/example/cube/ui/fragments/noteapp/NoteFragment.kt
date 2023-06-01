package com.example.cube.ui.fragments.noteapp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cube.App
import com.example.cube.R
import com.example.cube.data.inteface.OnClickListener
import com.example.cube.data.model.NoteModel
import com.example.cube.databinding.FragmentNoteBinding
import com.example.cube.ui.adapter.NoteAdapter

class NoteFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentNoteBinding
    private val list: ArrayList<NoteModel> = ArrayList()
    private val adapter = NoteAdapter(list, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupSubscribes()
    }

    private fun initialize() {
        binding.noteRecView.layoutManager = LinearLayoutManager(requireContext())
        binding.noteRecView.adapter = adapter
    }

    private fun setupListener() = with(binding) {
        backNote.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }
        btnNotify1.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_notificationFragment)
        }
    }

    private fun setupSubscribes() {
        App.getDataIntense()?.getNoteDao()?.getALLModels()?.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
    }

    override fun onClickListener(model: NoteModel) {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setCancelable(false)
        App.getDataIntense()?.getNoteDao()?.delete(model)
    }
}