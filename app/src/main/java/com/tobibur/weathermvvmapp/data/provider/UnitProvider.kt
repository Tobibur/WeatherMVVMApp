package com.tobibur.weathermvvmapp.data.provider

import com.tobibur.weathermvvmapp.internal.UnitSystem

interface UnitProvider{
    fun getUnitSystem(): UnitSystem
}