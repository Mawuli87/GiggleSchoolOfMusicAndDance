package com.messieyawo.gigglemusicpiano.fragments.stream.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.messieyawo.gigglemusicpiano.databinding.FragmentStreamBinding
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.adapter.ImageAdapter
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.model.ImgModel


class StreamFragment : Fragment() {

    private val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myReference : DatabaseReference = database.reference.child("MyPosts")

    val userList = ArrayList<ImgModel>()
    val imageNameList = ArrayList<String>()

    lateinit var imageAdapter : ImageAdapter

    private val firebaseStorage : FirebaseStorage = FirebaseStorage.getInstance()
    val storageReference : StorageReference = firebaseStorage.reference


 lateinit var binding: FragmentStreamBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentStreamBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        retrieveDataFromDatabase()
    }



    private fun retrieveDataFromDatabase(){

        //ChildEventListener

        myReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                userList.clear()

                for (eachUser in snapshot.children){

                    val user = eachUser.getValue(ImgModel::class.java)

                    if (user != null){

                        println("userId: ${user.imgId}")
                        println("userName: ${user.imageName}")
                        println("userAge: ${user.title}")
                        println("****************************")

                        userList.add(user)

                    }

                    imageAdapter = ImageAdapter(requireActivity(),userList)

                    binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())

                    binding.recyclerView.adapter = imageAdapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }




}