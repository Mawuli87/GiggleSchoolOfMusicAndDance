package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.messieyawo.gigglemusicpiano.activities.HomeActivity
import com.messieyawo.gigglemusicpiano.databinding.FragmentInstagramBinding


class InstagramFragment : Fragment() {
lateinit var binding:FragmentInstagramBinding
lateinit var csActivity:HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentInstagramBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        val url = "https://www.instagram.com/giggleschoolofmusicanddance/"
        binding.webViewTv.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url)
        }

    }

    override fun onStart() {
        super.onStart()
      //  requireActivity().window.setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        (activity as HomeActivity).hideToolbar()
    }




    override fun onResume() {
        super.onResume()
      //  requireActivity().window.setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        (activity as HomeActivity).hideToolbar()
    }

}