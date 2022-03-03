#include <jni.h>
#include <string>
#include "libs/util/libutil.h"
#include "libs/openssl/arm64-v8a/include/openssl/ssl.h"
#include "libs/openssl/arm64-v8a/include/openssl/rand.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_appTitleFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    // try to call the self build static library
//    int sum = getSum(1, 2);

    // try to get openssl define value
//    int ASN1_VERSION = SSL_SESSION_ASN1_VERSION;

//    unsigned char key[128];
//    RAND_bytes(key,128);

    std::string appTitle = "Password Manager (Native)" ;
    return env->NewStringUTF(appTitle.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_ts_msg_invw_PwMgr_MainActivity_readFromJNI(
        JNIEnv* env,
jobject /* this */) {
std::string readRecord = "read";
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
    std::string deleteRecord = "delete record";
    return env->NewStringUTF(deleteRecord.c_str());
}