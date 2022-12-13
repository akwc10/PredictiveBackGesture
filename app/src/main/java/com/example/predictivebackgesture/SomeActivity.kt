package com.example.predictivebackgesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.predictivebackgesture.databinding.ActivityMainBinding
import com.example.predictivebackgesture.databinding.ActivitySomeBinding

class SomeActivity : AppCompatActivity() {

    private var _binding: ActivitySomeBinding? = null
    private val binding: ActivitySomeBinding
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(ActivitySomeBinding.inflate(layoutInflater)) {
            _binding = this
            setContentView(this.root)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}