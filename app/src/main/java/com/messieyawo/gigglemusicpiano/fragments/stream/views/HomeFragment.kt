package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater,container, false)

            //adult
        homeBinding.adultLearning.setOnClickListener {
            openAdultLearningDialog()
        }
              //classes
        homeBinding.classes.setOnClickListener {
            openClassesDialog()
        }
         //swimming
        homeBinding.swimming.setOnClickListener {
            openSwimmingDialog()
        }
        //danse class
        homeBinding.danceClass.setOnClickListener {
            openDanseDialog()
        }
        //ballet kids
        homeBinding.balletKids.setOnClickListener {
            onpenBalletKids()
        }
        //it center
        homeBinding.itCenter.setOnClickListener {
            openItDialogBox()
        }
        homeBinding.studio.setOnClickListener {
            openStudio()
        }

        homeBinding.piano.setOnClickListener {
            openPianoDialog()
        }

        homeBinding.violin.setOnClickListener {
            openPianoDialog()
        }
        return homeBinding.root
    }

    private fun openPianoDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog_piano)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }




        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }


    private fun openAdultLearningDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }




        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }


    private fun openClassesDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog_classes)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }




        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }


    private fun openSwimmingDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog_swimming)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }




        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }


    private fun  openStudio() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog_studio)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }




        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }




    private fun openDanseDialog() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog_dance)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }




        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }

    private fun onpenBalletKids() {

        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog_ballet)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }




        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }

    private fun openItDialogBox() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_sheet_dialog_it)


//        val editLayout = dialog.findViewById<Button>(R.id.server_one)
//        val shareLayout = dialog.findViewById<Button>(R.id.server_two)
//        val uploadLayout = dialog.findViewById<Button>(R.id.server_three)


        val cancel = dialog.findViewById<ImageView>(R.id.cancel)
        cancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
        dialog.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.window!!.setGravity(Gravity.BOTTOM)
    }
}