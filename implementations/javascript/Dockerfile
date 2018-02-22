FROM chakibmed/powerapi:latest
LABEL Name=javascript Version=0.0.1
RUN apt-get -y update && apt-get -y install nodejs 
ADD  mergesort.js  . 
ENTRYPOINT ["./analyse.sh", "nodejs","mergesort.js" ]
CMD ["100"]
