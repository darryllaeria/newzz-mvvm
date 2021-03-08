package com.example.newzz.base.base_component

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.newzz.base.Constants
import com.example.newzz.base.R
import com.example.newzz.base.extension.applyLocale
import com.tapadoo.alerter.Alerter

abstract class BaseFragment : Fragment() {

    abstract var layoutId: Int

    // MARK: - Override Functions
    override fun onAttach(context: Context) {
        super.onAttach(context.applyLocale()!!)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initOneTimeLogic()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onPause() {
        cleanupSubscriptions()
        unsubscribeObservers()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        initView()
        initEvent()
        initLogic()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
    }

    // MARK: - Public Functions
    /**
     * @method to hide the app loading
     */
    fun hideLoading() {}

    fun navigateBack() {
        findNavController().popBackStack()
    }

    fun navigateTo(destination: Int, animation: FragmentNavigator.Extras) {
        findNavController().navigate(destination, null, null, animation)
    }

    fun navigateTo(destination: Int, args: Bundle = Bundle()) {
        findNavController()
            .navigate(destination, args, buildNavigateOption())
    }

    fun navigateTo(uri: Uri) {
        findNavController()
            .navigate(uri, buildNavigateOption())
    }

    fun showInfo(message: String) {
        Alerter.create(requireActivity())
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(Constants.DELAY_TIME)
            .show()
    }

    fun showError(message: String) {
        Alerter.create(requireActivity())
            .setText(message)
            .enableSwipeToDismiss()
            .setDuration(Constants.DELAY_TIME)
            .setBackgroundColorInt(Color.RED)
            .show()
    }

    /**
     * @method to show the app loading
     * @param cancelable should progress dialog cancel with outer touch default=true
     */
    fun showLoading(cancelable: Boolean = true) {
        hideLoading()
    }

    /**
     * @method to toggle show/hide the app's status bar
     */
    fun toggleStatusBar(isShow: Boolean) {
        activity?.window?.decorView?.systemUiVisibility = if (isShow) View.SYSTEM_UI_FLAG_VISIBLE else View.SYSTEM_UI_FLAG_FULLSCREEN
        if (isShow) activity?.actionBar?.show() else activity?.actionBar?.hide()
    }

    // MARK: - Open Functions
    /**
     * @method Handle cleanup when Fragment stop. Example when app needs to hide image picker in ChatFragment
     */
    open fun cleanupOnFragmentStop() {}

    /**
     * @method Cleanup existing subscriptions that the fragment have.
     */
    open fun cleanupSubscriptions() {}

    /**
     * @method Init event for views inside fragment
     */
    open fun initEvent() {}

    /**
     * @method Init logic business for fragment. Example get data from repository
     */
    open fun initLogic() {}

    /**
     * @method Init one-time logic business for fragment.
     */
    open fun initOneTimeLogic() {}

    /**
     * @method Initialize for toolbar
     */
    open fun initToolbar() {}

    /**
     * @method Init all views for fragment
     */
    open fun initView() {
//        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    /**
     * @method Unsubscribe all observers from view model's live data attributes
     */
    open fun unsubscribeObservers() {}

    // MARK: - Private Functions
    private fun buildNavigateOption(): NavOptions {
        return NavOptions.Builder()
            .setPopEnterAnim(R.anim.fragment_fade_enter)
            .setEnterAnim(R.anim.fragment_fade_exit)
            .build()
    }
}