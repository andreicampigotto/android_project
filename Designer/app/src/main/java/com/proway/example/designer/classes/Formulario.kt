package com.proway.example.designer.classes

class Formulario(
    var eMail: String?,
    var name: String?,
    var password: String?
) {
    constructor() : this(null, null, null)

    fun checkAll(): Boolean {
        return checkName() && checkeMail() && checkPassword()
    }

    private fun checkName(): Boolean {
        return !name.isNullOrEmpty()
    }

    private fun checkeMail(): Boolean {
        return !eMail.isNullOrEmpty()
    }

    private fun checkPassword(): Boolean {
        return !password.isNullOrEmpty()
    }
}