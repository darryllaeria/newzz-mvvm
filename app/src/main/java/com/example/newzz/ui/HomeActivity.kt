package com.example.newzz.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.Messenger
import androidx.navigation.findNavController
import com.example.newzz.R
import com.example.newzz.base.base_component.BaseActivity

class HomeActivity: BaseActivity() {

    // MARK: - Inner Class
    @SuppressLint("HandlerLeak")
    inner class ClientHandler: Handler() {
        override fun handleMessage(msg: Message?) {}
    }

    // MARK: - Override Variable
    override var layoutId = R.layout.activity_home

    // MARK: - Private Constants

    // MARK: - Private Variables
    private var clientMessenger: Messenger = Messenger(ClientHandler())
    private var serverMessenger: Messenger? = null

    // MARK: - Override Functions
    override fun initView() {
        super.initView()
    }

    override fun initLogic() {
        super.initLogic()
    }

    override fun onBackPressed() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStop() {
        super.onStop()
    }
}