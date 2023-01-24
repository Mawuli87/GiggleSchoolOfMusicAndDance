package com.messieyawo.gigglemusicpiano.fragments.stream.views


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.messieyawo.gigglemusicpiano.databinding.FragmentChatWithUsBinding


class ChatWithUsFragment : Fragment() {
    lateinit var binding: FragmentChatWithUsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentChatWithUsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.HotLine.setOnClickListener {
           val phone = "+233593155232"
           val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
           startActivity(intent)
       }

        binding.whatsApp.setOnClickListener {
            val number = "+2330553592014"
            val url = "https://api.whatsapp.com/send?phone=$number"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

        binding.instagram.setOnClickListener {
        val action = ChatWithUsFragmentDirections.actionChatWithUsFragmentToInstagramFragment()
            findNavController().navigate(action)
        }
        binding.facebook.setOnClickListener {
            val action = ChatWithUsFragmentDirections.actionChatWithUsFragmentToFacebookFragment()
            findNavController().navigate(action)
        }

//        studioButton.setOnClickListener(View.OnClickListener {
//            val studiophone = "+233248142840"
//            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", studiophone, null))
//            startActivity(intent)
//        })

//        studioLine2.setOnClickListener(View.OnClickListener {
//            val studiophone2 = "+233248147036"
//            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", studiophone2, null))
//            startActivity(intent)
//        })

      binding.email.setOnClickListener(View.OnClickListener {
            val intent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "schoolgiggle@gmail.com", null))
            intent.putExtra(Intent.EXTRA_SUBJECT, "My Mail")
            intent.putExtra(Intent.EXTRA_TEXT, "My Message")
            try {
                startActivity(Intent.createChooser(intent, "Send mail DNT..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    activity,
                    "There are no email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

       binding.openWebite.setOnClickListener {
           val webIntent = Intent(activity, WebActivity::class.java)
           requireActivity().startActivity(webIntent)
       }

        binding.emergency.setOnClickListener {
           val number = "+233593155232"
           val url = "https://api.whatsapp.com/send?phone=$number"
           val i = Intent(Intent.ACTION_VIEW)
           i.data = Uri.parse(url)
           startActivity(i)
       }


    }


}