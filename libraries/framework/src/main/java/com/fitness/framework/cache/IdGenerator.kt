package com.fitness.framework.cache

import java.util.UUID
import java.util.UUID.fromString


fun createUniqueIdentifier() : String = UUID.randomUUID().toString()