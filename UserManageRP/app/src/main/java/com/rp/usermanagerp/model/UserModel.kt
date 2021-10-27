package com.rp.usermanagerp.model

data class UserModel(
    var id: String?,
    var nome: String = "",
    var dataNascimento: String = "",
    var email: String = "",
    var senha: String = "",
    var dataCadastro: String?
)