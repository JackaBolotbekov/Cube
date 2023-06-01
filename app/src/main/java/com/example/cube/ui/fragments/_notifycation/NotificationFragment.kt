package com.example.cube.ui.fragments._notifycation

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import com.example.cube.R
import com.example.cube.databinding.FragmentNotificationBinding
import com.example.cube.ui.fragments._notifycation.brodcast.AlarmReceiver
import com.example.cube.ui.fragments._notifycation.brodcast.setAlarmBroadcast
import java.util.*

class NotificationFragment : Fragment() {

    private lateinit var binding: FragmentNotificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        btnNotify1.setOnClickListener {
            showTimePicker()
        }
    }

    private fun showTimePicker() = with(binding) {
        val calendar = Calendar.getInstance()
        val currentHour = calendar.get(Calendar.HOUR_OF_DAY)
        val currentMinute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            requireContext(),
            { _: TimePicker?, hourOfDay: Int, minute: Int ->
                AlarmReceiver.HOUR_OF_DAY_1 = hourOfDay
                AlarmReceiver.MINUTE_1 = minute
                setAlarmBroadcast(requireContext().applicationContext)
            },
            currentHour,
            currentMinute,
            true
        )
        timePickerDialog.show()
    }
}