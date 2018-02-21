
FROM chakibmed/powerapi:latest
LABEL Name=python Version=0.0.1
RUN apt-get -y update && apt-get -y install python3-minimal 
ADD mergesort.py .
ENTRYPOINT ["python3","mergesort.py"]
#ENTRYPOINT ["./analyse.sh","python3","mergesort.py"]
CMD ["20"]
