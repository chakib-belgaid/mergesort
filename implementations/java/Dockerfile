FROM openjdk:8-jdk-stretch as compiler
LABEL Name=java Version=0.0.1
ADD MergeSort.java .
RUN apt-get -y update
RUN javac MergeSort.java  
FROM chakibmed/powerapi:latest
COPY --from=compiler  "*.class" ./ 

ENTRYPOINT ["./analyse.sh","java", "MergeSort" ]
#ENTRYPOINT ["./analysava", "pidigits" ]
CMD [ "20" ] 