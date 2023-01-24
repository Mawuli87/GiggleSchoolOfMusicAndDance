package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.databinding.FragmentHomeBinding
import java.util.*


class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater,container, false)

        return homeBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.goCoursesFragment?.setOnClickListener {
         val action = HomeFragmentDirections.actionHomeFragmentToCoursesFragment()
            findNavController().navigate(action)
        }

        homeBinding.chatWithUs?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChatWithUsFragment()
            findNavController().navigate(action)
        }

        homeBinding.packages?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToChatWithUsFragment()
            findNavController().navigate(action)
        }

        homeBinding.calendar?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToCalendarFragment()
            findNavController().navigate(action)
        }

        homeBinding.packages?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToPackagesFragment()
            findNavController().navigate(action)
        }
        homeBinding.gallery?.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
            findNavController().navigate(action)
        }

        homeBinding.location?.setOnClickListener {
            openMap()
        }
        //


    }



    fun openMap(){
        val alert: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        val mView: View = layoutInflater.inflate(R.layout.custom_dialog, null)
        //val txt_inputText = mView.findViewById(R.id.txt_input) as EditText
        val btn_name: Button = mView.findViewById(R.id.locationName) as Button
        btn_name.text = "Giggle School of Music and dance location"
        val btn_cancel: Button = mView.findViewById(R.id.btn_cancel) as Button
        val btn_okay: Button = mView.findViewById(R.id.btn_okay) as Button
        alert.setView(mView)
        val alertDialog: AlertDialog = alert.create()
        alertDialog.setCanceledOnTouchOutside(false)
        btn_cancel.setOnClickListener { alertDialog.dismiss() }
        btn_okay.setOnClickListener { // myCustomMessage.setText(txt_inputText.text.toString())
            //alertDialog.dismiss()

//            val gmmIntentUri: Uri = Uri.parse("google.navigation:q=37.4219983,-122.084")
//            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
//            mapIntent.setPackage("com.google.android.apps.maps")
//            startActivity(mapIntent)


            val uri: String = java.lang.String.format(
                Locale.ENGLISH,
                "http://maps.google.com/maps?q=Giggle School of Music and Dance",
                5.681525,
                -0.2006533
            )
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
            startActivity(intent)


        }
        alertDialog.show()
    }

}