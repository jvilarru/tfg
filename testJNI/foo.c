#include <stdio.h>
#include <jni.h>
#include "JNIFoo.h"

JNIEXPORT jstring JNICALL Java_JNIFoo_nativeFoo (JNIEnv *env, jobject obj)
{
  	printf("Hello c.\n");
	return 0;
}

