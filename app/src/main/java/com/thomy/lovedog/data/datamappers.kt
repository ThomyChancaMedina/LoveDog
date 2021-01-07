package com.thomy.lovedog.data

import com.thomy.domain.Dog
import com.thomy.lovedog.data.server.Dog as ServerDog
import com.thomy.lovedog.data.database.Dog as DomainDog

fun Dog.toRoomDog(): DomainDog =
    DomainDog(
        id,
        name,
        image,
        description,
        country
    )

fun DomainDog.toDomainDog(): Dog =
    Dog(
        id,
        name,
        image,
        description,
        country
    )

fun ServerDog.toDomainDog(): Dog =
    Dog(
        0,
        name,
        image,
        description,
        country
    )