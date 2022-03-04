#include <jni.h>
#include <string>
#include <stdlib.h>
#include <iostream>
#include "libs/util/libutil.h"
#include "libs/sqlite/include/sqlite3.h"
#include "libs/openssl/arm64-v8a/include/openssl/ssl.h"
#include "libs/openssl/arm64-v8a/include/openssl/opensslv.h"
#include "libs/openssl/arm64-v8a/include/openssl/rand.h"

using namespace std;


// function to return app title string from jnifucntion call
extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_appTitleFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    // try to call the self build static library
    int sum = getSum(1, 2);


//    int ans = charArrayToInt(key);
    string appTitle = "Password Manager (Native)";
    return env->NewStringUTF(appTitle.c_str());
}

// calling function from imported static library (libsqlite3.a)
extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_getSqlite3VersionFromJNI(
        JNIEnv* env,
    jobject /* this */) {
//    string sqliteInfo = sqlite3_libversion();
    string sqliteInfo = SQLITE_VERSION;
    sqliteInfo.append(" (");
    sqliteInfo.append(to_string(sqlite3_libversion_number()));
    sqliteInfo.append(")");

return env->NewStringUTF(sqliteInfo.c_str());
}

// calling function from imported static library (libssl.a)
extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_getOpenSSLVersionFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    unsigned char key[8];
    RAND_bytes(key,8);
    string sslInfo = OPENSSL_VERSION_TEXT;
    return env->NewStringUTF(sslInfo.c_str());
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_readFromJNI(
        JNIEnv* env,
jobject /* this */) {
    string readRecord = "read";
return env->NewStringUTF(readRecord.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_saveToJNI(
        JNIEnv* env,
        jobject /* this */,
        jstring usrName) {
    return usrName;
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_deleteJNI(
        JNIEnv* env,
        jobject /* this */) {
    string deleteRecord = "delete record";
    return env->NewStringUTF(deleteRecord.c_str());
}