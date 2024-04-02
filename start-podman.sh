podman run -d --name localstack \
	-p 4566:4566 \
	-p 4510-4559:4510-4559 \
	-p 8055:8080 \
	-e SERVICES=sqs \
	-e DEBUG=1 \
	-e DEFAULT_REGION=sa-east-1 \
	-e EDGE_PORT=4566 \
	localstack/localstack
