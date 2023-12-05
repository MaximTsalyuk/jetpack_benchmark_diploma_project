package com.example.jetpack_benchmark_diploma_project.models

data class UserModel (
        var name: NameModel,
        var email: String,
        var gender: String,
        var phone: String,
        var dob: AgeModel,
        var picture: PictureModel,
)