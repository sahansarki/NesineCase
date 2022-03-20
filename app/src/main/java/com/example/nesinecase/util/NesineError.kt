package com.example.nesinecase.util

class NesineError(
    override val message: String,
    override val cause: Throwable? = null
) : Throwable()