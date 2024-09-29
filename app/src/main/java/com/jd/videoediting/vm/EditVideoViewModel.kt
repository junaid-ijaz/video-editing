package com.jd.videoediting.vm

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthenica.ffmpegkit.FFprobeKit
import kotlinx.coroutines.launch


class EditVideoViewModel  : ViewModel(){

    fun getMediaInformation(filePath : String){
        viewModelScope.launch {
            val mediaInformation = FFprobeKit.getMediaInformation(filePath)
            Log.d("MyLogs", "getMediaInformation: ${
                mediaInformation.mediaInformation
            }")
        }

    }

}