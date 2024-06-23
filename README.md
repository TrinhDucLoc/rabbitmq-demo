# rabbitmq-demo

# Step to config, send and receive message.
Step 1: Add RabbitMQ Dependencies
Step 2: Configure RabbitMQ properties
Step 3: Create RabbitMQ Configuration
Step 4: Sending Message
Step 5: Receiving Message

# Element of RabbitMQ
- Queue: Receive message from exchange and send message for consumer.
- Producer: Producer send message: payload, a label for exchange. Producer handle timeout and other exception when call queue.
- Exchange: An exchange receive message from producer. Exchange define routing and send message with type: direct, fanout, topic and header.
- Consumer: It subscribes to a queue and is connected to a broker server.
- Binding: It tell exchange which queue to distribute messages.