#include <jni.h>

JNIEXPORT jstring JNICALL
Java_test_jni_up_day_day_com_jnitestproject_JniTestActivity_getCommonNotice(JNIEnv *env,
                                                                         jobject instance) {

    // TODO

    return (*env)->NewStringUTF(env, "这只是一个小小的jni测试");
}