# CRUD API

### The REST API performs CRUD operations on Student objects as described below

## Installation
- Get the project
  - clone
    `git clone https://github.com/annicamclean/csc340-assignment4.git`
  - download zip
- Open the project in Intellij
- `/src/main/resources/application.properties` file is in the configuration for the MySQL database on your localhost.
  - the database name is on the `datasource.url` property between the last `/` and the `?`. In this case the database name is `animalsdb`.
  - You MUST have the database up and running before running the project!
    - Open your XAMPP Control Panel.
    - Start the Apache server.
    - Start MySQL.
    - Click on MySQL "Admin" to open up the DBMS.
    - Ensure the database that you need is available.
- Ensure the database that you need is available.

## API Endpoints
Use POSTMAN to try the following endpoints:

### Get list of Animals

#### Request
```
GET /animals/all

http://localhost:8080/animals/all
```

#### Response
```
[
    {
        "animalId": 1,
        "name": "name1",
        "scientificName": "scientificName1",
        "species": "species",
        "habitat": "habitat1",
        "description": "description1"
    },
    {
        "animalId": 2,
        "name": "updateName2",
        "scientificName": "scientificName32",
        "species": "species2",
        "habitat": "habitat2",
        "description": "description2"
    },
    {
        "animalId": 52,
        "name": "name3",
        "scientificName": "scientificName3",
        "species": "species3",
        "habitat": "habitat3",
        "description": "description3"
    }
]
```

### Get a Specific Animal

#### Request
```
GET /animals/{animalId}

http://localhost:8080/animals/1
```
#### Response
```
{
    "animalId": 1,
    "name": "name1",
    "scientificName": "scientificName1",
    "species": "species",
    "habitat": "habitat1",
    "description": "description1"
}
```

### Create a new Animal

#### Request
```
POST /animals/new

http://localhost:8080/animals/new --data '{"animalId": 400, "name": "name5", "scientificName": "scientificName5", "species": "species5", "habitat": "habitat5" ,"description": "description5"}'
```
#### Response
```
[
    {
        "animalId": 1,
        "name": "name1",
        "scientificName": "scientificName1",
        "species": "species",
        "habitat": "habitat1",
        "description": "description1"
    },
    {
        "animalId": 2,
        "name": "updateName2",
        "scientificName": "scientificName32",
        "species": "species2",
        "habitat": "habitat2",
        "description": "description2"
    },
    {
        "animalId": 52,
        "name": "name3",
        "scientificName": "scientificName3",
        "species": "species3",
        "habitat": "habitat3",
        "description": "description3"
    },
    {
        "animalId": 152,
        "name": "name5",
        "scientificName": "scientificName5",
        "species": "species5",
        "habitat": "habitat5",
        "description": "description5"
    }
]
```

### Get Animals by Species

#### Request
```
GET /animals/species?species=species

http://localhost:8080/animals/species?species=species
```
#### Response
```
[
    {
        "animalId": 2,
        "name": "updateName2",
        "scientificName": "scientificName32",
        "species": "species2",
        "habitat": "habitat2",
        "description": "description2"
    }
]
```

### Search For an Animal by Name

#### Request
```
GET /animals/search?name=name

http://localhost:8080/animals/search?name=name
```
#### Response
```
[
    {
        "animalId": 1,
        "name": "name1",
        "scientificName": "scientificName1",
        "species": "species",
        "habitat": "habitat1",
        "description": "description1"
    },
    {
        "animalId": 2,
        "name": "updateName2",
        "scientificName": "scientificName32",
        "species": "species2",
        "habitat": "habitat2",
        "description": "description2"
    },
    {
        "animalId": 52,
        "name": "name3",
        "scientificName": "scientificName3",
        "species": "species3",
        "habitat": "habitat3",
        "description": "description3"
    },
    {
        "animalId": 152,
        "name": "name5",
        "scientificName": "scientificName5",
        "species": "species5",
        "habitat": "habitat5",
        "description": "description5"
    }
]
```

### Update an Existing Animal

#### Request
```
PUT /animals/update/{animalId}

http://localhost:8080/animals/update/52 --data '{"animalId": 52, "name": "updateName3", "scientificName": "scientificName3", "species": "species3", "habitat": "habitat3", "description": "description3"}'
```
#### Response
```
{
    "animalId": 52,
    "name": "updateName3",
    "scientificName": "scientificName3",
    "species": "species3",
    "habitat": "habitat3",
    "description": "description3"
}
```

### Delete and Existing Animal

#### Request
```
DELETE /animals/delete/152

http://localhost:8080/animals/delete/152
```
#### Response
```
[
    {
        "animalId": 1,
        "name": "name1",
        "scientificName": "scientificName1",
        "species": "species",
        "habitat": "habitat1",
        "description": "description1"
    },
    {
        "animalId": 2,
        "name": "updateName2",
        "scientificName": "scientificName32",
        "species": "species2",
        "habitat": "habitat2",
        "description": "description2"
    },
    {
        "animalId": 52,
        "name": "updateName3",
        "scientificName": "scientificName3",
        "species": "species3",
        "habitat": "habitat3",
        "description": "description3"
    }
]
```
