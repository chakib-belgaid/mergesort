
#build stage
FROM golang:alpine AS builder
WORKDIR /go/src/app
COPY mergesort.go .
RUN go-wrapper download   # "go get -d -v ./..."
RUN go-wrapper install    # "go install -v ./..."

#final stage
FROM chakibmed/powerapi:latest
COPY --from=builder /go/bin/app /app
ENTRYPOINT [ "./analyse.sh","./app" ]
CMD [ "20" ]

