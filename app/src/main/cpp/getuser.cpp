#include <sys/types.h>
#include <pwd.h>
#include <unistd.h>
#include <jni.h>

extern "C" JNIEXPORT jstring JNICALL Java_com_monte_os_pistachio_identifiers_appscope_GetUser_getUser(JNIEnv* env) {
    uid_t uid = geteuid();
    struct passwd *user;
    if (uid == -1)
        return nullptr;
    user = getpwuid(uid);
    return env->NewStringUTF(user->pw_name);
}
