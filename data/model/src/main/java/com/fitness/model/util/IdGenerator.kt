package com.fitness.model.util

import java.util.UUID
import java.util.UUID.fromString


fun createUniqueIdentifier() : String = UUID.randomUUID().toString()