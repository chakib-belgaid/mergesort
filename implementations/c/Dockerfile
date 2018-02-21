FROM gcc:latest as compiler
ADD mergesort.c . 
RUN gcc mergesort.c -lm -o mergesort 
FROM chakibmed/powerapi:latest
LABEL Name=c Version=0.0.1
COPY --from=compiler mergesort .
ENTRYPOINT [ "./mergesort" ]
#ENTRYPOINT ["./analyse.sh","c"]
CMD ["20"]
