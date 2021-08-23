package com.proway.mvvm_auth.model


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ContaTest {

    @Test
    fun `valor maior que zero retorna false`() {
        val result = Conta(null, "", -7.1).validaConta()
        assertThat(result).isFalse()
    }

    @Test
    fun `valor maior que zero retorna true`() {
        val result = Conta(null, "", 7.1).validaConta()
        assertThat(result).isTrue()
    }

    @Test
    fun `valor null retorna false`() {
        val result = Conta(null, "", null).validaConta()
        assertThat(result).isTrue()
    }
}