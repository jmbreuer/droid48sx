# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.22.1)
project(48sx)

#set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -O0 -Wno-format -Wno-implicit-function-declaration -Wno-pointer-sign -Wno-return-type -Wno-user-defined-warnings")
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS}")

if(CMAKE_BUILD_TYPE STREQUAL Debug)
        message(" DEBUG BUILD (" ${CMAKE_BUILD_TYPE} ")")
        add_compile_options(-DDEBUG)
else()
        message(" RELEASE BUILD (" ${CMAKE_BUILD_TYPE} ")")
        add_compile_options("-Wno-user-defined-warnings")
        # add_compile_options("-g0")
endif()

add_compile_options(-O0)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library(
        # Sets the name of the library.
        droid48sx
        # Sets the library as a shared library.
        SHARED
        # Provides a relative path to your source file(s).
        actions.c
        binio.c
        debugger.c
        device.c
        disasm.c
        emulate.c
        init.c
        lcd.c
        main.c
        memory.c
        options.c
        register.c
        resources.c
        romio.c
        rpl.c
        serial.c
        timer.c
        x48.c
        )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library(
        # Sets the name of the path variable.
        log-lib
        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries(
        # Specifies the target library.
        droid48sx
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})
