package com.oyera.shared.commom.interfaces

interface Validator<T> {
    fun validate(input: T)
}