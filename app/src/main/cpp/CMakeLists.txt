# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

cmake_minimum_required(VERSION 3.10.2)
project("PwMgr")

# PwMgr native-lib
add_library(
        PwMgr
        SHARED
        native-lib.cpp)

find_library(
        log-lib
        log)

# libutil
add_library(
        libutil
        STATIC
        IMPORTED)
set_target_properties(
        libutil
        PROPERTIES IMPORTED_LOCATION libs/util/libutil.a)
include_directories(
        libs/util/)

# libcrypto
add_library(
        libcrypto
        STATIC
        IMPORTED)
set_target_properties(
        libcrypto
        PROPERTIES IMPORTED_LOCATION libs/openssl/arm64-v8a/lib/libcrypto.a)
include_directories(
        libs/openssl/arm64-v8a/include)

# libssl
add_library(
        libssl
        STATIC
        IMPORTED)
set_target_properties(
        libssl
        PROPERTIES IMPORTED_LOCATION libs/openssl/arm64-v8a/lib/libssl.a)
include_directories(
        libs/openssl/arm64-v8a/include)

target_link_libraries( # Specifies the target library.
        PwMgr
        ${log-lib})
