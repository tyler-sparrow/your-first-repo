FROM gitpod/workspace-full

# Remove any existing Java installations and install OpenJDK 17 cleanly
RUN sudo apt-get update && \
    sudo apt-get remove -y openjdk* && \
    sudo apt-get autoremove -y && \
    sudo apt-get install -y openjdk-17-jdk maven && \
    sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-17-openjdk-amd64/bin/java 100 && \
    sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/java-17-openjdk-amd64/bin/javac 100 && \
    sudo update-alternatives --set java /usr/lib/jvm/java-17-openjdk-amd64/bin/java && \
    sudo update-alternatives --set javac /usr/lib/jvm/java-17-openjdk-amd64/bin/javac

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH
