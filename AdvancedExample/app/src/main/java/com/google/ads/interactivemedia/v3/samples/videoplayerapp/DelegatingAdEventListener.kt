package com.google.ads.interactivemedia.v3.samples.videoplayerapp

import android.util.Log
import com.google.ads.interactivemedia.v3.api.AdEvent
import com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener

class DelegatingAdEventListener(
    private val delegate: AdEventListener
) : AdEventListener {
    override fun onAdEvent(event: AdEvent) {
        Log.d(TAG, "event = $event")

        // This NPE can be observed with CONTENT_RESUME_REQUESTED events
        val ad = event.ad
        Log.d(TAG, "ad = $ad")

        // This NPE can be observed with LOADED events
        val adData = event.adData
        Log.d(TAG, "adData = $adData")

        delegate.onAdEvent(event)
    }
}

private const val TAG = "ImaExample"
