<h1 align="center">Product API — Spring Boot Assignment</h1>

<p align="center">
RESTful Product API built using <b>Java 17 & Spring Boot</b> with JWT security, pagination, validation and Docker support.
</p>

<hr/>

<h2>Overview</h2>
<p>
This project provides a RESTful API for managing <b>Products</b> and <b>Items</b> with authentication and clean architecture as required in the assignment.
</p>

<hr/>

<h2>Tech Stack</h2>
<ul>
<li>Java 17</li>
<li>Spring Boot</li>
<li>Spring Data JPA (Hibernate)</li>
<li>PostgreSQL</li>
<li>Spring Security (JWT + Refresh Token)</li>
<li>Swagger / OpenAPI</li>
<li>Docker & Docker Compose</li>
<li>JUnit 5 & Mockito</li>
</ul>

<hr/>

<h2>Features</h2>
<ul>
<li>Product CRUD operations</li>
<li>Item management per product</li>
<li>JWT authentication & refresh token</li>
<li>Pagination support</li>
<li>Validation & global exception handling</li>
<li>Role based authorization</li>
<li>Swagger documentation</li>
<li>Docker ready setup</li>
</ul>

<hr/>

<h2>Authentication</h2>
<pre>
POST /api/v1/auth/login
POST /api/v1/auth/refresh
</pre>

<hr/>

<h2>Product APIs</h2>
<pre>
GET /api/v1/products
GET /api/v1/products/{id}
POST /api/v1/products
PUT /api/v1/products/{id}
DELETE /api/v1/products/{id}
GET /api/v1/products/{id}/items
</pre>

<hr/>

<h2>Setup</h2>

<h3>Clone</h3>
<pre>
git clone &lt;repo-url&gt;
cd productapi
</pre>

<h3>Run</h3>
<pre>
mvn spring-boot:run
</pre>

<h3>Jar</h3>
<pre>
mvn clean package
java -jar target/productapi-0.0.1-SNAPSHOT.jar
</pre>

<hr/>

<h2>Docker</h2>
<pre>
docker compose up --build
</pre>

<hr/>

<h2>Swagger</h2>
<pre>
http://localhost:8080/swagger-ui/index.html
</pre>

<hr/>

<h2>Testing</h2>
<ul>
<li>JUnit 5</li>
<li>Mockito</li>
<li>Spring Boot Test</li>
<li>H2 for tests</li>
</ul>

<hr/>

<h2>Architecture</h2>
<ul>
<li>Controller → Service → Repository</li>
<li>DTO based API design</li>
<li>JWT filter security</li>
<li>Centralized error handling</li>
<li>Database indexing implemented for optimized query performance.</li>
</ul>

<hr/>

<h2>Time Taken</h2>
<p><b>1 day</b></p>

<hr/>

<h2>Author</h2>
<p>Your Name</p>