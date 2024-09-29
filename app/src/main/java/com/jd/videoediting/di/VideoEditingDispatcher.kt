package com.jd.videoediting.di

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val niaDispatcher: VideoEditingDispatcher)

enum class VideoEditingDispatcher {
    Default,
    IO,
}
