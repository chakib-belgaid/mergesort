
FROM gcc:latest as compiler
ADD mergesort.cpp . 
RUN g++ mergesort.cpp -lm -o mergesort 
FROM chakibmed/powerapi:latest
LABEL Name=cpp Version=0.0.1
COPY --from=compiler mergesort .
ENTRYPOINT [ "./analyse.sh","./mergesort" ]
CMD ["20"]
