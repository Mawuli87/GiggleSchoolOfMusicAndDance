package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.messieyawo.gigglemusicpiano.databinding.FragmentProfileBinding
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.adapter.UsersAdapter
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.model.Users


class ProfileFragment : Fragment() {
lateinit var binding:FragmentProfileBinding
    private val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myReference : DatabaseReference = database.reference.child("MyUsers")

    val userList = ArrayList<Users>()
    val imageNameList = ArrayList<String>()


    lateinit var usersAdapter : UsersAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding  = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val handler = Handler()
//        val delay = 1000 // 1
//
//        handler.postDelayed(object : Runnable {
//            override fun run() {
//                checkData()
//                handler.postDelayed(this, delay.toLong())
//            }
//        }, delay.toLong())

        //pushNotification()
        retrieveDataFromDatabase()
    }


//    private fun createNotification(title: String, descript: String) {
//        NotificationHelper(requireActivity()).createNotification(title,descript)
//    }




    private fun retrieveDataFromDatabase(){

        myReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


                userList.clear()

                for (eachUser in snapshot.children){

                    val user = eachUser.getValue(Users::class.java)

                    if (user != null){

                        println("title: ${user.title}")
                        println("Post: ${user.post}")
                        println("****************************")

                        userList.add(0,user)

                    }

                    binding.progressCircle.visibility = View.GONE
                    binding.textViewNodata.visibility = View.GONE

                    usersAdapter = UsersAdapter(requireActivity(),userList)

                    binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())

                    binding.recyclerView.adapter = usersAdapter

                }

                binding.progressCircle.visibility = View.GONE


            }

            override fun onCancelled(error: DatabaseError) {
                binding.progressCircle.visibility = View.GONE
                binding.textViewNodata.visibility = View.VISIBLE
            }
        })

    }



}