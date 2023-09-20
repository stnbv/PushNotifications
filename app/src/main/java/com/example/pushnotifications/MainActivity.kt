package com.example.pushnotifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.pushnotifications.databinding.ActivityMainBinding
import com.example.pushnotifications.presentation.auth.LoginFragmentDirections
import com.example.pushnotifications.presentation.flowers_info.dialog.FlowersInfoDialogFragmentArgs
import com.example.pushnotifications.presentation.flowers_info.screen.FlowersInfoFragmentDirections
import com.example.pushnotifications.utils.PARAM_NAME
import org.koin.androidx.viewmodel.ext.android.viewModel

const val USER_PREFERENCES_NAME = "user_preferences"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel.initFirebaseMessaging()
        setContentView(binding.root)
        navFromPush()
    }

    private fun navFromPush() {
        val flowersId = intent.extras?.getString(PARAM_NAME)

        if (intent.extras?.size() != null && !flowersId.isNullOrBlank()) {
            findNavController(R.id.navHostFragment).navigate(
                LoginFragmentDirections.actionLoginFragmentToFlowersInfoFragment(flowersId)
            )
        }
    }
}
