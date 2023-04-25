-- file: 10-create-user-and-db.sql
CREATE USER program WITH PASSWORD 'test';

CREATE DATABASE films;
GRANT ALL PRIVILEGES ON DATABASE films TO program;

CREATE DATABASE cinema;
GRANT ALL PRIVILEGES ON DATABASE cinema TO program;

CREATE DATABASE tickets;
GRANT ALL PRIVILEGES ON DATABASE tickets TO program;


