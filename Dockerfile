FROM maven:latest
#FROM selenium/standalone-chrome:latest
COPY ./. /

#COPY ./src/test/java/chromedriver /home
#COPY ./* /usr/share/app/sudo find / -name libglib-2.0.so.0
#RUN docker pull selenium/standalone-chrome
#RUN apt-get update && \
#    apt-get install -y gnupg wget curl unzip --no-install-recommends && \
#    wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
#    echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list && \
#    apt-get update -y && \
#    apt-get install -y google-chrome-stable && \
#    CHROMEVER=$(google-chrome --product-version | grep -o "[^\.]*\.[^\.]*\.[^\.]*") && \
#    DRIVERVER=$(curl -s "https://chromedriver.storage.googleapis.com/LATEST_RELEASE_$CHROMEVER") && \
#    wget -q --continue -P /chromedriver "http://chromedriver.storage.googleapis.com/$DRIVERVER/chromedriver_linux64.zip" && \
#    unzip /chromedriver/chromedriver* -d /chromedriver
RUN mvn test


