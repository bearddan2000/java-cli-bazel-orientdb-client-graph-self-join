# java-cli-bazel-orientdb-client-graph-self-join

## Description
A java bazel build, that connects to orientdb database.

Creates a new database `Health` and adds document `Doctor`.

Creates self joins with `edges`.

## Tech stack
- bazel

## Docker stack
- orientdb:latest
- l.gcr.io/google/bazel:latest

## To run
`sudo ./install.sh -u`
- [OrientDB studio](http://localhost:2480/studio/index.html)
  - user: admin
  - password: admin

## To stop (optional)
`sudo ./install.sh -d`

## For help
`sudo ./install.sh -h`

## Credit
- [Source based on](https://gist.github.com/Jaquitori/b9158b0979a8f815c5270cff0e785b00)
- [Create init database](https://orientdb.com/docs/last/java/Document-API-Database.html)
- [Default logins](https://orientdb.com/docs/last/java/Document-API-Database.html)
