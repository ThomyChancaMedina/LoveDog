package com.thomy.lovedog.data.server

import com.thomy.lovedog.R

fun getDogsServer(): List<Dog> {
    return listOf(
        Dog(1, "Maine Coon", R.drawable.image1, "description", "España"),
        Dog(2, "Gato Persa", R.drawable.image2, "description", "España"),
        Dog(3, "Sphynx o Gato Esfinge", R.drawable.image3, "description", "España"),
        Dog(4, "Gato Saimés", R.drawable.image4, "description", "España"),
        Dog(5, "Gato Bengalí", R.drawable.image5, "description", "España"),
        Dog(6, "Gato Exótico", R.drawable.image6, "description", "Portugal"),
        Dog(7, "Bosque de Noruega", R.drawable.image2, "description", "Portugal"),
        Dog(8, "Gato Siberiano", R.drawable.image2, "description", "Portugal"),
        Dog(9, "Azul Ruso", R.drawable.image2, "description", "Portugal"),
        Dog(10, "Gato Ragdoll", R.drawable.image2, "description", "Portugal"),
        Dog(11, "British Shorthair", R.drawable.image2, "description", "Portugal"),
        Dog(12, "Gato Oriental", R.drawable.image3, "description", "Francia"),
        Dog(13, "Gato Birmano", R.drawable.image3, "description", "Francia"),
        Dog(14, "Angora Turco", R.drawable.image3, "description", "Francia"),
        Dog(15, "Van Turco", R.drawable.image3, "description", "Francia"),
        Dog(16, "Gato Himalayo", R.drawable.image3, "description", "Francia"),
        Dog(17, "Savannah", R.drawable.image4, "description", "Francia"),
        Dog(18, "Nebelung", R.drawable.image4, "description", "Reino unido"),
        Dog(19, "PeterBald", R.drawable.image4, "description", "Reino unido"),
        Dog(20, "Lykoi", R.drawable.image4, "description", "Reino unido"),
        Dog(21, "Munchkin", R.drawable.image4, "description", "Reino unido")
    )

}
