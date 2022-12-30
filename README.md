### Airlines Checking Microservice

<p>Checking service that provide checking before flight. Checking service is using H2 database. It communicates Ticket service using GRPC protocol.</p>

<p>It provide RestFull API for checking tickets. Endpoint wants <strong>checkingCode</strong> parameter as a path variable</p>

###### Avaliable Endpoints
<strong>Enpoint: http://localhost:8083/checking/{checkingCode}</strong>

#### Diagram
<img src="https://user-images.githubusercontent.com/77804034/210046538-15256911-5721-4d30-af07-a4cc2f290715.png"/>

#### Service Design
<img src="https://user-images.githubusercontent.com/77804034/210046668-cd5e3d3c-b4ce-43d4-b062-7d3c6a5a7b58.png"/>
