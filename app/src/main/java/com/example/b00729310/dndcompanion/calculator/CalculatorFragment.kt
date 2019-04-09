package com.example.b00729310.dndcompanion.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.b00729310.dndcompanion.R

class CalculatorFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dnd_calculator_popup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val d2Button = getView()?.findViewById<Button>(R.id.d2Button)
    }
}