#!/bin/bash
POD=message-processor
podman pod create \
    --name ${POD} \
    -p 8080:8080

podman run -d \
    --pod ${POD} \
    --name ${POD}-instance-1 \
    message-processor

podman run -d \
    --pod ${POD} \
    --name ${POD}-instance-2 \
    message-processor

podman run -d \
    --pod ${POD} \
    --name ${POD}-instance-3 \
    message-processor

podman run -d \
    --pod ${POD} \
    --name ${POD}-instance-4 \
    message-processor