package com.proway.mvvm_auth.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserTest {

    @Test
    fun `valida se o email nao tem @ retorna false`() {
        val result = User("", "", "", "").validaEmail()
        assertThat(result).isFalse()
    }

    @Test
    fun `valida se o email tem @ retorna true`() {
        val result = User("teste@teste.com", "", "", "").validaEmail()
        assertThat(result).isTrue()
    }

    @Test
    fun `valida senha menor que 6 retorna false`() {
        val result = User("", "12345", "", "").validaSenha()
        assertThat(result).isFalse()
    }

    @Test
    fun `valida senha menor que 6 retorna true`() {
        val result = User("", "1234567", "", "").validaSenha()
        assertThat(result).isTrue()
    }

    @Test
    fun `valida se o nome e maior que 1 restorna false`() {
        val result = User("", "", "", " ").validaTamanhoNome()
        assertThat(result).isFalse()
    }

    @Test
    fun `valida se o nome e maior que 1 restorna true`() {
        val result = User("", "", "", "andrei").validaTamanhoNome()
        assertThat(result).isTrue()
    }

}