# Copyright 2007-2008 The Android Open Source Project

LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)
LOCAL_SRC_FILES := $(call all-subdir-java-files)

LOCAL_MODULE_TAGS := optional

LOCAL_PACKAGE_NAME := R1000

LOCAL_JNI_SHARED_LIBRARIES := libr1000
LOCAL_REQUIRED_MODULES := libr1000

LOCAL_CERTIFICATE := platform

LOCAL_MODULE_PATH := $(TARGET_OUT_DATA_APPS)

include $(BUILD_PACKAGE)
include $(call all-makefiles-under, $(LOCAL_PATH))