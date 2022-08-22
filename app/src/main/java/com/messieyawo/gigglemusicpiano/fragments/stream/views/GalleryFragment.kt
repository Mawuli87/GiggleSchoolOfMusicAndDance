package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.messieyawo.gigglemusicpiano.databinding.FragmentGalleryBinding
import com.messieyawo.gigglemusicpiano.gallery.PhotoActivity


import com.messieyawo.gigglemusicpiano.videos.VideoListActivity

class GalleryFragment : Fragment() {
lateinit var galleryBinding: FragmentGalleryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        galleryBinding = FragmentGalleryBinding.inflate(layoutInflater,container,false)

        galleryBinding.videoGallery.setOnClickListener {
            val intent = Intent(requireActivity(), VideoListActivity::class.java)
            requireActivity().startActivity(intent)
        }
//        galleryBinding.photoGallery.setOnClickListener{
//            val intent = Intent(requireActivity(), PhotoActivity::class.java)
//            requireActivity().startActivity(intent)
//        }
        return galleryBinding.root
    }


}