package com.jd.videoediting.vm

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arthenica.ffmpegkit.FFprobeKit
import com.jd.videoediting.di.Dispatcher
import com.jd.videoediting.di.VideoEditingDispatcher
import com.jd.videoediting.domain.GetVideoFilePathFromUriUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EditVideoViewModel @Inject constructor(
    val getVideoFilePathFromUriUseCase: GetVideoFilePathFromUriUseCase,
    @Dispatcher(VideoEditingDispatcher.IO) private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    fun getMediaInformation(uri: Uri) {
        viewModelScope.launch(ioDispatcher) {
            val path = getVideoFilePathFromUriUseCase(uri)
            val mediaInformation = FFprobeKit.getMediaInformation(path)
            mediaInformation.mediaInformation
        }
    }
}