package com.proway.firebaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.proway.firebaseapplication.utils.replaceView
import com.proway.firebaseapplication.view.ContentFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if (FirebaseAuth.getInstance().currentUser != null)
//            replaceView(ContentFragment.newInstance())
//        else
//            LoginActivity()
    }
}