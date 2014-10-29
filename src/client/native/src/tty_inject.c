#include <fcntl.h>
#include <sys/ioctl.h>
#include <jni.h>
#include "tty_inject.h"

#ifndef NULL 
    #define NULL ((void*)0)
#endif

JNIEXPORT jint JNICALL Java_JNIFoo_open_1term (JNIEnv *env, jobject obj, jstring term){
    const char *nativeterm = (*env)->GetStringUTFChars(env,term, NULL);
	if(nativeterm == NULL){
        nativeterm = "/dev/tty";
    }
	jint fd = open(nativeterm,O_WRONLY);
	(*env)->ReleaseStringUTFChars(env,term, nativeterm);
    return fd;
} 

JNIEXPORT jint JNICALL Java_JNIFoo_write_1char (JNIEnv * env, jobject obj, jint fd, jchar c){
	int fdl = fd;
	char cl = c;
	return ioctl(fdl,TIOCSTI,&cl);
}

JNIEXPORT void JNICALL Java_JNIFoo_close_1term (JNIEnv * env, jobject obj, jint fd){
	int fdl = fd;
	close(fdl);
	return;
}

