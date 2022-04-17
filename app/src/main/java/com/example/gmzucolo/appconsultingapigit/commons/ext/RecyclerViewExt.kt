package com.example.gmzucolo.appconsultingapigit.commons.ext

import android.view.animation.Animation
import android.view.animation.LayoutAnimationController

fun RecyclerViewExt.animateList {
    val animationController: LayoutAnimationController = android.view.animation.AnimationUtils.loadlayoutAnimation(
        context,
        R.anim.layout_animation
    )
    this.layoutAnimation = animationController
}