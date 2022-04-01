package com.jasonazevedo.thunderstorm.repositories

interface IRepository<T> {
    fun getAll(): List<T>
}