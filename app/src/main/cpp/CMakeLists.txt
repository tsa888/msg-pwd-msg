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
#        ${CMAKE_SOURCE_DIR}/libs/util/libutil.c)
set_target_properties(
        libutil
        PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/util/libutil.a)
include_directories(
        ${CMAKE_SOURCE_DIR}/libs/util/)

# libsqlite3
add_library(
        libsqlite3
        STATIC
        IMPORTED)
set_target_properties(
        libsqlite3
        PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/sqlite/lib/arm64-v8a/libsqlite3.a)
include_directories(
        ${CMAKE_SOURCE_DIR}/libs/sqlite/include)

# libcrypto
add_library(
        libcrypto
        STATIC
        IMPORTED)
set_target_properties(
        libcrypto
        PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/openssl/arm64-v8a/lib/libcrypto.a)
include_directories(
        ${CMAKE_SOURCE_DIR}/libs/openssl/arm64-v8a/include)

# libssl
add_library(
        libssl
        STATIC
        IMPORTED)
set_target_properties(
        libssl
        PROPERTIES IMPORTED_LOCATION ${CMAKE_SOURCE_DIR}/libs/openssl/arm64-v8a/lib/libssl.a)
include_directories(
        ${CMAKE_SOURCE_DIR}/libs/openssl/arm64-v8a/include)

target_link_libraries( # Specifies the target library.
        PwMgr
        ${log-lib}
        libutil
        libsqlite3
        libcrypto
        libssl)
