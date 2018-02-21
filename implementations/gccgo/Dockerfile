FROM chakibmed/powerapi:latest
LABEL Name=gccgo Version=0.0.1

RUN apt-get -y update && apt-get -y install gccgo 
ADD mergesort.go .
RUN gccgo -g mergesort.go  -o mergesort

ENTRYPOINT ["./mergesort"]
#ENTRYPOINT ["./analyse.sh","mergesort"]
CMD ["20"]
