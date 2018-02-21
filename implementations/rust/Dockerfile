FROM chakibmed/gmp:latest as compiler
LABEL Name=rust Version=0.0.1
RUN apt-get -y update && apt-get -y install rustc 
ADD mergesort.rs .
RUN rustc  mergesort.rs -o mergesort
#RUN rustc  mergesort.rs -C opt-level=1 -o mergesort
#RUN rustc  mergesort.rs -C opt-level=2 -o mergesort
#RUN rustc  mergesort.rs -C opt-level=3 -o mergesort
FROM chakibmed/powerapi:latest
COPY --from=compiler  mergesort . 

#ENTRYPOINT [ "./mergesort" ]

ENTRYPOINT ["./analyse.sh" , "./mergesort" ]
CMD [ "20" ] 
#//2147483647