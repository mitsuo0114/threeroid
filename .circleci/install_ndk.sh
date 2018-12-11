# https://medium.com/@Cuong.Le/a-note-on-android-ndk-builds-for-circleci-2-0-ca35c693c340

  ANDROID_HOME="/opt/android/sdk"
  ANDROID_NDK="$ANDROID_HOME/ndk"
  echo "export ANDROID_NDK=$ANDROID_HOME/ndk/" >> $BASH_ENV
  echo "export ANDROID_NDK_HOME=$ANDROID_HOME/ndk/" >> $BASH_ENV

  if [ ! -d "${ANDROID_NDK}" ]; then
    cd $ANDROID_HOME
    echo "Downloading NDK... ${1}"
    sudo curl -L -o ndk.zip https://dl.google.com/android/repository/${1}-linux-x86_64.zip
    unzip -o -q ndk.zip

    echo "Installed Android NDK at $ANDROID_NDK"

    mv ${1} ndk

    sudo rm ndk.zip
  else
    echo "Android NDK was found. Skip install $ANDROID_NDK"
  fi
