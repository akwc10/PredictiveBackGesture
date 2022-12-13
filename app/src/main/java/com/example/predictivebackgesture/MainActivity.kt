package com.example.predictivebackgesture

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.predictivebackgesture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = requireNotNull(_binding)

    private val onBackPressedCallback by lazy {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showQuitAppDialog()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        with(ActivityMainBinding.inflate(layoutInflater)) {
            _binding = this
            setContentView(this.root)
        }

        binding.someActivityButton.setOnClickListener {
            startActivity(Intent(this, SomeActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun showQuitAppDialog() {
        AlertDialog.Builder(this)
            .setTitle(R.string.do_you_wish_to_exit_the_app)
            .setCancelable(true)
            .setPositiveButton(R.string.yes) { dialogInterface, _ ->
                run {
                    finish()
                    dialogInterface.dismiss()
                }
            }
            .setNegativeButton(R.string.no) { dialogInterface, _ -> dialogInterface.dismiss() }
            .create()
            .show()
    }
}