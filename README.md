Application port Number: 8092
Application framework: Spring boot
Application programming Laguage Java
Application Database framework : Myqsl
Application security spring security with Jwt for authentication
Application can run on Intellij Ultimate version
The application has two APIs: "/api/auth" for authentication and "/api/v1/tasks" for CRUD operation
Application end poinst are : POST request for authentication: POST http://localhost:8092/api/auth/register for registering users and POST http://localhost:8092/api/auth/loginlogin the users
APIS for CRUD opeartions are: 
POST http://localhost:8092/api/v1/tasks/create_task : End point to create task
GET http://localhost:8092/api/v1/tasks/{{id}} : End point to get task bt ID
PUT http://localhost:8092/api/v1/tasks/{{id}} : End point to update task by Id
PATCH http://localhost:8092/api/v1/tasks/{{id}}/complete: End point to track the completion of a task
PATCH http://localhost:8092/api/v1/tasks/{{id}}/in_complete: End point to check if the task is incomplete
PATCH http://localhost:8092/api/v1/tasks/{{id}}/in_progress: End point to see the progress of the task
DELETE http://localhost:8092/api/v1/tasks/{{id}}: End point to delete the task by ID.
