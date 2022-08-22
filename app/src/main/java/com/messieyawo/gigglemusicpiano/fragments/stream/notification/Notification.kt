package com.messieyawo.gigglemusicpiano.fragments.stream.notification


import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.messieyawo.gigglemusicpiano.activities.HomeActivity
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.model.Users
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.messieyawo.gigglemusicpiano.R


const val notificationID = 1
const val channelID = "channel1"

class Notification() : BroadcastReceiver() {
    private val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myReference : DatabaseReference = database.reference.child("MyUsers")
    private var mFireStore = FirebaseFirestore.getInstance()
    val userList = ArrayList<Users>()
    companion object {
        private var oldId:String = ""
       // private var userId:String = ""
    }
   // private lateinit var mAuth: FirebaseAuth
    override fun onReceive(context: Context, intent: Intent) {
       // Toast.makeText(context,"This toast will be shown every X minutes", Toast.LENGTH_SHORT).show()
            if (oldId == ""){
                subscribeToRealtimeUpdates(context)
                Log.i("DATA","Send notification")
            }else if (oldId != "" ){
                Log.i("DATA","Notify already")
            }else{
                subscribeToRealtimeUpdates(context)
            }

    }


    private fun subscribeToRealtimeUpdates(context: Context) = CoroutineScope(Dispatchers.IO).launch{

        myReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                for (eachUser in snapshot.children) {

                    val user = eachUser.getValue(Users::class.java)
                    //  userId = userList[0].postId

                    if (user != null) {

                        println("title: ${user.title}")
                        println("Post: ${user.post}")
                        println("****************************")

                        userList.add(0, user)
                        oldId = userList[0].postId

                         // val data1 = userList[0].title
                          // if (data1 != user.title){
                               sendNotification(context,user.title,user.post)
                          // }


                    }
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }

    private fun sendNotification(context: Context,title: String, post: String) {


            val activityIntent = Intent(context, HomeActivity::class.java)
            val actionIntent = PendingIntent.getActivity(context,
                0, activityIntent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)



            // Assign big picture notification
            // Assign big picture notification
            val bpStyle = NotificationCompat.BigPictureStyle()
            bpStyle.bigPicture(BitmapFactory.decodeResource(context.resources, R.drawable.bigstyle)).build()
           // val dateReq: Date = reqTime.toDate()
           // val date = DateFormat.format("dd-MM-yyyy hh:mm:ss", dateReq).toString()
            val notification = NotificationCompat.Builder(context, channelID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("$title \n")
                .setContentText("$post")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(actionIntent)
                .setAutoCancel(true)
                .setStyle(bpStyle)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher_round, "View Request", actionIntent)
                .build()

            val  manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(notificationID, notification)



        }




    }






