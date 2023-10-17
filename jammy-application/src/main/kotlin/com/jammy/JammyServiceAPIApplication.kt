package com.jammy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JammyServiceAPIApplication

fun main(args: Array<String>) {
    runApplication<JammyServiceAPIApplication>(*args)
}