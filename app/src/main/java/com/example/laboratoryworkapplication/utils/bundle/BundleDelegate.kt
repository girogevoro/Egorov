package com.example.laboratoryworkapplication.utils.bundle

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import java.io.Serializable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

@Suppress("unused")
internal inline fun <reified T : Any> argument(): ReadWriteProperty<Fragment, T> =
    object : ReadWriteProperty<Fragment, T> {
        var cashed: T? = null

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            val key = property.name
            if (cashed == null) {
                cashed = thisRef.arguments?.take(key)
                    ?: throw IllegalStateException("Property ${property.name} could not be read")
            }
            return cashed!!
        }

        override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T) {
            val args = thisRef.arguments ?: Bundle().also(thisRef::setArguments)
            val key = property.name
            cashed = value
            args.put(key, value)
        }
    }

@Suppress("unused")
internal inline fun <reified T : Any> argumentNullable(): ReadWriteProperty<Fragment, T?> =
    object : ReadWriteProperty<Fragment, T?> {
        var cashed: T? = null

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T? {
            val key = property.name
            if (cashed == null) {
                cashed = thisRef.arguments?.take(key)
            }
            return cashed
        }

        override fun setValue(thisRef: Fragment, property: KProperty<*>, value: T?) {
            val args = thisRef.arguments ?: Bundle().also(thisRef::setArguments)
            val key = property.name
            cashed = value
            value?.let { args.put(key, it) } ?: args.remove(key)
        }
    }

fun <T> Bundle.put(key: String, value: T) {
    when (value) {
        is Boolean -> putBoolean(key, value)
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Short -> putShort(key, value)
        is Long -> putLong(key, value)
        is Byte -> putByte(key, value)
        is ByteArray -> putByteArray(key, value)
        is Char -> putChar(key, value)
        is CharArray -> putCharArray(key, value)
        is CharSequence -> putCharSequence(key, value)
        is Float -> putFloat(key, value)
        is Bundle -> putBundle(key, value)
        is Parcelable -> putParcelable(key, value)
        is Serializable -> throw IllegalStateException("Type of property $key Serializable is not supported")
        else -> throw IllegalStateException("Type of property $key is not supported")
    }
}

internal inline fun <reified T : Any> Bundle.take(key: String): T? {
    return if (containsKey(key)) {
        when (T::class) {
            Boolean::class -> getBoolean(key) as T?
            String::class -> getString(key) as T?
            Int::class -> getInt(key) as T?
            Short::class -> getShort(key) as T?
            Long::class -> getLong(key) as T?
            Byte::class -> getByte(key) as T?
            ByteArray::class -> getByteArray(key) as T?
            Char::class -> getChar(key) as T?
            CharArray::class -> getCharArray(key) as T?
            CharSequence::class -> getCharSequence(key) as T?
            Float::class -> getFloat(key) as T?
            Bundle::class -> getBundle(key) as T?
            else -> parcelable(key) as T?
        }
    } else {
        null
    }
}