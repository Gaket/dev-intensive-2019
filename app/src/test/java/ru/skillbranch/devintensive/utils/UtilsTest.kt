package ru.skillbranch.devintensive.utils

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Artur (gaket) on 2019-07-02.
 */
class UtilsTest {

    @Test
    fun parseFullName() {
        val (f, l) = Utils.parseFullName("Art Bad")
        assertEquals(f, "Art")
        assertEquals(l, "Bad")
    }

    @Test
    fun parseEmtpyName() {
        val (f, l) = Utils.parseFullName("")
        assertNull(f)
        assertNull(l)
    }

    @Test
    fun parseSpaceName() {
        val (f, l) = Utils.parseFullName(" ")
        assertNull(f)
        assertNull(l)
    }

    @Test
    fun parseHalfName() {
        val (f, l) = Utils.parseFullName("Art")
        assertEquals(f, "Art")
        assertNull(l)
    }
}