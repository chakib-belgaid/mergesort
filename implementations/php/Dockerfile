
FROM chakibmed/powerapi:latest
LABEL Name=php Version=0.0.1
RUN apt-get -y update && apt-get -y install php5-cli
ADD mergesort.php .
ENTRYPOINT ["./analyse.sh","php","mergesort.php"]
CMD ["21"]
