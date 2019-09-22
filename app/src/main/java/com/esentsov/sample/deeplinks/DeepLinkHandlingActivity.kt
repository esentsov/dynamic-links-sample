package com.esentsov.sample.deeplinks

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import java.net.URI

private const val TAG = "DeepLinkHandler"

class DeepLinkHandlingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleDeepLink()
    }

    private fun handleDeepLink() {
        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener(this) { pendingDynamicLinkData ->
                startMainActivity(pendingDynamicLinkData?.link)
                Log.w(TAG, "getDynamicLink:onSuccess")
            }
            .addOnFailureListener(this) { e ->
                startMainActivity()
                Log.w(TAG, "getDynamicLink:onFailure", e)
            }

    }

    private fun startMainActivity(deepLink: Uri? = null) {
        startActivity(Intent(this, MainActivity::class.java).also {
            it.data = deepLink
        })
    }
}
