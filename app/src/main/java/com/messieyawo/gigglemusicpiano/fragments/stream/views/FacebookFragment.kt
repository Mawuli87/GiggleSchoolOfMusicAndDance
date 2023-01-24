package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.activities.HomeActivity
import com.messieyawo.gigglemusicpiano.databinding.FragmentFacebookBinding


class FacebookFragment : Fragment() {

lateinit var binding:FragmentFacebookBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentFacebookBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        requireActivity().window.setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
     val url = "https://www.facebook.com/loveandliveyourtalent"
        binding.webViewT.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
           loadUrl(url)
        }

    }

    override fun onStart() {
        super.onStart()
        (activity as HomeActivity).hideToolbar()
    }

    override fun onStop() {
        super.onStop()
        (activity as HomeActivity).hideToolbar()
    }


    override fun onResume() {
        super.onResume()
        (activity as HomeActivity).hideToolbar()
    }
}