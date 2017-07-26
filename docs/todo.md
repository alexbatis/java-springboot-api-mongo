## Todo
  `Todo` Endpoint for managaing todos.

### Endpoint Summary
* `[GET]` /todos - [Retrieve All *Todos*](#Retrieve-All-Todos)
* `[POST]` /todos - [Create a new *Todo*](#Create-a-new-Todo)
* `[GET]` /todos/<.id> - [Retrieve a single *Todo* with `id`](#Retrieve-a-single-Todo)
* `[PUT]` /todos/<.id> - [Edit a single *Todo* with `id`](#Edit-a-single-Todo)
* `[DELETE]` /todos/<.id> - [Delete a single *Todo* with `id`](#Delete-a-single-Todo)


### Retrieve All Todos

* **Syntax** : `[GET] /todos`
* **URL** :  `/todos`  
* **Method**: `GET`  
* **URL Params**:   
   **Required:**   None  

* **Success Response:**
 
   **Code:** 200 <br />
    **Content:** 
    ```
    {
        "_embedded": {
            "todos": [...]
        },
        "_links": {
            "self": {
                "href": "http://localhost:8080/todos{?page,size,sort}",
                "templated": true
            },
            "profile": {
                "href": "http://localhost:8080/profile/todos"
            },
            "search": {
                "href": "http://localhost:8080/todos/search"
            }
        },
        "page": {
            "size": 20,
            "totalElements": 2,
            "totalPages": 1,
            "number": 0
        }
    }
    ```

* **Sample Call:**

   `  curl "http://localhost:8080/todos"`  
 Fetches 5 todo results skipping the first 2  

* **Notes:**

 
### Create a new Todo 

* **Syntax** : `[POST] /todos`
* **URL** :  `/todos`  
* **Method**: `POST`  
* **URL Params**:   
   **Optional:**   None  
   **Required:**  
 
   `{todo:{}}` - The base todo data object  
   ```
    {
        "title"	:	"Walk The Dog",
        "description"	: "Walk around the block at least twice"
    }
   ```
* **Success Response:**
 
   **Code:** 201  
   **Content:** 
    ```
  {
      "title": "Walk The Dog",
      "description": "Walk around the block at least twice",
      "completed": false,
      "created": "2017-07-26T06:26:15.656+0000",
      "_links": {
          "self": {
              "href": "http://localhost:8080/todos/59783607d1693827643da7b7"
          },
          "todoItem": {
              "href": "http://localhost:8080/todos/59783607d1693827643da7b7"
          }
      }
  }
    ```
* **Error Response:**
 
   **Code:** 400 <br />
    **Content:** 
    ```
     {
         "cause": {
             "cause": null,
             "message": "Unrecognized token 'bad': was expecting ('true', 'false' or 'null')\n at [Source: org.apache.catalina.connector.CoyoteInputStream@8abd688; line: 1, column: 5]"
         },
         "message": "JSON parse error: Unrecognized token 'bad': was expecting ('true', 'false' or 'null'); nested exception is com.fasterxml.jackson.core.JsonParseException: Unrecognized token 'bad': was expecting ('true', 'false' or 'null')\n at [Source: org.apache.catalina.connector.CoyoteInputStream@8abd688; line: 1, column: 5]"
     }
    ```


### Retrieve a single Todo 

* **Syntax** : `[GET] /todos/:id`
* **URL** :  `/todos/:id`  
* **Method**: `GET`  
* **URL Params**:   
   **Optional:**   None  
   **Required:**  
 
   `id` - The object id of the todo  
   
* **Success Response:**
 
   **Code:** 200  
   **Content:** 
    ```
    {
       "title": "Walk The Dog",
       "description": "Walk around the block at least twice",
       "completed": false,
       "created": "2017-07-26T04:31:46.758+0000",
       "_links": {
           "self": {
               "href": "http://localhost:8080/todos/59781b32d169381728c7c08d"
           },
           "todoItem": {
               "href": "http://localhost:8080/todos/59781b32d169381728c7c08d"
           }
       }
    }
    ```
* **Error Response:**
 
   **Code:** 404   

### Edit a single Todo

* **Syntax** : `[PUT] /todos/:id`
* **URL** :  `/todos/:id`  
* **Method**: `PUT`  
* **URL Params**:   
   **Optional:**   None  
   **Required:**  
 
  `id` - The object id of the todo  
    `{todo:{}}` - The base todo data object that needs to be changed 
   ```
    {
        "title"	        : "Walk The Dog",
        "description"	: "Walk around the block at least twice",
        "completed"	    : true
    }
   ```
* **Success Response:**
 
   **Code:** 202  
    **Content:** ``
    ```
    {
      "title": "Walk The Dog",
      "description": "Walk around the block at least twice",
      "completed": true,
      "created": "2017-07-26T06:29:52.053+0000",
      "_links": {
          "self": {
              "href": "http://localhost:8080/todos/59783607d1693827643da7b7"
          },
          "todoItem": {
              "href": "http://localhost:8080/todos/59783607d1693827643da7b7"
          }
      }
    }
    ```
* **Error Response:**

   **Code:** 404  
   **Content:** 
    ```
    {
        "timestamp": 1501050667065,
        "status": 404,
        "error": "Not Found",
        "message": "No message available",
        "path": "/todos/"
    }   
    ```

* **Notes:**
PUT-ing to an id that doesnt exist will POST the object


### Delete a single Todo

* **Syntax** : `[DELETE] /todos/:id`
* **URL** :  `/todos/:id`  
* **Method**: `DELETE`  
* **URL Params**:   
   **Optional:**   None  
   **Required:**  
 
  `id` - The object id of the todo  
* **Success Response:**
 
   **Code:** 204 No Content

* **Error Response:**
 
   **Code:** 404 Not Found




