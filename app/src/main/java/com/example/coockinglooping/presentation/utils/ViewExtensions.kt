package com.example.coockinglooping.presentation.utils

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.scrollToTop() {
    this.post {
        this.smoothScrollToPosition(0)
    }
}